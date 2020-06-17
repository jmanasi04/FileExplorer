package com.assess.FileExplorer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assess.FileExplorer.model.FileDetail;

@Repository
public interface FileDetailRepository extends CrudRepository<FileDetail, Long>  {

}
