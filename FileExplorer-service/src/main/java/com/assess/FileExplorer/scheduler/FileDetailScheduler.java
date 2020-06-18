package com.assess.FileExplorer.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.assess.FileExplorer.model.FileDetail;
import com.assess.FileExplorer.service.FileDetailService;
import com.assess.FileExplorer.util.FileHandler;

/**
 * Scheduled process to be called after specified interval.
 * Current interval specified in property file using cron expression
 * @author Manasi J
 */
@Component
public class FileDetailScheduler {
	
	@Value("${assess.scan.location}")
	private String scanPath;

	@Autowired
	private FileDetailService fileDetailService;
	
	@Scheduled(cron = "${assess.scan.interval}")
	public void process() {
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(scanPath);
		fileDetailService.updateAll(fileMetadata);
	}

}
