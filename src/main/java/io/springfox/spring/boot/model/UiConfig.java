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
package io.springfox.spring.boot.model;

import lombok.Data;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
/**
 * <p>Ui Config.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
public class UiConfig {

    private String apiSorter = "alpha";

    /**
     * 是否启用json编辑器
     **/
    private Boolean jsonEditor = false;
    /**
     * 是否显示请求头信息
     **/
    private Boolean showRequestHeaders = true;
    /**
     * 支持页面提交的请求类型
     **/
    private String submitMethods = "get,post,put,delete,patch";
    /**
     * 请求超时时间
     **/
    private Long requestTimeout = 10000L;

    private Boolean deepLinking;
    private Boolean displayOperationId;
    private Integer defaultModelsExpandDepth;
    private Integer defaultModelExpandDepth;
    private ModelRendering defaultModelRendering;

    /**
     * 是否显示请求耗时，默认false
     */
    private Boolean displayRequestDuration = true;
    /**
     * 可选 none | list
     */
    private DocExpansion docExpansion;
    /**
     * Boolean=false OR String
     */
    private Object filter;
    private Integer maxDisplayedTags;
    private OperationsSorter operationsSorter;
    private Boolean showExtensions;
    private TagsSorter tagsSorter;

    /**
     * Network
     */
    private String validatorUrl;

    /**
     * Returns the api sorter.
     *
     * @return the api sorter
     */
    public String getApiSorter() {
        return apiSorter;
    }

    /**
     * Sets the api sorter.
     *
     * @param apiSorter the api sorter
     */
    public void setApiSorter(String apiSorter) {
        this.apiSorter = apiSorter;
    }

    /**
     * Returns the json editor.
     *
     * @return the json editor
     */
    public Boolean getJsonEditor() {
        return jsonEditor;
    }

    /**
     * Sets the json editor.
     *
     * @param jsonEditor the json editor
     */
    public void setJsonEditor(Boolean jsonEditor) {
        this.jsonEditor = jsonEditor;
    }

    /**
     * Returns the show request headers.
     *
     * @return the show request headers
     */
    public Boolean getShowRequestHeaders() {
        return showRequestHeaders;
    }

    /**
     * Sets the show request headers.
     *
     * @param showRequestHeaders the show request headers
     */
    public void setShowRequestHeaders(Boolean showRequestHeaders) {
        this.showRequestHeaders = showRequestHeaders;
    }

    /**
     * Returns the submit methods.
     *
     * @return the submit methods
     */
    public String getSubmitMethods() {
        return submitMethods;
    }

    /**
     * Sets the submit methods.
     *
     * @param submitMethods the submit methods
     */
    public void setSubmitMethods(String submitMethods) {
        this.submitMethods = submitMethods;
    }

    /**
     * Returns the request timeout.
     *
     * @return the request timeout
     */
    public Long getRequestTimeout() {
        return requestTimeout;
    }

    /**
     * Sets the request timeout.
     *
     * @param requestTimeout the request timeout
     */
    public void setRequestTimeout(Long requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    /**
     * Returns the deep linking.
     *
     * @return the deep linking
     */
    public Boolean getDeepLinking() {
        return deepLinking;
    }

    /**
     * Sets the deep linking.
     *
     * @param deepLinking the deep linking
     */
    public void setDeepLinking(Boolean deepLinking) {
        this.deepLinking = deepLinking;
    }

    /**
     * Returns the display operation id.
     *
     * @return the display operation id
     */
    public Boolean getDisplayOperationId() {
        return displayOperationId;
    }

    /**
     * Sets the display operation id.
     *
     * @param displayOperationId the display operation id
     */
    public void setDisplayOperationId(Boolean displayOperationId) {
        this.displayOperationId = displayOperationId;
    }

    /**
     * Returns the default models expand depth.
     *
     * @return the default models expand depth
     */
    public Integer getDefaultModelsExpandDepth() {
        return defaultModelsExpandDepth;
    }

    /**
     * Sets the default models expand depth.
     *
     * @param defaultModelsExpandDepth the default models expand depth
     */
    public void setDefaultModelsExpandDepth(Integer defaultModelsExpandDepth) {
        this.defaultModelsExpandDepth = defaultModelsExpandDepth;
    }

    /**
     * Returns the default model expand depth.
     *
     * @return the default model expand depth
     */
    public Integer getDefaultModelExpandDepth() {
        return defaultModelExpandDepth;
    }

    /**
     * Sets the default model expand depth.
     *
     * @param defaultModelExpandDepth the default model expand depth
     */
    public void setDefaultModelExpandDepth(Integer defaultModelExpandDepth) {
        this.defaultModelExpandDepth = defaultModelExpandDepth;
    }

    /**
     * Returns the default model rendering.
     *
     * @return the default model rendering
     */
    public ModelRendering getDefaultModelRendering() {
        return defaultModelRendering;
    }

    /**
     * Sets the default model rendering.
     *
     * @param defaultModelRendering the default model rendering
     */
    public void setDefaultModelRendering(ModelRendering defaultModelRendering) {
        this.defaultModelRendering = defaultModelRendering;
    }

    /**
     * Returns the display request duration.
     *
     * @return the display request duration
     */
    public Boolean getDisplayRequestDuration() {
        return displayRequestDuration;
    }

    /**
     * Sets the display request duration.
     *
     * @param displayRequestDuration the display request duration
     */
    public void setDisplayRequestDuration(Boolean displayRequestDuration) {
        this.displayRequestDuration = displayRequestDuration;
    }

    /**
     * Returns the doc expansion.
     *
     * @return the doc expansion
     */
    public DocExpansion getDocExpansion() {
        return docExpansion;
    }

    /**
     * Sets the doc expansion.
     *
     * @param docExpansion the doc expansion
     */
    public void setDocExpansion(DocExpansion docExpansion) {
        this.docExpansion = docExpansion;
    }

    /**
     * Returns the filter.
     *
     * @return the filter
     */
    public Object getFilter() {
        return filter;
    }

    /**
     * Sets the filter.
     *
     * @param filter the filter
     */
    public void setFilter(Object filter) {
        this.filter = filter;
    }

    /**
     * Returns the max displayed tags.
     *
     * @return the max displayed tags
     */
    public Integer getMaxDisplayedTags() {
        return maxDisplayedTags;
    }

    /**
     * Sets the max displayed tags.
     *
     * @param maxDisplayedTags the max displayed tags
     */
    public void setMaxDisplayedTags(Integer maxDisplayedTags) {
        this.maxDisplayedTags = maxDisplayedTags;
    }

    /**
     * Returns the operations sorter.
     *
     * @return the operations sorter
     */
    public OperationsSorter getOperationsSorter() {
        return operationsSorter;
    }

    /**
     * Sets the operations sorter.
     *
     * @param operationsSorter the operations sorter
     */
    public void setOperationsSorter(OperationsSorter operationsSorter) {
        this.operationsSorter = operationsSorter;
    }

    /**
     * Returns the show extensions.
     *
     * @return the show extensions
     */
    public Boolean getShowExtensions() {
        return showExtensions;
    }

    /**
     * Sets the show extensions.
     *
     * @param showExtensions the show extensions
     */
    public void setShowExtensions(Boolean showExtensions) {
        this.showExtensions = showExtensions;
    }

    /**
     * Returns the tags sorter.
     *
     * @return the tags sorter
     */
    public TagsSorter getTagsSorter() {
        return tagsSorter;
    }

    /**
     * Sets the tags sorter.
     *
     * @param tagsSorter the tags sorter
     */
    public void setTagsSorter(TagsSorter tagsSorter) {
        this.tagsSorter = tagsSorter;
    }

    /**
     * Returns the validator url.
     *
     * @return the validator url
     */
    public String getValidatorUrl() {
        return validatorUrl;
    }

    /**
     * Sets the validator url.
     *
     * @param validatorUrl the validator url
     */
    public void setValidatorUrl(String validatorUrl) {
        this.validatorUrl = validatorUrl;
    }
    
}