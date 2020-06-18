****** FileExplorer ***********
This project contains 2 modules:
1) FileExplorer-service
2) FileExplorer-rest

1) FileExplorer-service :: This project contians:
	i) Model: Consists of the Entity class FileDetail and DTO classes namely FileDetailDTO, FolderSummaryDTO
	ii)Repository: Database related operations
	iii)Service: Transactional operations
	iv)Scheduler: Scheduled process to be called after specified interval.
	v) Util: Code to scan and read directory structure
	vi) Testcases: using JUnit 4 and Mockito
	
2) FileExplorer-rest :: This project contians:
	i) Controller: Rest endpoints
	ii)Application launcher

Important points:
- Update application.properties file in Rest project for input file path and scheduler time interval
- Application launcher is in rest project: FileExplorerRestApplication.java
- Execute testcases using JUnit 4