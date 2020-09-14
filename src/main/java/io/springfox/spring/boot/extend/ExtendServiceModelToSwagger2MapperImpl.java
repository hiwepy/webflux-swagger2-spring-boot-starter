/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
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
package io.springfox.spring.boot.extend;

import java.util.Iterator;
import java.util.Map;

import io.springfox.spring.boot.utils.SwaggerUtil;
import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.models.properties.Property;
import springfox.documentation.service.Documentation;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl;

/**
 * TODO
 * 
 * @author ： <a href="https://github.com/vindell">vindell</a>
 */
public class ExtendServiceModelToSwagger2MapperImpl extends ServiceModelToSwagger2MapperImpl {

	@Override
	public Swagger mapDocumentation(Documentation from) {
		Swagger swagger = super.mapDocumentation(from);
		// 响应返回参数增强
		Iterator<Map.Entry<String, Model>> it = swagger.getDefinitions().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Model> entry = it.next();
			Model model = entry.getValue();
			String key = entry.getKey();
			if (key.contains("JsonResult")) {
				Map<String, Property> props = model.getProperties();
				Property dataProp = props.get("data");
				Property newProp = SwaggerUtil.getNewProp(dataProp, SwaggerUtil.getRealType(key), swagger.getDefinitions());
				props.put("data", newProp);
			}
		}
		return swagger;
	}

}
