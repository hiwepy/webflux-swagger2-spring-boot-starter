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

/**
 * securitySchemes 支持方式之一 ApiKey
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
public class Authorization {

	/**
	 * 鉴权策略ID，对应 SecurityReferences ID
	 */
	private String name = "X-Authorization";

	/**
	 * 鉴权策略，可选 ApiKey | BasicAuth | None，默认ApiKey
	 */
	private AuthorizationTypeEnum type = AuthorizationTypeEnum.APIKEY;

	/**
	 * 鉴权传递的Header参数
	 */
	private String keyName = "token";

	/**
	 * 需要开启鉴权URL的正则
	 */
	private String authRegex = "^.*$";

	/**
	 * Returns the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the type.
	 *
	 * @return the type
	 */
	public AuthorizationTypeEnum getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type
	 */
	public void setType(AuthorizationTypeEnum type) {
		this.type = type;
	}

	/**
	 * Returns the key name.
	 *
	 * @return the key name
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * Sets the key name.
	 *
	 * @param keyName the key name
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/**
	 * Returns the auth regex.
	 *
	 * @return the auth regex
	 */
	public String getAuthRegex() {
		return authRegex;
	}

	/**
	 * Sets the auth regex.
	 *
	 * @param authRegex the auth regex
	 */
	public void setAuthRegex(String authRegex) {
		this.authRegex = authRegex;
	}

}