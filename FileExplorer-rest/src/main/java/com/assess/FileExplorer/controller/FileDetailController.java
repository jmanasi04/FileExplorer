package com.assess.FileExplorer.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assess.FileExplorer.model.FileDetailDTO;
import com.assess.FileExplorer.model.FolderSummaryDTO;
import com.assess.FileExplorer.repository.FileDetailRepository;

@RestController
public class FileDetailController {
	
	@Autowired
	private FileDetailRepository fileDetailRepository;
	
	@GetMapping("/folders")
	public List<FileDetailDTO> findAllFolders() {
		return fileDetailRepository.findDistinctByOrderByFolderNameAsc();
	}
	
	@GetMapping("/filesizes")
	public List<FolderSummaryDTO> findFolderSizes(@QueryParam("fileType") String fileType) {
		return fileDetailRepository.findFolderSizesByType(fileType);
	}
}
