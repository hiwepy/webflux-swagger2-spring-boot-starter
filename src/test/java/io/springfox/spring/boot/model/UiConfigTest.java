package io.springfox.spring.boot.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("UiConfig Tests")
class UiConfigTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        UiConfig config = new UiConfig();
        assertThat(config).isNotNull();
    }

    @Test
    @DisplayName("Field 'apiSorter' can be set and read")
    void testApiSorterField() {
        UiConfig config = new UiConfig();
        assertThat(config.getApiSorter()).isEqualTo("alpha");
        config.setApiSorter("method");
        assertThat(config.getApiSorter()).isEqualTo("method");
    }

    @Test
    @DisplayName("Field 'jsonEditor' can be set and read")
    void testJsonEditorField() {
        UiConfig config = new UiConfig();
        assertThat(config.getJsonEditor()).isFalse();
        config.setJsonEditor(true);
        assertThat(config.getJsonEditor()).isTrue();
    }

    @Test
    @DisplayName("Field 'showRequestHeaders' can be set and read")
    void testShowRequestHeadersField() {
        UiConfig config = new UiConfig();
        assertThat(config.getShowRequestHeaders()).isTrue();
        config.setShowRequestHeaders(false);
        assertThat(config.getShowRequestHeaders()).isFalse();
    }

    @Test
    @DisplayName("Field 'submitMethods' can be set and read")
    void testSubmitMethodsField() {
        UiConfig config = new UiConfig();
        assertThat(config.getSubmitMethods()).isEqualTo("get,post,put,delete,patch");
        config.setSubmitMethods("get,post");
        assertThat(config.getSubmitMethods()).isEqualTo("get,post");
    }

    @Test
    @DisplayName("Field 'requestTimeout' can be set and read")
    void testRequestTimeoutField() {
        UiConfig config = new UiConfig();
        assertThat(config.getRequestTimeout()).isEqualTo(10000L);
        config.setRequestTimeout(5000L);
        assertThat(config.getRequestTimeout()).isEqualTo(5000L);
    }

    @Test
    @DisplayName("Field 'deepLinking' can be set and read")
    void testDeepLinkingField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDeepLinking()).isNull();
        config.setDeepLinking(true);
        assertThat(config.getDeepLinking()).isTrue();
    }

    @Test
    @DisplayName("Field 'displayOperationId' can be set and read")
    void testDisplayOperationIdField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDisplayOperationId()).isNull();
        config.setDisplayOperationId(true);
        assertThat(config.getDisplayOperationId()).isTrue();
    }

    @Test
    @DisplayName("Field 'defaultModelsExpandDepth' can be set and read")
    void testDefaultModelsExpandDepthField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDefaultModelsExpandDepth()).isNull();
        config.setDefaultModelsExpandDepth(1);
        assertThat(config.getDefaultModelsExpandDepth()).isEqualTo(1);
    }

    @Test
    @DisplayName("Field 'defaultModelExpandDepth' can be set and read")
    void testDefaultModelExpandDepthField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDefaultModelExpandDepth()).isNull();
        config.setDefaultModelExpandDepth(2);
        assertThat(config.getDefaultModelExpandDepth()).isEqualTo(2);
    }

    @Test
    @DisplayName("Field 'defaultModelRendering' can be set and read")
    void testDefaultModelRenderingField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDefaultModelRendering()).isNull();
        config.setDefaultModelRendering(ModelRendering.EXAMPLE);
        assertThat(config.getDefaultModelRendering()).isEqualTo(ModelRendering.EXAMPLE);
    }

    @Test
    @DisplayName("Field 'displayRequestDuration' can be set and read")
    void testDisplayRequestDurationField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDisplayRequestDuration()).isTrue();
        config.setDisplayRequestDuration(false);
        assertThat(config.getDisplayRequestDuration()).isFalse();
    }

    @Test
    @DisplayName("Field 'docExpansion' can be set and read")
    void testDocExpansionField() {
        UiConfig config = new UiConfig();
        assertThat(config.getDocExpansion()).isNull();
        config.setDocExpansion(DocExpansion.LIST);
        assertThat(config.getDocExpansion()).isEqualTo(DocExpansion.LIST);
    }

    @Test
    @DisplayName("Field 'filter' can be set and read")
    void testFilterField() {
        UiConfig config = new UiConfig();
        assertThat(config.getFilter()).isNull();
        config.setFilter("test");
        assertThat(config.getFilter()).isEqualTo("test");
    }

    @Test
    @DisplayName("Field 'maxDisplayedTags' can be set and read")
    void testMaxDisplayedTagsField() {
        UiConfig config = new UiConfig();
        assertThat(config.getMaxDisplayedTags()).isNull();
        config.setMaxDisplayedTags(10);
        assertThat(config.getMaxDisplayedTags()).isEqualTo(10);
    }

    @Test
    @DisplayName("Field 'operationsSorter' can be set and read")
    void testOperationsSorterField() {
        UiConfig config = new UiConfig();
        assertThat(config.getOperationsSorter()).isNull();
        config.setOperationsSorter(OperationsSorter.METHOD);
        assertThat(config.getOperationsSorter()).isEqualTo(OperationsSorter.METHOD);
    }

    @Test
    @DisplayName("Field 'showExtensions' can be set and read")
    void testShowExtensionsField() {
        UiConfig config = new UiConfig();
        assertThat(config.getShowExtensions()).isNull();
        config.setShowExtensions(true);
        assertThat(config.getShowExtensions()).isTrue();
    }

    @Test
    @DisplayName("Field 'tagsSorter' can be set and read")
    void testTagsSorterField() {
        UiConfig config = new UiConfig();
        assertThat(config.getTagsSorter()).isNull();
        config.setTagsSorter(TagsSorter.ALPHA);
        assertThat(config.getTagsSorter()).isEqualTo(TagsSorter.ALPHA);
    }

    @Test
    @DisplayName("Field 'validatorUrl' can be set and read")
    void testValidatorUrlField() {
        UiConfig config = new UiConfig();
        assertThat(config.getValidatorUrl()).isNull();
        config.setValidatorUrl("https://validator.example.com");
        assertThat(config.getValidatorUrl()).isEqualTo("https://validator.example.com");
    }
}
