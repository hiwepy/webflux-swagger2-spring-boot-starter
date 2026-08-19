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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.springfox.spring.boot.model.Authorization;
import io.springfox.spring.boot.model.Contact;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.model.GlobalOperationParameter;
import io.springfox.spring.boot.model.GlobalResponseMessage;
import io.springfox.spring.boot.model.UiConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConfigurationProperties(Swagger2WebFluxProperties.PREFIX)
@Getter
@Setter
@ToString
public class Swagger2WebFluxProperties {

	public static final String PREFIX = "swagger";
	
	/**
	 * 是否开启swagger
	 **/
	private boolean enabled;
	/**
	 * when true it enables rfc6570 url templates
	 */
	private boolean enableUrlTemplating = false;
	/**
	 * Set this to true in order to make the documentation code generation friendly.
	 *
	 * true|false determines the naming strategy used
	 */
	private boolean forCodeGen = false;
	/**
	 * 标题
	 **/
	private String title = "";
	/**
	 * 描述
	 **/
	private String description = "";
	/**
	 * 版本
	 **/
	private String version = "";
	/**
	 * 许可证
	 **/
	private String license = "";
	/**
	 * 许可证URL
	 **/
	private String licenseUrl = "";
	/**
	 * 服务条款URL
	 **/
	private String termsOfServiceUrl = "";

	/**
	 * 忽略的参数类型
	 **/
	private List<Class<?>> ignoredParameterTypes = new ArrayList<>();

	private Contact contact = new Contact();

	/**
	 * swagger会解析的包路径
	 **/
	private String basePackage = "";

	/**
     * swagger会解析的url规则:ant表达式
     **/
    private String basePathPattern = "";

	/**
	 * 分组文档
	 **/
	private Map<String, DocketInfo> docket = new LinkedHashMap<>();

	/**
	 * host信息
	 **/
	private String host = "";

	/**
	 * 全局参数配置
	 **/
	private List<GlobalOperationParameter> globalOperationParameters;

	/**
	 * 页面功能配置
	 **/
	private UiConfig uiConfig = new UiConfig();

	/**
	 * 是否使用默认预定义的响应消息 ，默认 true
	 **/
	private boolean applyDefaultResponseMessages = true;

	/**
	 * 全局响应消息
	 **/
	private GlobalResponseMessage globalResponseMessage;

	/**
	 * 全局统一鉴权配置
	 **/
	private Authorization authorization = new Authorization();

	/**
	 * Returns the enabled.
	 *
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Returns the enable url templating.
	 *
	 * @return the enable url templating
	 */
	public boolean isEnableUrlTemplating() {
		return enableUrlTemplating;
	}

	/**
	 * Sets the enable url templating.
	 *
	 * @param enableUrlTemplating the enable url templating
	 */
	public void setEnableUrlTemplating(boolean enableUrlTemplating) {
		this.enableUrlTemplating = enableUrlTemplating;
	}

	/**
	 * Returns the for code gen.
	 *
	 * @return the for code gen
	 */
	public boolean isForCodeGen() {
		return forCodeGen;
	}

	/**
	 * Sets the for code gen.
	 *
	 * @param forCodeGen the for code gen
	 */
	public void setForCodeGen(boolean forCodeGen) {
		this.forCodeGen = forCodeGen;
	}

	/**
	 * Returns the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Returns the license.
	 *
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Sets the license.
	 *
	 * @param license the license
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * Returns the license url.
	 *
	 * @return the license url
	 */
	public String getLicenseUrl() {
		return licenseUrl;
	}

	/**
	 * Sets the license url.
	 *
	 * @param licenseUrl the license url
	 */
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	/**
	 * Returns the terms of service url.
	 *
	 * @return the terms of service url
	 */
	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	/**
	 * Sets the terms of service url.
	 *
	 * @param termsOfServiceUrl the terms of service url
	 */
	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	/**
	 * Returns the ignored parameter types.
	 *
	 * @return the ignored parameter types
	 */
	public List<Class<?>> getIgnoredParameterTypes() {
		return ignoredParameterTypes;
	}

	/**
	 * Sets the ignored parameter types.
	 *
	 * @param ignoredParameterTypes the ignored parameter types
	 */
	public void setIgnoredParameterTypes(List<Class<?>> ignoredParameterTypes) {
		this.ignoredParameterTypes = ignoredParameterTypes;
	}

	/**
	 * Returns the contact.
	 *
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Returns the base package.
	 *
	 * @return the base package
	 */
	public String getBasePackage() {
		return basePackage;
	}

	/**
	 * Sets the base package.
	 *
	 * @param basePackage the base package
	 */
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	/**
	 * Returns the base path pattern.
	 *
	 * @return the base path pattern
	 */
	public String getBasePathPattern() {
		return basePathPattern;
	}

	/**
	 * Sets the base path pattern.
	 *
	 * @param basePathPattern the base path pattern
	 */
	public void setBasePathPattern(String basePathPattern) {
		this.basePathPattern = basePathPattern;
	}

	public Map<String, DocketInfo> getDocket() {
		return docket;
	}

	/**
	 * Sets the docket.
	 *
	 * @param docket the docket
	 */
	public void setDocket(Map<String, DocketInfo> docket) {
		this.docket = docket;
	}

	/**
	 * Returns the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 *
	 * @param host the host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Returns the global operation parameters.
	 *
	 * @return the global operation parameters
	 */
	public List<GlobalOperationParameter> getGlobalOperationParameters() {
		return globalOperationParameters;
	}

	/**
	 * Sets the global operation parameters.
	 *
	 * @param globalOperationParameters the global operation parameters
	 */
	public void setGlobalOperationParameters(List<GlobalOperationParameter> globalOperationParameters) {
		this.globalOperationParameters = globalOperationParameters;
	}

	/**
	 * Returns the ui config.
	 *
	 * @return the ui config
	 */
	public UiConfig getUiConfig() {
		return uiConfig;
	}

	/**
	 * Sets the ui config.
	 *
	 * @param uiConfig the ui config
	 */
	public void setUiConfig(UiConfig uiConfig) {
		this.uiConfig = uiConfig;
	}

	/**
	 * Returns the apply default response messages.
	 *
	 * @return the apply default response messages
	 */
	public boolean isApplyDefaultResponseMessages() {
		return applyDefaultResponseMessages;
	}

	/**
	 * Sets the apply default response messages.
	 *
	 * @param applyDefaultResponseMessages the apply default response messages
	 */
	public void setApplyDefaultResponseMessages(boolean applyDefaultResponseMessages) {
		this.applyDefaultResponseMessages = applyDefaultResponseMessages;
	}

	/**
	 * Returns the global response message.
	 *
	 * @return the global response message
	 */
	public GlobalResponseMessage getGlobalResponseMessage() {
		return globalResponseMessage;
	}

	/**
	 * Sets the global response message.
	 *
	 * @param globalResponseMessage the global response message
	 */
	public void setGlobalResponseMessage(GlobalResponseMessage globalResponseMessage) {
		this.globalResponseMessage = globalResponseMessage;
	}

	/**
	 * Returns the authorization.
	 *
	 * @return the authorization
	 */
	public Authorization getAuthorization() {
		return authorization;
	}

	/**
	 * Sets the authorization.
	 *
	 * @param authorization the authorization
	 */
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	
}
