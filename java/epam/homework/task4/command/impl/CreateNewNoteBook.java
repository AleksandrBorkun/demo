package epam.homework.task4.command.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import epam.homework.task4.bean.CreateNewNoteBookRequest;
import epam.homework.task4.bean.Request;
import epam.homework.task4.bean.Response;
import epam.homework.task4.command.Command;
import epam.homework.task4.command.exception.CommandException;
import epam.homework.task4.date.FullDate;
import epam.homework.task4.service.NoteBookService;
import epam.homework.task4.service.ServiceFactory;
import epam.homework.task4.service.exception.ServiceException;

public class CreateNewNoteBook implements Command {

	public Response execute(Request request) throws CommandException {

		Response response = new Response();
		CreateNewNoteBookRequest req = new CreateNewNoteBookRequest();
		FullDate date = new FullDate();

		if (request instanceof CreateNewNoteBookRequest) {
			req = (CreateNewNoteBookRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();
		nbService.clearNoteBook();
		try {
			nbService.addNote("NoteBook is created");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	/*	File newFile = new File(req.getCreate());

		try {
			FileWriter addText = new FileWriter(newFile);
			addText.write("You just generating a new file with name: <" + req.getCreate() + "> at: "
					+ date.getFullDate() + "\n\n");
			addText.close();
		} catch (IOException e) {

			response.setErrorStatus(true);
			response.setErrorMessage("I think that something wrong with file name.\n"
					+ "Please try to create new file again with another name.");

		} 				*/

		response.setErrorStatus(false);
		response.setResultMessage("File was created!");

		return response;
	}

}
