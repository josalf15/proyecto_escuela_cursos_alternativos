package com.josalf.project.servicio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {
	
	@Value("${apipoke.baseurl}")
    protected String baseUrl;

    protected final  RestTemplate restTemplate;

    protected AbstractClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
