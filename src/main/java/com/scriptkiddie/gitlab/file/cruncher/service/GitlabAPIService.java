package com.scriptkiddie.gitlab.file.cruncher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GitlabAPIService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GitlabAPIService.class);

    private final RestClient restClient;
    public GitlabAPIService(RestClient restClient) {
        super();
        this.restClient = restClient;
    }

	public String getTarArchiveInString() {

		LOGGER.info("Calling GitlabAPI Service");

        return restClient
                .get()
                .uri("/archive.tar")
                .retrieve()
                .body(String.class);

    }
}
