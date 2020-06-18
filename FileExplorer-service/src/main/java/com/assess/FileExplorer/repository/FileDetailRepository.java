package com.assess.FileExplorer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assess.FileExplorer.model.FileDetail;
import com.assess.FileExplorer.model.FileDetailDTO;
import com.assess.FileExplorer.model.FolderSummaryDTO;

@Repository
public interface FileDetailRepository extends CrudRepository<FileDetail, Long>  {
	
	public List<FileDetailDTO> findDistinctByOrderByFolderNameAsc();
	
	@Query("SELECT new com.assess.FileExplorer.model.FolderSummaryDTO(fd.folderName, fd.path, SUM(fd.fileSize)) FROM FileDetail fd WHERE (:type is null or fd.fileType = :type) GROUP BY fd.folderName, fd.path ORDER BY SUM(fd.fileSize)")
	public List<FolderSummaryDTO> findFolderSizesByType(@Param(value = "type") String type);
	
}
