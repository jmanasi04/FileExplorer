package com.assess.FileExplorer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.assess.FileExplorer.model.FileDetail;
import com.assess.FileExplorer.repository.FileDetailRepository;
import com.assess.FileExplorer.util.FileHandler;

@Component
public class FileDetailScheduler {
	
	@Value("${assess.scan.location}")
	private String scanPath;
	
	@Autowired
	private FileDetailRepository fileDetailRepository;
	
	public void process() {
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(scanPath);
		fileDetailRepository.saveAll(fileMetadata);
	}

}
