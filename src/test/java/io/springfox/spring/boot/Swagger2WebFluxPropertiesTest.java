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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.springfox.spring.boot.model.Authorization;
import io.springfox.spring.boot.model.Contact;
import io.springfox.spring.boot.model.DocketInfo;
import io.springfox.spring.boot.model.GlobalOperationParameter;
import io.springfox.spring.boot.model.GlobalResponseMessage;
import io.springfox.spring.boot.model.UiConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {{ @link Swagger2WebFluxProperties }}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("Swagger2WebFluxProperties Tests")
class Swagger2WebFluxPropertiesTest {

    @Test
    @DisplayName("Default constructor creates non-null instance")
    void testDefaultInstance() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props).isNotNull();
    }

    @Test
    @DisplayName("Field 'enabled' can be set and read")
    void testEnabledField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.isEnabled()).isFalse();
        props.setEnabled(true);
        assertThat(props.isEnabled()).isTrue();
    }

    @Test
    @DisplayName("Field 'enableUrlTemplating' can be set and read")
    void testEnableUrlTemplatingField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.isEnableUrlTemplating()).isFalse();
        props.setEnableUrlTemplating(true);
        assertThat(props.isEnableUrlTemplating()).isTrue();
    }

    @Test
    @DisplayName("Field 'forCodeGen' can be set and read")
    void testForCodeGenField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.isForCodeGen()).isFalse();
        props.setForCodeGen(true);
        assertThat(props.isForCodeGen()).isTrue();
    }

    @Test
    @DisplayName("Field 'title' can be set and read")
    void testTitleField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getTitle()).isEqualTo("");
        props.setTitle("My API");
        assertThat(props.getTitle()).isEqualTo("My API");
    }

    @Test
    @DisplayName("Field 'description' can be set and read")
    void testDescriptionField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getDescription()).isEqualTo("");
        props.setDescription("API Description");
        assertThat(props.getDescription()).isEqualTo("API Description");
    }

    @Test
    @DisplayName("Field 'version' can be set and read")
    void testVersionField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getVersion()).isEqualTo("");
        props.setVersion("1.0.0");
        assertThat(props.getVersion()).isEqualTo("1.0.0");
    }

    @Test
    @DisplayName("Field 'license' can be set and read")
    void testLicenseField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getLicense()).isEqualTo("");
        props.setLicense("Apache 2.0");
        assertThat(props.getLicense()).isEqualTo("Apache 2.0");
    }

    @Test
    @DisplayName("Field 'licenseUrl' can be set and read")
    void testLicenseUrlField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getLicenseUrl()).isEqualTo("");
        props.setLicenseUrl("https://example.com/license");
        assertThat(props.getLicenseUrl()).isEqualTo("https://example.com/license");
    }

    @Test
    @DisplayName("Field 'termsOfServiceUrl' can be set and read")
    void testTermsOfServiceUrlField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getTermsOfServiceUrl()).isEqualTo("");
        props.setTermsOfServiceUrl("https://example.com/tos");
        assertThat(props.getTermsOfServiceUrl()).isEqualTo("https://example.com/tos");
    }

    @Test
    @DisplayName("Field 'ignoredParameterTypes' can be set and read")
    void testIgnoredParameterTypesField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getIgnoredParameterTypes()).isNotNull().isEmpty();
        List<Class<?>> types = new ArrayList<>();
        types.add(String.class);
        props.setIgnoredParameterTypes(types);
        assertThat(props.getIgnoredParameterTypes()).containsExactly(String.class);
    }

    @Test
    @DisplayName("Field 'contact' can be set and read")
    void testContactField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getContact()).isNotNull();
        Contact contact = new Contact();
        props.setContact(contact);
        assertThat(props.getContact()).isSameAs(contact);
    }

    @Test
    @DisplayName("Field 'basePackage' can be set and read")
    void testBasePackageField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getBasePackage()).isEqualTo("");
        props.setBasePackage("com.example");
        assertThat(props.getBasePackage()).isEqualTo("com.example");
    }

    @Test
    @DisplayName("Field 'basePathPattern' can be set and read")
    void testBasePathPatternField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getBasePathPattern()).isEqualTo("");
        props.setBasePathPattern("/api/**");
        assertThat(props.getBasePathPattern()).isEqualTo("/api/**");
    }

    @Test
    @DisplayName("Field 'docket' can be set and read")
    void testDocketField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getDocket()).isNotNull().isEmpty();
        Map<String, DocketInfo> docket = new LinkedHashMap<>();
        docket.put("group1", new DocketInfo());
        props.setDocket(docket);
        assertThat(props.getDocket()).containsKey("group1");
    }

    @Test
    @DisplayName("Field 'host' can be set and read")
    void testHostField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getHost()).isEqualTo("");
        props.setHost("https://api.example.com");
        assertThat(props.getHost()).isEqualTo("https://api.example.com");
    }

    @Test
    @DisplayName("Field 'globalOperationParameters' can be set and read")
    void testGlobalOperationParametersField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getGlobalOperationParameters()).isNull();
        List<GlobalOperationParameter> params = new ArrayList<>();
        params.add(new GlobalOperationParameter());
        props.setGlobalOperationParameters(params);
        assertThat(props.getGlobalOperationParameters()).hasSize(1);
    }

    @Test
    @DisplayName("Field 'uiConfig' can be set and read")
    void testUiConfigField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getUiConfig()).isNotNull();
        UiConfig uiConfig = new UiConfig();
        props.setUiConfig(uiConfig);
        assertThat(props.getUiConfig()).isSameAs(uiConfig);
    }

    @Test
    @DisplayName("Field 'applyDefaultResponseMessages' can be set and read")
    void testApplyDefaultResponseMessagesField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.isApplyDefaultResponseMessages()).isTrue();
        props.setApplyDefaultResponseMessages(false);
        assertThat(props.isApplyDefaultResponseMessages()).isFalse();
    }

    @Test
    @DisplayName("Field 'globalResponseMessage' can be set and read")
    void testGlobalResponseMessageField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getGlobalResponseMessage()).isNull();
        GlobalResponseMessage msg = new GlobalResponseMessage();
        props.setGlobalResponseMessage(msg);
        assertThat(props.getGlobalResponseMessage()).isSameAs(msg);
    }

    @Test
    @DisplayName("Field 'authorization' can be set and read")
    void testAuthorizationField() {
        Swagger2WebFluxProperties props = new Swagger2WebFluxProperties();
        assertThat(props.getAuthorization()).isNotNull();
        Authorization auth = new Authorization();
        props.setAuthorization(auth);
        assertThat(props.getAuthorization()).isSameAs(auth);
    }

    @Test
    @DisplayName("Public constant 'PREFIX' has expected value")
    void testPREFIXConstant() {
        assertThat(Swagger2WebFluxProperties.PREFIX).isEqualTo("swagger");
    }
}
