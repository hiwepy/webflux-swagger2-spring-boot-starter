package io.springfox.spring.boot.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GlobalOperationParameter Tests")
class GlobalOperationParameterTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        GlobalOperationParameter param = new GlobalOperationParameter();
        assertThat(param).isNotNull();
    }

    @Test
    @DisplayName("Fields can be set and read")
    void testFields() {
        GlobalOperationParameter param = new GlobalOperationParameter();
        param.setName("X-Request-ID");
        param.setDescription("Request ID");
        param.setParameterType("header");
        param.setRequired(true);
        param.setHidden(false);
        param.setPattern(".*");
        assertThat(param.getName()).isEqualTo("X-Request-ID");
        assertThat(param.getDescription()).isEqualTo("Request ID");
        assertThat(param.getParameterType()).isEqualTo("header");
        assertThat(param.isRequired()).isTrue();
        assertThat(param.isHidden()).isFalse();
        assertThat(param.getPattern()).isEqualTo(".*");
    }
}
