package epam.homework.task4.service;

import java.util.Date;
import java.util.List;

import epam.homework.task4.service.exception.ServiceException;
import epam.homework.task4.bean.entity.Note;;

public interface NoteBookService {

	void addNote(String note) throws ServiceException;

	void clearNoteBook();

	List<Note> findNotesByContent(String strToFind) throws ServiceException;

	List<Note> findNotesByDate(String dateToFind) throws ServiceException;

//	void showAllNotes();

	void writeNotesFromFile(String fileLocation) throws ServiceException;

	void writeNotesToFile(String fileLocation) throws ServiceException;

}
