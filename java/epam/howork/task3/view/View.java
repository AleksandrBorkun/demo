package epam.howork.task3.view;

import epam.howork.task3.bean.AddNoteRequest;
import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.controller.Controller;

public class View {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		
				 
		AddNoteRequest request = new AddNoteRequest();

		request.setCommandName("ADD_NEW_NOTE");

		//request.setNote("my message");

		//request.setCommandName("CREATE_NEW_FILE");
		
		//request.setCommandName("LOAD_FILE");
		
		Response response = controller.doRequest(request);
		
		if(response.isLoadStatus() == true)
			System.out.println("File load completed");
		else
			System.out.println("File not found");
		
		if(response.isErrorStatus() ==  true){
			System.out.println(response.getErrorMessage());
		}else{
			System.out.println(response.getResultMessage());
		}
		
		
	}

}
