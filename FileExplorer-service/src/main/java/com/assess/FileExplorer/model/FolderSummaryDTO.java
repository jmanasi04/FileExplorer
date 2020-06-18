package com.assess.FileExplorer.model;

/**
 * Data transfer object for rest api to fetch the size of folders by file type
 */
public class FolderSummaryDTO {
	private String folderName;
	private String path;
	private Long totalSize;
	
	public FolderSummaryDTO(String folderName, String path, Long totalSize) {
		super();
		this.folderName = folderName;
		this.path = path;
		this.totalSize = totalSize;
	}

	public String getFolderName() {
		return folderName;
	}

	public String getPath() {
		return path;
	}

	public Long getTotalSize() {
		return totalSize;
	}
}
