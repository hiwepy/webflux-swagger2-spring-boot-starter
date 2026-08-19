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
 * <p>Global Operation Parameter.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
public class GlobalOperationParameter {
	
	/**
	 * 参数名
	 **/
	private String name;

	/**
	 * 描述信息
	 **/
	private String description;

	/**
	 * 参数放在哪个地方:header,query,path,body.form
	 **/
	private String parameterType;

	/**
	 * 参数是否必须传
	 **/
	private boolean required;
	
	/**
	 * 参数是否隐藏
	 **/
	private boolean hidden;
	
	/**
	 * 参数格式
	 **/
	private String pattern;

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
	 * Returns the parameter type.
	 *
	 * @return the parameter type
	 */
	public String getParameterType() {
		return parameterType;
	}

	/**
	 * Sets the parameter type.
	 *
	 * @param parameterType the parameter type
	 */
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	/**
	 * Returns the required.
	 *
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * Sets the required.
	 *
	 * @param required the required
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * Returns the hidden.
	 *
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Sets the hidden.
	 *
	 * @param hidden the hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * Returns the pattern.
	 *
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * Sets the pattern.
	 *
	 * @param pattern the pattern
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}