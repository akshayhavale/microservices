package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@Bean
//	public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(
//			CircuitBreakerRegistry circuitBreakerRegistry, TimeLimiterRegistry timeLimiterRegistry) {
//		ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory();
//		// inject the created spring managed bean circuit breaker registry will all
//		// externally configured CBs
//		reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(circuitBreakerRegistry);
//		// Inject the the created spring managed bean time limter config for specific
//		// backend name otherwise use the default configuration from resilience4j
//		reactiveResilience4JCircuitBreakerFactory.configure(builder -> builder
//				.timeLimiterConfig(timeLimiterRegistry.getConfiguration("backendB")
//						.orElse(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(300)).build()))
//				.circuitBreakerConfig(circuitBreakerRegistry.getConfiguration("backendB")
//						.orElse(circuitBreakerRegistry.getDefaultConfig())),
//				"backendB");
//		return reactiveResilience4JCircuitBreakerFactory;
//	}

	@Bean
	public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(
			CircuitBreakerRegistry circuitBreakerRegistry) {
		ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory();
		reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(circuitBreakerRegistry);
		return reactiveResilience4JCircuitBreakerFactory;
	}
}
