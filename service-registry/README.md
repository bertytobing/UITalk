# Service Discovery

### Introduction
Service discovery using Eureka (see [detail](https://spring.io/guides/gs/service-registration-and-discovery/))

### How to use

##### 1. Add gradle dependency in your build.gradle

```
compile 'org.springframework.cloud:spring-cloud-starter-eureka'
```

##### 2. Add annotation in your main application

```
@EnableDiscoveryClient
```

##### 3. Add following properties to your application.properties

```
# EUREKA
eureka.client.enabled=true
eureka.client.serviceUrl.defaultZone=${EUREKA_URL}/eureka
eureka.instance.appname={your_application_name}
```

Add environment variable `EUREKA_URL` with your eureka server address (port `8761`)

Example `EUREKA_URL`: `10.181.14.194:8761`

##### 4. Run Eureka server

```
ROOT_DIRECTORY/CATAPA-API/service-discovery $ gradle bootRun
```

##### 5. Run your application

```
ROOT_DIRECTORY/CATAPA-API/{your_application} $ gradle bootRun
```

##### 6. Go to `EUREKA_URL` and make sure your application is already registered