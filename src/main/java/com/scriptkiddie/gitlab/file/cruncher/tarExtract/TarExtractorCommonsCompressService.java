package com.scriptkiddie.gitlab.file.cruncher.tarExtract;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TarExtractorCommonsCompressService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TarExtractorCommonsCompressService.class);

	public void untarProject(String content) {
		try {
			 Path destination = Paths.get("tmp/portfolio");
			 FileUtils.deleteDirectory(destination.toFile());
			 InputStream fileInputStream = org.apache.commons.io.IOUtils.toInputStream(content, "UTF-8");
			 new TarExtractorCommonsCompress(fileInputStream,false,destination).untar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
