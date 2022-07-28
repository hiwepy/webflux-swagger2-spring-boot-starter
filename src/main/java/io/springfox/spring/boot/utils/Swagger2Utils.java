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
package io.springfox.spring.boot.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import io.springfox.spring.boot.Swagger2WebFluxProperties;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.model.GlobalOperationParameter;
import io.springfox.spring.boot.model.GlobalResponseMessage;
import io.springfox.spring.boot.model.GlobalResponseMessageBody;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;

/*
 * TODO
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */

public class Swagger2Utils {

	public static ApiInfo apiInfo(Swagger2WebFluxProperties swaggerProperties) {
 		return new ApiInfoBuilder()
				.title(swaggerProperties.getTitle())
				.description(swaggerProperties.getDescription())
				.version(swaggerProperties.getVersion())
				.license(swaggerProperties.getLicense())
				.licenseUrl(swaggerProperties.getLicenseUrl())
				.contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
				.termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
				.build();
	}
	
	public static ApiInfo apiInfo(DocketInfo docketInfo, Swagger2WebFluxProperties swaggerProperties) {
 		return new ApiInfoBuilder()
				.title(StringUtils.hasText(docketInfo.getTitle()) ? swaggerProperties.getTitle() : docketInfo.getTitle())
				.description(StringUtils.hasText(docketInfo.getDescription()) ? swaggerProperties.getDescription() : docketInfo.getDescription())
				.version(StringUtils.hasText(docketInfo.getVersion()) ? swaggerProperties.getVersion() : docketInfo.getVersion())
				.license(StringUtils.hasText(docketInfo.getLicense()) ? swaggerProperties.getLicense() : docketInfo.getLicense())
				.licenseUrl(StringUtils.hasText(docketInfo.getLicenseUrl()) ? swaggerProperties.getLicenseUrl() : docketInfo.getLicenseUrl())
				.contact(new Contact(
						StringUtils.hasText(docketInfo.getContact().getName()) ? swaggerProperties.getContact().getName() : docketInfo.getContact().getName(),
						StringUtils.hasText(docketInfo.getContact().getUrl()) ? swaggerProperties.getContact().getUrl() : docketInfo.getContact().getUrl(),
						StringUtils.hasText(docketInfo.getContact().getEmail()) ? swaggerProperties.getContact().getEmail() : docketInfo.getContact().getEmail()))
				.termsOfServiceUrl(
						StringUtils.hasText(docketInfo.getTermsOfServiceUrl()) ? swaggerProperties.getTermsOfServiceUrl() : docketInfo.getTermsOfServiceUrl())
				.build();
	}
	
	public static Docket defaultDocket(Swagger2WebFluxProperties swaggerProperties) {
		
		Docket docketForBuilder = new Docket(DocumentationType.SWAGGER_2)
				.host(swaggerProperties.getHost())
				.apiInfo(apiInfo(swaggerProperties))
				.securityContexts(Collections.singletonList(securityContext(swaggerProperties)))
				.globalOperationParameters(buildGlobalOperationParametersFromSwagger2WebFluxProperties( swaggerProperties.getGlobalOperationParameters()));

		switch (swaggerProperties.getAuthorization().getType()) {
			case APIKEY:{
				docketForBuilder.securitySchemes(Collections.singletonList(apiKey(swaggerProperties)));
			};break;
			case BASICAUTH:{
				docketForBuilder.securitySchemes(Collections.singletonList(basicAuth(swaggerProperties)));
			};break;
			default:{
				
			};break;
		}

		// 全局响应消息
		if (!swaggerProperties.isApplyDefaultResponseMessages()) {
			buildGlobalResponseMessage(swaggerProperties, docketForBuilder);
		}
		
		// RequestHandlerSelectors.basePackage(basePackage)
		// PathSelectors.ant(antPattern)
		
		Docket docket = docketForBuilder.select()
				.apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
				.paths(StringUtils.hasText(swaggerProperties.getBasePathPattern()) ? PathSelectors.ant(swaggerProperties.getBasePathPattern()) : PathSelectors.any())
				.build();

		/* ignoredParameterTypes **/
		Class<?>[] array = new Class[swaggerProperties.getIgnoredParameterTypes().size()];
		Class<?>[] ignoredParameterTypes = swaggerProperties.getIgnoredParameterTypes().toArray(array);
		docket.ignoredParameterTypes(ignoredParameterTypes)
				.enableUrlTemplating(swaggerProperties.isEnableUrlTemplating())
				.forCodeGeneration(swaggerProperties.isForCodeGen());

		return docket;
		
	}
	
	public static Docket groupDocket(DocketInfo docketInfo, Swagger2WebFluxProperties swaggerProperties) {

		Docket docketForBuilder = new Docket(DocumentationType.SWAGGER_2)
				.host(swaggerProperties.getHost())
				.apiInfo(apiInfo(docketInfo, swaggerProperties))
				.securityContexts(Collections.singletonList(securityContext(swaggerProperties)))
				.globalOperationParameters(assemblyGlobalOperationParameters(swaggerProperties.getGlobalOperationParameters(), docketInfo.getGlobalOperationParameters()));

		switch (swaggerProperties.getAuthorization().getType()) {
			case APIKEY:{
				docketForBuilder.securitySchemes(Collections.singletonList(apiKey(swaggerProperties)));
			};break;
			case BASICAUTH:{
				docketForBuilder.securitySchemes(Collections.singletonList(basicAuth(swaggerProperties)));
			};break;
			default:{
				
			};break;
		}

		// 全局响应消息
		if (!swaggerProperties.isApplyDefaultResponseMessages()) {
			buildGlobalResponseMessage(swaggerProperties, docketForBuilder);
		}
		
		Docket docket = docketForBuilder.groupName(docketInfo.getName()).select()
				.apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage()))
				.paths(StringUtils.hasText(docketInfo.getBasePathPattern()) ? PathSelectors.ant(docketInfo.getBasePathPattern()) : PathSelectors.any())
				.build();

		/* ignoredParameterTypes **/
		Class<?>[] array = new Class[docketInfo.getIgnoredParameterTypes().size()];
		Class<?>[] ignoredParameterTypes = docketInfo.getIgnoredParameterTypes().toArray(array);
		docket.ignoredParameterTypes(ignoredParameterTypes)
				.enableUrlTemplating(docketInfo.isEnableUrlTemplating())
				.forCodeGeneration(docketInfo.isForCodeGen());
		
		return docket;
	}
	

	/*
	 * 配置基于 ApiKey 的鉴权对象
	 *
	 * @return
	 */
	public static ApiKey apiKey(Swagger2WebFluxProperties swaggerProperties) {
		return new ApiKey(swaggerProperties.getAuthorization().getName(),
				swaggerProperties.getAuthorization().getKeyName(), ApiKeyVehicle.HEADER.getValue());
	}

	/*
	 * 配置基于 BasicAuth 的鉴权对象
	 *
	 * @return
	 */
	public static BasicAuth basicAuth(Swagger2WebFluxProperties swaggerProperties) {
		return new BasicAuth(swaggerProperties.getAuthorization().getName());
	}

	/*
	 * 配置默认的全局鉴权策略的开关，以及通过正则表达式进行匹配；默认 ^.*$ 匹配所有URL 其中 securityReferences 为配置启用的鉴权策略
	 *
	 * @return
	 */
	public static SecurityContext securityContext(Swagger2WebFluxProperties swaggerProperties) {
		return SecurityContext.builder().securityReferences(defaultAuth(swaggerProperties))
				.forPaths(PathSelectors.regex(swaggerProperties.getAuthorization().getAuthRegex())).build();
	}

	/*
	 * 配置默认的全局鉴权策略；其中返回的 SecurityReference 中，reference
	 * 即为ApiKey对象里面的name，保持一致才能开启全局鉴权
	 *
	 * @return
	 */
	public static List<SecurityReference> defaultAuth(Swagger2WebFluxProperties swaggerProperties) {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Collections.singletonList(SecurityReference.builder()
				.reference(swaggerProperties.getAuthorization().getName()).scopes(authorizationScopes).build());
	}

	public static List<Parameter> buildGlobalOperationParametersFromSwagger2WebFluxProperties(
			List<GlobalOperationParameter> globalOperationParameters) {
		List<Parameter> parameters = new ArrayList<Parameter>();

		if (Objects.isNull(globalOperationParameters)) {
			return parameters;
		}
		for (GlobalOperationParameter globalOperationParameter : globalOperationParameters) {
			parameters.add(new ParameterBuilder().name(globalOperationParameter.getName())
					.description(globalOperationParameter.getDescription())
					.defaultValue(globalOperationParameter.getDefaultValue())
					.allowEmptyValue(globalOperationParameter.isAllowEmptyValue())
					.scalarExample(globalOperationParameter.getScalarExample())
					.modelRef(new ModelRef(globalOperationParameter.getModelRef()))
					.parameterType(globalOperationParameter.getParameterType())
					.pattern(globalOperationParameter.getPattern())
					.hidden(globalOperationParameter.isHidden())
					.required(globalOperationParameter.isRequired())
					.build());
		}
		return parameters;
	}

	/*
	 * 局部参数按照name覆盖局部参数
	 *
	 * @param globalOperationParameters  全局参数
	 * @param docketOperationParameters  当前分组参数
	 * @return List<Parameter> 
	 */
	public static List<Parameter> assemblyGlobalOperationParameters(List<GlobalOperationParameter> globalOperationParameters,
			List<GlobalOperationParameter> docketOperationParameters) {

		if (Objects.isNull(docketOperationParameters) || docketOperationParameters.isEmpty()) {
			return buildGlobalOperationParametersFromSwagger2WebFluxProperties(globalOperationParameters);
		}

		Set<String> docketNames = docketOperationParameters.stream().map(GlobalOperationParameter::getName)
				.collect(Collectors.toSet());

		List<GlobalOperationParameter> resultOperationParameters = new ArrayList<GlobalOperationParameter>();

		if (Objects.nonNull(globalOperationParameters)) {
			for (GlobalOperationParameter parameter : globalOperationParameters) {
				if (!docketNames.contains(parameter.getName())) {
					resultOperationParameters.add(parameter);
				}
			}
		}

		resultOperationParameters.addAll(docketOperationParameters);
		return buildGlobalOperationParametersFromSwagger2WebFluxProperties(resultOperationParameters);
	}

	/*
	 * 设置全局响应消息
	 *
	 * @param swaggerProperties swaggerProperties 支持 POST,GET,PUT,PATCH,DELETE,HEAD,OPTIONS,TRACE
	 * @param docketForBuilder  swagger docket builder
	 */
	public static void buildGlobalResponseMessage(Swagger2WebFluxProperties swaggerProperties, Docket docketForBuilder) {

		GlobalResponseMessage globalResponseMessages = swaggerProperties.getGlobalResponseMessage();

		/* POST,GET,PUT,PATCH,DELETE,HEAD,OPTIONS,TRACE 响应消息体 **/
		List<ResponseMessage> postResponseMessages = getResponseMessageList(globalResponseMessages.getPost());
		List<ResponseMessage> getResponseMessages = getResponseMessageList(globalResponseMessages.getGet());
		List<ResponseMessage> putResponseMessages = getResponseMessageList(globalResponseMessages.getPut());
		List<ResponseMessage> patchResponseMessages = getResponseMessageList(globalResponseMessages.getPatch());
		List<ResponseMessage> deleteResponseMessages = getResponseMessageList(globalResponseMessages.getDelete());
		List<ResponseMessage> headResponseMessages = getResponseMessageList(globalResponseMessages.getHead());
		List<ResponseMessage> optionsResponseMessages = getResponseMessageList(globalResponseMessages.getOptions());
		List<ResponseMessage> trackResponseMessages = getResponseMessageList(globalResponseMessages.getTrace());

		docketForBuilder.useDefaultResponseMessages(swaggerProperties.isApplyDefaultResponseMessages())
				.globalResponseMessage(RequestMethod.POST, postResponseMessages)
				.globalResponseMessage(RequestMethod.GET, getResponseMessages)
				.globalResponseMessage(RequestMethod.PUT, putResponseMessages)
				.globalResponseMessage(RequestMethod.PATCH, patchResponseMessages)
				.globalResponseMessage(RequestMethod.DELETE, deleteResponseMessages)
				.globalResponseMessage(RequestMethod.HEAD, headResponseMessages)
				.globalResponseMessage(RequestMethod.OPTIONS, optionsResponseMessages)
				.globalResponseMessage(RequestMethod.TRACE, trackResponseMessages);
	}

	/*
	 * 获取返回消息体列表
	 * @param globalResponseMessageBodyList 全局Code消息返回集合
	 * @return
	 */
	public static List<ResponseMessage> getResponseMessageList(
			List<GlobalResponseMessageBody> globalResponseMessageBodyList) {
		List<ResponseMessage> responseMessages = new ArrayList<>();
		for (GlobalResponseMessageBody globalResponseMessageBody : globalResponseMessageBodyList) {
			ResponseMessageBuilder responseMessageBuilder = new ResponseMessageBuilder();
			responseMessageBuilder.code(globalResponseMessageBody.getCode()).message(globalResponseMessageBody.getMessage());

			if (!StringUtils.isEmpty(globalResponseMessageBody.getModelRef())) {
				responseMessageBuilder.responseModel(new ModelRef(globalResponseMessageBody.getModelRef()));
			}
			responseMessages.add(responseMessageBuilder.build());
		}

		return responseMessages;
	}
	
}
