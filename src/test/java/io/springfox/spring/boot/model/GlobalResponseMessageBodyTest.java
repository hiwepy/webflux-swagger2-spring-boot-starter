package io.springfox.spring.boot.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GlobalResponseMessageBody Tests")
class GlobalResponseMessageBodyTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        GlobalResponseMessageBody body = new GlobalResponseMessageBody();
        assertThat(body).isNotNull();
    }

    @Test
    @DisplayName("Fields can be set and read")
    void testFields() {
        GlobalResponseMessageBody body = new GlobalResponseMessageBody();
        body.setCode("200");
        body.setMessage("OK");
        body.setModelRef("Model");
        assertThat(body.getCode()).isEqualTo("200");
        assertThat(body.getMessage()).isEqualTo("OK");
        assertThat(body.getModelRef()).isEqualTo("Model");
    }
}
