package epam.howork.task3.command.impl;

import java.util.Scanner;

import epam.howork.task3.bean.AddNoteRequest;
import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.bean.entity.Note;
import epam.howork.task3.bean.entity.NoteBook;
import epam.howork.task3.command.Command;
import epam.howork.task3.command.exception.CommandException;
import epam.howork.task3.source.NoteBookProvider;

public class AddNewNote implements Command {

	
	public Response execute(Request request) throws CommandException {
		
		AddNoteRequest req = new AddNoteRequest();
		Scanner in = new Scanner(System.in);
		Response response = new Response();
		
		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}
		
		
		
		req.setNote(in.nextLine());
		String note = req.getNote();
		
		Note newNote = new Note(note);		
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.add(newNote);
		
		
	

		response.setErrorStatus(false);
		response.setResultMessage("All OK!");
		
		
		return response;
	}

}
