package epam.howork.task3.command.impl;

import java.io.File;
import java.util.Scanner;

import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.command.Command;
import epam.howork.task3.command.exception.CommandException;

public class LoadNoteBookFile implements Command {

	public Response execute(Request request) throws CommandException {

		Response response = new Response();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter file name for load (without dot txt): ");
		String fileName = in.nextLine() + ".txt";
		
		File  loadFile = new File("./");
		String [] find = loadFile.list();
		int count = 0;
		for(String searchName:find){
			
			if (searchName.equals(fileName)) {
				response.setLoadStatus(true);
				response.setResultLoadMessage(fileName);
				count++;
				break;
			
		}
			}
		
				if(count==0){
					response.setLoadStatus(false);
					response.setErrorLoadMessage(fileName + " does not found!!!");
					
				}
				
		return response;
	}

}
