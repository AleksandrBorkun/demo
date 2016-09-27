package epam.howork.task3.command.impl;

import epam.howork.task3.bean.AddNoteRequest;
import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.bean.entity.Note;
import epam.howork.task3.bean.entity.NoteBook;
import epam.howork.task3.command.Command;
import epam.howork.task3.command.exception.CommandException;
import epam.howork.task3.source.NoteBookProvider;

public class AddNewNote implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		AddNoteRequest req = null;
		
		if(request instanceof AddNoteRequest){
			req = (AddNoteRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}
		
		String note = req.getNote();
		
		Note newNote = new Note();
		
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		// noteBook.add(newNote);
		
		
		Response response = new Response();
		response.setErrorStatus(false);
		response.setResultMessage("All OK!");
		
		
		return response;
	}

}
