package epam.homework.task4.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import epam.homework.task4.bean.LoadFileRequest;
import epam.homework.task4.bean.Request;
import epam.homework.task4.bean.Response;
import epam.homework.task4.command.Command;
import epam.homework.task4.command.exception.CommandException;
import epam.homework.task4.service.NoteBookService;
import epam.homework.task4.service.ServiceFactory;
import epam.homework.task4.service.exception.ServiceException;

public class LoadNoteBookFile implements Command {

	public Response execute(Request request) throws CommandException {

		LoadFileRequest req = new LoadFileRequest();
		Response response = new Response();

		if (request instanceof LoadFileRequest) {
			req = (LoadFileRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}
		String fileName = req.getLoadFileName();

		// PATH FOR SEARH FILE
		File loadFile = new File("./");
		String[] find = loadFile.list();
		int count = 0;
		for (String searchName : find) {
			if (searchName.equals(fileName)) {
				ServiceFactory service = ServiceFactory.getInstance();
				NoteBookService nbService = service.getNoteBookService();
				try {
					nbService.writeNotesFromFile(fileName);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setErrorStatus(false);
				response.setResultMessage(fileName + " is load success!");
				count++;
				break;

				/*
				 * }
				 * 
				 * File f = new File(searchName); BufferedReader bf; try { bf =
				 * new BufferedReader(new FileReader(f)); String line; while
				 * ((line = bf.readLine()) != null) System.out.println(line);
				 * bf.close(); } catch (FileNotFoundException e) {
				 * e.printStackTrace(); } catch (IOException e) {
				 * e.printStackTrace(); }
				 * 
				 * 
				 * 
				 * 
				 * }
				 */
			}
		}
		if (count == 0) {
			response.setErrorStatus(true);
			response.setErrorMessage(fileName + " does not found!!!");
			return response;

		}

		return response;
	}

}
