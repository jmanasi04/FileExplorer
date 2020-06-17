package com.assess.FileExplorer.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.assess.FileExplorer.model.FileDetail;

/**
 * File reader service
 * 
 * @author Manasi J
 */
public class FileHandler {

	public static List<FileDetail> readFileMetadata(String scanPath) {

		if (scanPath == null) {
			return null;
		}
		return readFileMetadata(new File(scanPath));
	}

	public static List<FileDetail> readFileMetadata(File folderToScan) {

		if (folderToScan == null) {
			return null;
		}
		List<FileDetail> files = new ArrayList<>();
		readFileFromPath(folderToScan, files);
		return files;
	}

	/**
	 * Read files from input path and populate object
	 * 
	 * @param fileDetailsList
	 * @param scanPath:
	 *            Directory/ file path to scan for files
	 */
	private static void readFileFromPath(File sourceFile, List<FileDetail> fileDetailsList) {
		if (!sourceFile.isDirectory()) {
			fileDetailsList.add(populateFileDetailsObject(sourceFile));
		} else {
			File[] files = sourceFile.listFiles();
			for (File file : files) {
				readFileFromPath(file, fileDetailsList);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\workspace\\Mana\\FileExplorer\\pom.xml");
		readFileMetadata("E:\\\\test");
	}
	/**
	 * Populate object to store in database
	 * 
	 * @param sourceFile:
	 *            File whose details need to be stored
	 * @return
	 */
	public static FileDetail populateFileDetailsObject(File sourceFile) {
		FileDetail fileDetails = new FileDetail();
		fileDetails.setPath(sourceFile.getPath());
		fileDetails.setFileName(sourceFile.getName());
		fileDetails.setFileType(getExtension(sourceFile.getName()));
		fileDetails.setFileSize(sourceFile.length());
		fileDetails.setModificationDate(new Date(sourceFile.lastModified()));
		fileDetails.setScanDate(new Date());
		return fileDetails;
	}

	public static String getExtension(String name) {
		return name.split("\\.")[1];
	}
}
