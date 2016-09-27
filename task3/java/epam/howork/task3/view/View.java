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
		request.setNote("my message");
		
		Response response = controller.doRequest(request);
		
		if(response.isErrorStatus() ==  false){
			System.out.println(response.getErrorMessage());
		}else{
			
		}
		
		
	}

}
