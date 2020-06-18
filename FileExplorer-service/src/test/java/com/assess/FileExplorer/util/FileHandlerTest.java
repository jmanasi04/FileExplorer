package com.assess.FileExplorer.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.assess.FileExplorer.model.FileDetail;

public class FileHandlerTest {

	@Test
	public void testReadFileMetadataStringNull() {
		String path = null;
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(path);
		assertNull(fileMetadata);
	}
	
	@Test
	public void testReadFileMetadataStringEmpty() {
		String path = "";
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(path);
		assertNull(fileMetadata);
	}
	
	@Test
	public void testReadFileMetadataFileSingleFile() {
		File mockFile = Mockito.mock(File.class);
		Mockito.when(mockFile.isDirectory()).thenReturn(false);
		Mockito.when(mockFile.getParentFile()).thenReturn(mockFile);
		Mockito.when(mockFile.getName()).thenReturn("test.txt");
		Mockito.when(mockFile.lastModified()).thenReturn(new Date().getTime());
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(mockFile);
		assertNotNull(fileMetadata);
		assertEquals(1, fileMetadata.size());
		assertEquals("test.txt", fileMetadata.get(0).getFileName());
		
	}
	
	@Test
	public void testReadFileMetadataFileEmptyFolder() {
		File mockFolder = Mockito.mock(File.class);
		Mockito.when(mockFolder.isDirectory()).thenReturn(true);
		Mockito.when(mockFolder.listFiles()).thenReturn(new File[0]);
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(mockFolder);
		assertNotNull(fileMetadata);
		assertEquals(0, fileMetadata.size());
	}
	
	@Test
	public void testReadFileMetadataFileNull() {
		File file = null;
		List<FileDetail> fileMetadata = FileHandler.readFileMetadata(file);
		assertNull(fileMetadata);
	}
	
}
