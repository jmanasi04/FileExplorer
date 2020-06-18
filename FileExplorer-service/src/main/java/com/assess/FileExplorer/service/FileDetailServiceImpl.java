package com.assess.FileExplorer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assess.FileExplorer.model.FileDetail;
import com.assess.FileExplorer.repository.FileDetailRepository;

@Service
public class FileDetailServiceImpl implements FileDetailService{

	@Autowired
	private FileDetailRepository fileDetailRepository;

	@Override
	@Transactional
	public void updateAll(List<FileDetail> fileMetadata) {
		fileDetailRepository.deleteAll();
		fileDetailRepository.saveAll(fileMetadata);
	}
}
