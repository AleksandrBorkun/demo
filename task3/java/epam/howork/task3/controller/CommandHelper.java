package epam.howork.task3.controller;

import java.util.HashMap;
import java.util.Map;

import epam.howork.task3.command.Command;
import epam.howork.task3.command.impl.AddNewNote;
import epam.howork.task3.command.impl.CreateNewNoteBook;
import epam.howork.task3.command.impl.FindNotes;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		
		commands.put("ADD_NEW_NOTE", new AddNewNote());
		commands.put("FIND_NOTES", new FindNotes());
		commands.put("CREATY_NEW_FILE", new CreateNewNoteBook());
	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}
