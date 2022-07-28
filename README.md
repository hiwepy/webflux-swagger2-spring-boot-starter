# webflux-swagger2-spring-boot-starter

Spring Boot Starter For WebFlux With Swagger2

### 说明

 > 实现 Spring WebFlux 与 Swagger2 相关对象的自动创建和参数绑定

### Maven

```xml
<dependency>
    <groupId>com.github.hiwepy</groupId>
    <artifactId>webflux-swagger2-spring-boot-starter</artifactId>
    <version>${project.version}</version>
</dependency>
```

### 配置参考

 > application.yml

################################################################################################################  
###接口文档（Swagger UI）配置：  
################################################################################################################
swagger:
  title: Swagger WebFlux Demo
  description: Swagger WebFlux Demo
  version: 1.0.0-SNAPSHOT
  license: Apache License, Version 2.0
  license-url: https://www.apache.org/licenses/LICENSE-2.0.html
  contact:
    name: wandl
    email: hnxyhcwdl1003@163.com
    url: https://www.wdlspace.com/
  base-package: io.github.wandl
  base-path-pattern: /**

### Sample

[https://github.com/vindell/spring-boot-starter-samples/tree/master/spring-boot-sample-webflux-swagger2](https://github.com/vindell/spring-boot-starter-samples/tree/master/spring-boot-sample-webflux-swagger2 "spring-boot-sample-webflux-swagger2")

### 参考资料

参考https://my.oschina.net/go4it/blog/3035218
部分代码来来自：https://github.com/SpringForAll/spring-boot-starter-swagger