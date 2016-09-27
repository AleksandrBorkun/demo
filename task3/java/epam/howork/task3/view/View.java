package epam.howork.task3.view;

import epam.howork.task3.bean.AddNoteRequest;
import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.controller.Controller;

public class View {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		String s = "CREATE_NEW_FILE";
				 
		AddNoteRequest request = new AddNoteRequest();
		if(s=="1")
		request.setCommandName("ADD_NEW_NOTE");
		if(s=="2")
		request.setNote("my message");
		if(s.equals("CREATE_NEW_FILE"))
		request.setCommandName("CREATE_NEW_FILE");
		
		Response response = controller.doRequest(request);
		
		if(response.isErrorStatus() ==  false){
			System.out.println(response.getErrorMessage());
		}else{
			
		}
		
		
	}

}
