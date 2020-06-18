package com.assess.FileExplorer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity class. Table is created with the same columns to store data of scanned files and folders
 * table name : FILE_DETAIL
 */
@Entity
public class FileDetail {
	@Id
	@GeneratedValue
	private Long id;
	private String path;
	private String fileName;
	private String folderName;
	private String fileType;
	private Long fileSize;
	private Date modificationDate;
	private Date scanDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date date) {
		this.modificationDate = date;
	}
	
	public Date getScanDate() {
		return scanDate;
	}
	public void setScanDate(Date scanDate) {
		this.scanDate = scanDate;
	}
	
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
	@Override
	public String toString() {
		return "FileDetails [path=" + path + ", fileName=" + fileName + ", folderName=" + folderName + ", fileType=" + fileType + ", fileSize="
				+ fileSize + ", modificationDate=" + modificationDate + ", scanDate=" + scanDate + "]";
	}
}
