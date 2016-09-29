package epam.howork.task3.bean;

public class FileNameResponse {
	private boolean fileNameStatus;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public boolean isFileNameStatus(){
		return fileNameStatus;
	}
	
	public void setFileNameStatus(boolean fileNameStatus){
		this.fileNameStatus = fileNameStatus;
		
		
		
	}
	
}
