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
package io.springfox.spring.boot.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import io.springfox.spring.boot.extend.ArrayRefProperty;
import io.swagger.models.Model;
import io.swagger.models.properties.AbstractProperty;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.BooleanProperty;
import io.swagger.models.properties.DateTimeProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.LongProperty;
import io.swagger.models.properties.ObjectProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.PropertyBuilder;
import io.swagger.models.properties.PropertyBuilder.PropertyId;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
 
/**
 * https://blog.csdn.net/pingzi_kendy/article/details/83577443
 * @author ChenZhiPing 2018年10月31日 下午1:44:50
 */
public class SwaggerUtil {
 
	/*
	 * 判断是否Swagger基本类型
	 * @param type javaType
	 * @return 是否基础类型
	 */
	public static boolean isBaseType(String type) {
		return SwaggerUtil.getSwaggerProperty(type) != null;
	}
 
	/*
	 * 获取Swagger支持的类型
	 * @return
	 */
	public static Map<String, AbstractProperty> getPropMap() {
		Map<String, AbstractProperty> map = new HashMap<String, AbstractProperty>();
		map.put("integer", new IntegerProperty());
		map.put("int", new IntegerProperty());
		map.put("long", new LongProperty());
		map.put("string", new StringProperty());
		map.put("object", new ObjectProperty());
		map.put("array", new ArrayProperty());
		map.put("boolean", new BooleanProperty());
		map.put("date", new DateTimeProperty());
		return map;
	}
 
	/*
	 * 通过java类型获取Swagger类型
	 * @param type javaType
	 * @return swaggerType
	 */
	public static AbstractProperty getSwaggerProperty(String type) {
		type = type.toLowerCase();
		return SwaggerUtil.getPropMap().get(type);
	}
 
	public static boolean isMap(String type) {
		type = type.toLowerCase();
		return type.startsWith("map");
	}
 
	public static boolean isIterable(String type) {
		type = type.toLowerCase();
		return type.startsWith("list") || type.startsWith("set");
	}
 
	/*
	 * 获取非基本类型的T<br>
	 * new String[] { "A<List<C1>>", "A<C2>", "A<B<String,<String,List<C4>>>>" }
	 * @param type javaType
	 * @return C1,C2,C3,C4
	 */
	public static String getRef(String type) {
		try {
			String m = type.substring(type.lastIndexOf("«") + 1, type.indexOf("»"));
			String[] cc = m.split(",");
			for (String c : cc) {
				if (!SwaggerUtil.isBaseType(c)) {
					return c;
				}
			}
			return type;
		} catch (Exception e) {
 
		}
		return "!!Unknown T!!";
	}
 
	/*
	 * 获取对象类型，主要是剥离第一层<>
	 * @param type ApiRestResponse<Map<Operator, List<Map<String, Customer>>>>
	 * @return Map<Operator, List<Map<String, Customer>>>
	 */
	public static String getRealType(String type) {
		try {
			String m = type.substring(type.indexOf("«") + 1, type.lastIndexOf("»"));
			return m;
		} catch (Exception e) {
 
		}
		return type;
	}
 
	public static boolean hasGenerics(String type) {
		if (type.indexOf("»") > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * 判断是否存在非基本类型<参照类型>
	 * @param type javaType
	 * @return
	 */
	public static boolean hasRef(String type) {
		if (type.indexOf("»") > 0) {
			try {
				String m = type.substring(type.lastIndexOf("«") + 1, type.indexOf("»"));
				String[] cc = m.split(",");
				for (String c : cc) {
					if (!SwaggerUtil.isBaseType(c)) {
						return true;
					}
				}
				return false;
			} catch (Exception e) {
				return false;
			}
		} else {
			return !SwaggerUtil.isBaseType(type);
		}
	}
 
	/*
	 * 递归处理泛型类型 <br>
	 * ApiRestResponse<Map<Map<Long, Operator>, List<Map<String, Customer>>>>
	 * @param dataProp  dataProp
	 * @param type javaType
	 * @param definitions  definitions
	 * @return
	 */
	public static Property getNewProp(Property dataProp, String type, Map<String, Model> definitions) {
		Property newProp = null;
		Model model = definitions.get(type);
		Map<String, Property> props = null;
		if (null != model) {
			props = model.getProperties();
		}
		if (null == props) {
			props = new HashMap<String, Property>();
		}
		String realType = SwaggerUtil.getRealType(type);
		if (SwaggerUtil.isMap(type)) {
			String[] realTypes = SwaggerUtil.splitByComma(realType);
 
			Map<PropertyId, Object> argsK = new HashMap<PropertyId, Object>();
			argsK.put(PropertyBuilder.PropertyId.DESCRIPTION, "Map的键");
			argsK.put(PropertyBuilder.PropertyId.TYPE, realTypes[0].toLowerCase());
			AbstractProperty _prop0 = SwaggerUtil.getSwaggerProperty(realTypes[0]);
			Property propK = PropertyBuilder.build(null == _prop0 ? "object" : _prop0.getType(),
					null == _prop0 ? null : _prop0.getFormat(), argsK);
			propK.setName("key");
 
			Map<PropertyId, Object> argsV = new HashMap<PropertyId, Object>();
			argsV.put(PropertyBuilder.PropertyId.DESCRIPTION, "Map的值");
			argsV.put(PropertyBuilder.PropertyId.TYPE, realTypes[1].toLowerCase());
			AbstractProperty _prop1 = SwaggerUtil.getSwaggerProperty(realTypes[1]);
			Property propV = PropertyBuilder.build(null == _prop1 ? "object" : _prop1.getType(),
					null == _prop1 ? null : _prop1.getFormat(), argsV);
			propV.setName("value");
 
			if (!realType.equals(type)) {
				propK = SwaggerUtil.getNewProp(propK, realTypes[0], definitions);
				propV = SwaggerUtil.getNewProp(propV, realTypes[1], definitions);
			}
 
			props.put(propK.getName(), propK);
			props.put(propV.getName(), propV);
 
			newProp = new RefProperty();
			BeanUtils.copyProperties(dataProp, newProp);
			((RefProperty) newProp).set$ref(type);
		} else if (SwaggerUtil.isIterable(type)) {
			String ref = SwaggerUtil.getRealType(type);
			newProp = new ArrayRefProperty();
			BeanUtils.copyProperties(dataProp, newProp);
			((ArrayRefProperty) newProp).set$ref(ref);
			((ArrayRefProperty) newProp).setType(ArrayRefProperty.TYPE);
			if (!realType.equals(type)) {
				SwaggerUtil.getNewProp(dataProp, realType, definitions);
			}
		} else if (SwaggerUtil.isBaseType(type)) {
			Map<PropertyId, Object> args = new HashMap<PropertyId, Object>();
			args.put(PropertyBuilder.PropertyId.DESCRIPTION, dataProp.getDescription());
			args.put(PropertyBuilder.PropertyId.TYPE, type.toLowerCase());
			AbstractProperty _prop = SwaggerUtil.getSwaggerProperty(type);
			newProp = PropertyBuilder.build(_prop.getType(), _prop.getFormat(), args);
			newProp.setName(dataProp.getName());
		} else if (SwaggerUtil.hasRef(type)) {
			newProp = new RefProperty();
			BeanUtils.copyProperties(dataProp, newProp);
			((RefProperty) newProp).set$ref(type);
		} else {
 
		}
		if (null != model) {
			model.setProperties(props);
		}
 
		return newProp;
	}
 
	public static String[] splitByComma(String str) {
		int index = 0;
		int has = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ("«".equals(c + "")) {
				has++;
			}
			if ("»".equals(c + "")) {
				has--;
			}
			if (",".equals(c + "") && has == 0) {
				index = i;
			}
		}
 
		String[] arr = new String[2];
		arr[0] = str.substring(0, index);
		arr[1] = str.substring(index + 1);
		return arr;
	}
 
	public static void main(String[] args) {
		String[] ss = new String[] { "A«List«C1»»", "A«C2»", "A«B«String,«String,List«C4»»»»" };
		for (String s : ss) {
			String c = SwaggerUtil.getRealType(s);
			System.out.println(c);
		}
 
		String[] s2 = new String[] { "A,B«List«C1»»", "Map«A,B»,C«List«D»»",
				"Map«Map«A,B»,C«List«D»»,Map«A,B»,C«List«D»»»,C«List«D»»" };
		for (String s : s2) {
			String[] arr = SwaggerUtil.splitByComma(s);
			System.out.println(arr[0]);
			System.out.println(arr[1]);
		}
	}
}