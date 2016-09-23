package com.yosanai.example.hialex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Bean
	public HelloSpeechlet helloSpeechlet() {
		return new HelloSpeechlet();
	}

	@Bean
	public SpeechletServlet speechletServlet() {
		SpeechletServlet ret = new SpeechletServlet();
		ret.setSpeechlet(helloSpeechlet());
		return ret;
	}

	@Bean
	public ServletRegistrationBean alexaConfig() throws Exception {
		ServletRegistrationBean ret = new ServletRegistrationBean(speechletServlet(), "/hialex");
		return ret;
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}