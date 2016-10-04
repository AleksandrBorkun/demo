package epam.homework.task4.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import epam.homework.task4.bean.CurrentFileRequest;
import epam.homework.task4.bean.FindNotesByDateRequest;
import epam.homework.task4.bean.Request;
import epam.homework.task4.bean.Response;
import epam.homework.task4.bean.entity.Note;
import epam.homework.task4.command.Command;
import epam.homework.task4.command.exception.CommandException;
import epam.homework.task4.date.DateChekFormat;
import epam.homework.task4.service.NoteBookService;
import epam.homework.task4.service.ServiceFactory;
import epam.homework.task4.service.exception.ServiceException;

public class FindNotesByDate implements Command {

	public Response execute(Request request) throws CommandException {
		
		FindNotesByDateRequest req = null;
		Response response = new Response();

		if (request instanceof FindNotesByDateRequest) {
			req = (FindNotesByDateRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		// Check connection to file
/*		if (CurrentFileRequest.getCurrentFileName() != null) {
			req.setFileName(CurrentFileRequest.getCurrentFileName());
		} else {
			response.setErrorStatus(true);
			response.setErrorMessage("Sorry! But first you need to load or create a NOTEBOOK file!");
			return response;*/
//		}
		// ...

//		String line;
//		int lineNumber = 0;
	//	String fileName = req.getFileName();
		String dateKey = req.getSearchDate();
		
		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();
		
		try{
			for(Note search :nbService.findNotesByDate(dateKey)){
				System.out.println(search.getNote());
				
			};
		}catch(ServiceException e) {
			throw new CommandException();
		}		
		
//		File file = new File(fileName);
//		BufferedReader br;

		
		// Checking searching date format, and then make a search
/*		if (DateChekFormat.isValid(dateKey)) {
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				while ((line = br.readLine()) != null) {
					lineNumber++;
					if (line.contains(dateKey)) {
						System.out.println("Was found on the " + lineNumber + " line: " + line);
					}
				}
				br.close();
				if (lineNumber == 0)
					System.out.println("По заданному поиску ничего не найденно. Возможно следует сохранить проект и повторить поиск. \nВы искали по дате: " + dateKey);
				response.setErrorStatus(false);
				response.setResultMessage("Поиск завершен успешно");

			} catch (FileNotFoundException e1) {
				response.setErrorStatus(true);
				response.setErrorMessage("файл с таким именем: \'" + fileName + "\'. Попробуйте еще.");

			} catch (IOException e) {
				response.setErrorStatus(true);
				response.setErrorMessage("чтото пошло не так... имя файла \'" + fileName + "\'. Попробуйте еще.");

			}
		} else {
			response.setErrorStatus(true);
			response.setErrorMessage(
					"WRONG FORMAT" + dateKey + "\nPlease write date in correct format. \'yyyy-MM-dd\' ");
			return response;
		}							*/
		
		response.setErrorStatus(false);
		response.setResultMessage("\nSearch by date complete success\n");
		return response;
	}

}
