package epam.howork.task3.bean;

public class Response {
	private boolean errorStatus;
	private boolean loadStatus;

	private String errorMessage;
	private String resultMessage;

	private String errorLoadMessage;
	private String resultLoadMessage;

	public boolean isLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(boolean loadStatus) {
		this.loadStatus = loadStatus;
	}

	public String getErrorLoadMessage() {
		return errorLoadMessage;
	}

	public void setErrorLoadMessage(String errorLoadMessage) {
		this.errorLoadMessage = errorLoadMessage;
	}

	public String getResultLoadMessage() {
		return resultLoadMessage;
	}

	public void setResultLoadMessage(String resultLoadMessage) {
		this.resultLoadMessage = resultLoadMessage;
	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}
