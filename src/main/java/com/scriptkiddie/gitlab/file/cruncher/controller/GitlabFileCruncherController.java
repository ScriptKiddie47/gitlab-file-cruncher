package com.scriptkiddie.gitlab.file.cruncher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scriptkiddie.gitlab.file.cruncher.service.GitlabFileCruncherService;

@RestController
public class GitlabFileCruncherController {

	private final GitlabFileCruncherService fileCruncherService;

	public GitlabFileCruncherController(GitlabFileCruncherService fileCruncherService) {
		super();
		this.fileCruncherService = fileCruncherService;
	}

	@GetMapping("/health")
	public String health() {
		return "Up";
	}

	@GetMapping("/")
	public String showTable() {
		fileCruncherService.fetchTarFile();
		return "Loading Table from Gitlab Table";
	}
}
