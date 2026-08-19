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

import lombok.Data;

/**
 * <p>Global Response Message.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
public class GlobalResponseMessage {

	/**
	 * POST 响应消息体
	 **/
	List<GlobalResponseMessageBody> post = new ArrayList<>();

	/**
	 * GET 响应消息体
	 **/
	List<GlobalResponseMessageBody> get = new ArrayList<>();

	/**
	 * PUT 响应消息体
	 **/
	List<GlobalResponseMessageBody> put = new ArrayList<>();

	/**
	 * PATCH 响应消息体
	 **/
	List<GlobalResponseMessageBody> patch = new ArrayList<>();

	/**
	 * DELETE 响应消息体
	 **/
	List<GlobalResponseMessageBody> delete = new ArrayList<>();

	/**
	 * HEAD 响应消息体
	 **/
	List<GlobalResponseMessageBody> head = new ArrayList<>();

	/**
	 * OPTIONS 响应消息体
	 **/
	List<GlobalResponseMessageBody> options = new ArrayList<>();

	/**
	 * TRACE 响应消息体
	 **/
	List<GlobalResponseMessageBody> trace = new ArrayList<>();

	/**
	 * Returns the post.
	 *
	 * @return the post
	 */
	public List<GlobalResponseMessageBody> getPost() {
		return post;
	}

	/**
	 * Sets the post.
	 *
	 * @param post the post
	 */
	public void setPost(List<GlobalResponseMessageBody> post) {
		this.post = post;
	}

	/**
	 * Returns the get.
	 *
	 * @return the get
	 */
	public List<GlobalResponseMessageBody> getGet() {
		return get;
	}

	/**
	 * Sets the get.
	 *
	 * @param get the get
	 */
	public void setGet(List<GlobalResponseMessageBody> get) {
		this.get = get;
	}

	/**
	 * Returns the put.
	 *
	 * @return the put
	 */
	public List<GlobalResponseMessageBody> getPut() {
		return put;
	}

	/**
	 * Sets the put.
	 *
	 * @param put the put
	 */
	public void setPut(List<GlobalResponseMessageBody> put) {
		this.put = put;
	}

	/**
	 * Returns the patch.
	 *
	 * @return the patch
	 */
	public List<GlobalResponseMessageBody> getPatch() {
		return patch;
	}

	/**
	 * Sets the patch.
	 *
	 * @param patch the patch
	 */
	public void setPatch(List<GlobalResponseMessageBody> patch) {
		this.patch = patch;
	}

	/**
	 * Returns the delete.
	 *
	 * @return the delete
	 */
	public List<GlobalResponseMessageBody> getDelete() {
		return delete;
	}

	/**
	 * Sets the delete.
	 *
	 * @param delete the delete
	 */
	public void setDelete(List<GlobalResponseMessageBody> delete) {
		this.delete = delete;
	}

	/**
	 * Returns the head.
	 *
	 * @return the head
	 */
	public List<GlobalResponseMessageBody> getHead() {
		return head;
	}

	/**
	 * Sets the head.
	 *
	 * @param head the head
	 */
	public void setHead(List<GlobalResponseMessageBody> head) {
		this.head = head;
	}

	/**
	 * Returns the options.
	 *
	 * @return the options
	 */
	public List<GlobalResponseMessageBody> getOptions() {
		return options;
	}

	/**
	 * Sets the options.
	 *
	 * @param options the options
	 */
	public void setOptions(List<GlobalResponseMessageBody> options) {
		this.options = options;
	}

	/**
	 * Returns the trace.
	 *
	 * @return the trace
	 */
	public List<GlobalResponseMessageBody> getTrace() {
		return trace;
	}

	/**
	 * Sets the trace.
	 *
	 * @param trace the trace
	 */
	public void setTrace(List<GlobalResponseMessageBody> trace) {
		this.trace = trace;
	}

}