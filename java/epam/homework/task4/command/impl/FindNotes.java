package epam.homework.task4.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import epam.homework.task4.bean.CurrentFileRequest;
import epam.homework.task4.bean.FindNotesRequest;
import epam.homework.task4.bean.Request;
import epam.homework.task4.bean.Response;
import epam.homework.task4.bean.entity.Note;
import epam.homework.task4.command.Command;
import epam.homework.task4.command.exception.CommandException;
import epam.homework.task4.service.NoteBookService;
import epam.homework.task4.service.ServiceFactory;
import epam.homework.task4.service.exception.ServiceException;

public class FindNotes implements Command {

	public Response execute(Request request) throws CommandException {

		Response response = new Response();
		FindNotesRequest req = new FindNotesRequest();
		if (request instanceof FindNotesRequest) {
			req = (FindNotesRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String keyWord = req.getKeyWords();
		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();
		
		try {
			for(Note found:nbService.findNotesByContent(keyWord)){
				System.out.println(found.getNote());
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check connection to file
/*		if (CurrentFileRequest.getCurrentFileName() != null) {
			req.setFileName(CurrentFileRequest.getCurrentFileName());
		} else {
			response.setErrorStatus(true);
			response.setErrorMessage("Sorry! But first you need to load or create a NOTEBOOK file!");
			return response;
		}
		// .....
		String line;
		int lineNumber = 0;
		String fileName = req.getFileName();
		
		File file = new File(fileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while ((line = br.readLine()) != null) {
				lineNumber++;
				if (line.contains(keyWord)) {
					System.out.println("Was found on the " + lineNumber + " line: " + line);
				}
			}
			br.close();
			if (lineNumber == 0)
				System.out.println("По заданному поиску ничего не найденно. Возможно следует сохранить проект и повторить поиск.\nВы искали: " + keyWord);
			
		} catch (FileNotFoundException e1) {
			response.setErrorStatus(true);
			response.setErrorMessage("файл с таким именем: " + fileName + ". Попробуйте еще.");

		} catch (IOException e) {
			response.setErrorStatus(true);
			response.setErrorMessage("чтото пошло не так... имя файла " + fileName + ". Попробуйте еще.");

		}     */

		response.setErrorStatus(false);
		response.setResultMessage("\nПоиск завершен успешно\n");
		return response;
	}

}
