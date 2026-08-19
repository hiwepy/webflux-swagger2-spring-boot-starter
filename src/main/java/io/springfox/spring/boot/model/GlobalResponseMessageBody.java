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
 * <p>Global Response Message Body.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
public class GlobalResponseMessageBody {

	/**
	 * 响应码
	 **/
	private String code;

	/**
	 * 响应消息
	 **/
	private String message;

	/**
	 * 响应体
	 **/
	private String modelRef;

	/**
	 * Returns the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Returns the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the model ref.
	 *
	 * @return the model ref
	 */
	public String getModelRef() {
		return modelRef;
	}

	/**
	 * Sets the model ref.
	 *
	 * @param modelRef the model ref
	 */
	public void setModelRef(String modelRef) {
		this.modelRef = modelRef;
	}

}