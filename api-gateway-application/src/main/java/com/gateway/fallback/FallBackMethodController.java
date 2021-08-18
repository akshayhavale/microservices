/**
 * this is for hystrix circuit breaker integration 
 */



//package com.gateway.fallback;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FallBackMethodController {
//
//	@GetMapping("/userServiceFallBack")
//	public String userServiceFallBackMethod() {
//		return "User service is taking time. So please try again somtimes.";
//	}
//
//	@GetMapping("/departmentServiceFallBack")
//	public String departmentServiceFallBackMethod() {
//		return "Department service is taking time. So please try again somtimes.";
//	}
//
//}
//
//#spring:
//#  application:
//#    name: API-GATEWAY
//#  cloud:
//#    gateway:
//#      routes:
//#      - id: USER-SERVICE
//#        uri: lb://USER-SERVICE
//#        predicates:
//#        - Path=/user/**
//#        filters:
//#        - name: Hystrix
//#          args:
//#            name: USER-SERVICE
//#            fallbackuri: userServieFallBack
//#      - id: DEPARTMENT-SERVICE
//#        uri: lb://DEPARTMENT-SERVICE
//#        predicates:
//#        - Path=/department/**
//#        filters:
//#        - name: Hystrix
//#          args:
//#            name: DEPARTMENT-SERVICE
//#            fallbackuri: departmentFallBack      
//#management:
//#  endpoints:
//#    web:
//#      exposure:
//#        include: hystrix.stream
//##
//#hystrix:
//#  command:
//#    fallbackcmd:
//#      execution:
//#        isolation:
//#          thread:
//#            timeoutInMilliseconds: 3000