package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class GatewayFallback {

	@GetMapping("/user")
	public FallbackResponse getFallBackBackendA() {
		FallbackResponse a = new FallbackResponse();
		a.setMsgCode(500);
		a.setMsg("user service is not at good state try again later");
		return a;
	}

	@GetMapping("/department")
	public FallbackResponse getFallBackBackendB() {
		FallbackResponse a = new FallbackResponse();
		a.setMsgCode(500);
		a.setMsg("Department service is not at good state try again later");
		return a;
	}
}
