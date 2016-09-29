package epam.howork.task3.command.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.bean.entity.Note;
import epam.howork.task3.bean.entity.NoteBook;
import epam.howork.task3.command.Command;
import epam.howork.task3.command.exception.CommandException;
import epam.howork.task3.source.NoteBookProvider;

public class SaveAddsToNoteBook implements Command {

	public Response execute(Request request) throws CommandException {

		
		Response response = new Response();
		Scanner in = new Scanner(System.in);
		System.out.println("Введите имя файла в который нужно сохранить проект");
		String filePath = in.nextLine()+".txt";
		List<Note> notes = NoteBookProvider.getInstance().getNoteBook().getNotes();

		for (Note ad : notes) {
			PrintWriter save;
			try {
				File fileName = new File(filePath);
				save = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
				save.println(ad.getNote());
				save.close();
				response.setErrorStatus(false);
				response.setResultMessage("Save Complete");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return response;
	}

}
