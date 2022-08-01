/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.springfox.spring.boot;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import io.springfox.spring.boot.extend.ExtendServiceModelToSwagger2MapperImpl;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.utils.Swagger2Utils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.result.method.RequestMappingInfoHandlerMapping;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

/**
 * 参考https://my.oschina.net/go4it/blog/3035218
 * 部分代码来来自：https://github.com/SpringForAll/spring-boot-starter-swagger
 * @author ： <a href="https://github.com/hiwepy">hiwepy</a>
 */
@Configuration
@ConditionalOnProperty(prefix = Swagger2WebFluxProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ Swagger2WebFluxProperties.class })
@EnableSwagger2WebFlux
@Import({ BeanValidatorPluginsConfiguration.class })
public class Swagger2WebFluxAutoConfiguration implements BeanFactoryAware {

	private BeanFactory beanFactory;

	@Bean
	public Swagger2UiWebFluxConfigurer swagger2UiWebFluxConfigurer() {
		return new Swagger2UiWebFluxConfigurer();
	}
	
	@Primary
	@Bean
	public ServiceModelToSwagger2Mapper ServiceModelToSwagger2Mapper() {
		return new ExtendServiceModelToSwagger2MapperImpl();
	}
	
	@Bean
	public UiConfiguration uiConfiguration(Swagger2WebFluxProperties swaggerProperties) {
		return UiConfigurationBuilder.builder()
				.deepLinking(swaggerProperties.getUiConfig().getDeepLinking())
				.defaultModelExpandDepth(swaggerProperties.getUiConfig().getDefaultModelExpandDepth())
				.defaultModelRendering(swaggerProperties.getUiConfig().getDefaultModelRendering())
				.defaultModelsExpandDepth(swaggerProperties.getUiConfig().getDefaultModelsExpandDepth())
				.displayOperationId(swaggerProperties.getUiConfig().getDisplayOperationId())
				.displayRequestDuration(swaggerProperties.getUiConfig().getDisplayRequestDuration())
				.docExpansion(swaggerProperties.getUiConfig().getDocExpansion())
				.maxDisplayedTags(swaggerProperties.getUiConfig().getMaxDisplayedTags())
				.operationsSorter(swaggerProperties.getUiConfig().getOperationsSorter())
				.showExtensions(swaggerProperties.getUiConfig().getShowExtensions())
				.tagsSorter(swaggerProperties.getUiConfig().getTagsSorter())
				.validatorUrl(swaggerProperties.getUiConfig().getValidatorUrl())
				.build();
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(UiConfiguration.class)
	@ConditionalOnProperty(prefix = Swagger2WebFluxProperties.PREFIX, name = "enabled", matchIfMissing = true)
	public List<Docket> createRestApi(Swagger2WebFluxProperties swaggerProperties) {
		ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
		List<Docket> docketList = new LinkedList<>();

		Docket defaultDocket = Swagger2Utils.defaultDocket(swaggerProperties);
		
		configurableBeanFactory.registerSingleton("defaultDocket", defaultDocket);
		docketList.add(defaultDocket);
		
		// 分组创建
		for (DocketInfo docketInfo : swaggerProperties.getGroups()) {
			
			String groupName = String.format("%sDocket", docketInfo.getName());
			
			Docket groupDocket = Swagger2Utils.groupDocket(docketInfo, swaggerProperties);
			
			configurableBeanFactory.registerSingleton(groupName, groupDocket);
			docketList.add(groupDocket);
			
		}
		
		return docketList;
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	/** 解决不兼容问题
	 * https://developer.aliyun.com/article/950787
	 * https://github.com/springfox/springfox/issues/3462?spm=a2c6h.12873639.article-detail.6.1f714b49B4FXeZ
	 * @return BeanPostProcessor
	 */
	@Bean
	public static BeanPostProcessor springfoxHandlerProviderBeanWebFluxPostProcessor() {
		return new BeanPostProcessor() {

			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				if (bean instanceof WebFluxRequestHandlerProvider) {
					customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
				}
				return bean;
			}

			private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
				List<T> copy = mappings.stream()
						.filter(mapping -> mapping.getPathPatternParser() == null)
						.collect(Collectors.toList());
				mappings.clear();
				mappings.addAll(copy);
			}

			@SuppressWarnings("unchecked")
			private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
				try {
					Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
					field.setAccessible(true);
					return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new IllegalStateException(e);
				}
			}
		};
	}

}