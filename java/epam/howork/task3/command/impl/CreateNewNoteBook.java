package epam.howork.task3.command.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import epam.howork.task3.bean.FileNameResponse;
import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.command.Command;
import epam.howork.task3.command.exception.CommandException;

public class CreateNewNoteBook implements Command {

	public Response execute(Request request) {

		Response response = new Response();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter new file name: ");
		
		Date date = new Date();
		FileNameResponse fileName = new FileNameResponse();
		fileName.setFileName(in.nextLine() + ".txt");
		File newFile = new File(fileName.getFileName());
		
		try {
			FileWriter addText = new FileWriter(newFile);
			addText.write("You just generating a new file with name: <" + fileName + "> at: " + date);
			addText.close();
		} catch (IOException e) {

			response.setErrorStatus(true);
			response.setErrorMessage("I think that something wrong with file name.\n"
					+ "Please try to create new file again with another name.");

		}

		fileName.setFileNameStatus(true);
		response.setErrorStatus(false);
		response.setResultMessage("File was created!");

		return response;
	}

}
