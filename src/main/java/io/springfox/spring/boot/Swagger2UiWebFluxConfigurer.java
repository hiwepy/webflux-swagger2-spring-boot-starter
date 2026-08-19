package io.springfox.spring.boot;

import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.resource.LiteWebJarsResourceResolver;

/**
 * http://springfox.github.io/springfox/docs/current/#history
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class Swagger2UiWebFluxConfigurer implements WebFluxConfigurer {
	
	private final String META_INF_RESOURCES = "classpath:/META-INF/resources/";
	private final String META_INF_WEBJAR_RESOURCES = META_INF_RESOURCES + "webjars/";
	private final String META_INF_SPRINGFOX_SWAGGER_UI_RESOURCES = META_INF_WEBJAR_RESOURCES + "springfox-swagger-ui/";
	
	@Override
	/**
	 * add Resource Handlers.
	 *
	 * @param registry the registry
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations(META_INF_SPRINGFOX_SWAGGER_UI_RESOURCES).resourceChain(false);
		registry.addResourceHandler("/doc.html").addResourceLocations(META_INF_RESOURCES).resourceChain(false);
		if(!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations(META_INF_WEBJAR_RESOURCES)
				.resourceChain(false).addResolver(new LiteWebJarsResourceResolver());
		}
	}
	
}
