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

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {{ @link DocketInfo }}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("DocketInfo Tests")
class DocketInfoTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        DocketInfo instance = new DocketInfo();
        assertThat(instance).isNotNull();
    }

    @Test
    @DisplayName("Fields can be set and read")
    void testFields() {
        DocketInfo info = new DocketInfo();
        info.setTitle("Test API");
        info.setDescription("Test Description");
        info.setVersion("1.0.0");
        info.setLicense("Apache 2.0");
        info.setLicenseUrl("https://example.com/license");
        info.setTermsOfServiceUrl("https://example.com/tos");
        info.setBasePackage("com.example");
        info.setBasePathPattern("/api/**");
        assertThat(info.getTitle()).isEqualTo("Test API");
        assertThat(info.getDescription()).isEqualTo("Test Description");
        assertThat(info.getVersion()).isEqualTo("1.0.0");
        assertThat(info.getLicense()).isEqualTo("Apache 2.0");
        assertThat(info.getLicenseUrl()).isEqualTo("https://example.com/license");
        assertThat(info.getTermsOfServiceUrl()).isEqualTo("https://example.com/tos");
        assertThat(info.getBasePackage()).isEqualTo("com.example");
        assertThat(info.getBasePathPattern()).isEqualTo("/api/**");
    }

    @Test
    @DisplayName("Contact field can be set and read")
    void testContactField() {
        DocketInfo info = new DocketInfo();
        assertThat(info.getContact()).isNotNull();
        Contact contact = new Contact();
        contact.setName("John");
        info.setContact(contact);
        assertThat(info.getContact().getName()).isEqualTo("John");
    }

    @Test
    @DisplayName("IgnoredParameterTypes field can be set and read")
    void testIgnoredParameterTypesField() {
        DocketInfo info = new DocketInfo();
        assertThat(info.getIgnoredParameterTypes()).isNotNull();
        List<Class<?>> types = new ArrayList<>();
        types.add(String.class);
        info.setIgnoredParameterTypes(types);
        assertThat(info.getIgnoredParameterTypes()).containsExactly(String.class);
    }
}
