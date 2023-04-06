package com.app.sendreceive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SendreceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendreceiveApplication.class, args);
	}

    @Autowired
	    private RestTemplate restTemplate;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

        
	    @PostMapping("/sendmessage")
	    public String sendMessage(@RequestBody String message) {
	        String url = "http://localhost:9090/receivemessage";
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<String> request = new HttpEntity<>(message, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
	        return response.getBody();
	    }
	}

	
	
	
	
	
	
	

