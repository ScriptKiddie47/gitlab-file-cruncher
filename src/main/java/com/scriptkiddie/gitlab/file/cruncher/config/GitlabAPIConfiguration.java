package com.scriptkiddie.gitlab.file.cruncher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class GitlabAPIConfiguration {
	   @Bean
	    public RestClient restClient() {
	        return RestClient
	                .builder()
	                .baseUrl("https://gitlab.com/api/v4/projects/65160523/repository")
	                .build();
	    }
}
