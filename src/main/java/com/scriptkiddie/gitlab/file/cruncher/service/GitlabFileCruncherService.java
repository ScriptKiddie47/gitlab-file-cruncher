package com.scriptkiddie.gitlab.file.cruncher.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.scriptkiddie.gitlab.file.cruncher.tarExtract.TarExtractorCommonsCompressService;

@Service
public class GitlabFileCruncherService {

	private static final File TEMP_DIRECTORY = new File(System.getProperty("java.io.tmpdir"));
	private static final Logger LOGGER = LoggerFactory.getLogger(GitlabFileCruncherService.class);
	private final GitlabAPIService apiService;
	private final TarExtractorCommonsCompressService teccs;

	public GitlabFileCruncherService(GitlabAPIService apiService, TarExtractorCommonsCompressService teccs) {
		super();
		this.apiService = apiService;
		this.teccs = teccs;
	}

	public void fetchTarFile() {

		try {
			
			File file = new File("portfolioTar.txt");
			if (file.exists()) {
				LOGGER.info("File Exists");
			} else {
				String tarContentInString = apiService.getTarArchiveInString();
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(tarContentInString);
				writer.close();
			}

			String tarContentInString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

			teccs.untarProject(tarContentInString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
