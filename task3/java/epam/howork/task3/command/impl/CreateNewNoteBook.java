package epam.howork.task3.command.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.command.Command;
import epam.howork.task3.command.exception.CommandException;

public class CreateNewNoteBook implements Command {

	@Override
	public Response execute(Request request) {

		File myFile = new File("New Work Book.txt");

		try {

			FileWriter file = new FileWriter(myFile);
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
