package epam.homework.task4.service.impl;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import epam.homework.task4.bean.entity.Note;
import epam.homework.task4.bean.entity.NoteBook;
import epam.homework.task4.date.DateChekFormat;
import epam.homework.task4.source.NoteBookProvider;
import epam.homework.task4.service.NoteBookService;
import epam.homework.task4.service.exception.ServiceException;

public class NoteBookServiceImpl implements NoteBookService {

	public void addNote(String note) throws ServiceException {
		// parameters validation
		if (note == null || "".equals(note)) {
			throw new ServiceException("Wrong parameter!");
		}

		Note newNote = new Note(note);

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.add(newNote);
	}

	@Override
	public void clearNoteBook() {

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		noteBook.clearNoteBook();

	}

	public List<Note> findNotesByContent(String keyWords) throws ServiceException {

		// parameters validation

		if (keyWords == null || "".equals(keyWords)) {

			throw new ServiceException("Wrong parameter!");

		}

		List<Note> foundNotes = new ArrayList<Note>();

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		foundNotes = noteBook.FindNotesByContent(keyWords);
		if(foundNotes.isEmpty())
			System.out.println("There is nothing found by yor request");
		else
			System.out.println("\nHere is found notes:\n");
		return foundNotes;

	}

	@Override

	public List<Note> findNotesByDate(String dateKey) throws ServiceException {

		// parameters validation

		if (!DateChekFormat.isValid(dateKey)) {
			throw new ServiceException(
					"WRONG FORMAT" + dateKey + "\nPlease write date in correct format. \'yyyy-MM-dd\' ");
		}

		List<Note> foundNotes;

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		foundNotes = noteBook.FindNotesByDate(dateKey);
		if(!foundNotes.isEmpty()){
			System.out.println("\nTake a result of search:\n");
		}else{
			System.out.println("\nSorry, but we found nothing by your date key\n");
		}
		return foundNotes;

	}

/*	@Override

	public void showAllNotes() {

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		noteBook.showNotes();

	}		*/

	@Override

	public void writeNotesFromFile(String loadFileName) throws ServiceException {

		try {

			FileInputStream loadFile = new FileInputStream(loadFileName);

			ObjectInputStream ois = new ObjectInputStream(loadFile);

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			while (loadFile.available() > 0) {

				Note currentNote = (Note) ois.readObject();
				noteBook.add(currentNote);

				
				
			}

			ois.close();

			loadFile.close();

		} catch (EOFException e) {

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	@Override

	public void writeNotesToFile(String fileLocation) throws ServiceException {

		try {

			FileOutputStream os = new FileOutputStream(fileLocation);

			ObjectOutputStream oos = new ObjectOutputStream(os);

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			for (Note note : noteBook.getNotes()) {

				oos.writeObject(note);

				oos.reset();

			}

			oos.close();

			os.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
