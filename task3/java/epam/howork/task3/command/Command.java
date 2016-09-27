package epam.howork.task3.command;

import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.command.exception.CommandException;

public interface Command {
	Response execute(Request request) throws CommandException;
}
