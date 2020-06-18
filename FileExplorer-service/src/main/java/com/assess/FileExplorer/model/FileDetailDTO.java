package com.assess.FileExplorer.model;

/**
 * Data transfer object to fetch folder names and path
 */
public class FileDetailDTO {

	private String folderName;
	private String path;
	
	public FileDetailDTO(String folderName, String path) {
		super();
		this.folderName = folderName;
		this.path = path;
	}
	public String getFolderName() {
		return folderName;
	}
	public String getPath() {
		return path;
	}
}
