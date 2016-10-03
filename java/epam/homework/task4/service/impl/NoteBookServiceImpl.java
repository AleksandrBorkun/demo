package epam.homework.task4.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import epam.homework.task4.bean.entity.Note;
import epam.homework.task4.bean.entity.NoteBook;
import epam.homework.task4.source.NoteBookProvider;
import epam.homework.task4.service.NoteBookService;
import epam.homework.task4.service.exception.ServiceException;

public class NoteBookServiceImpl implements NoteBookService {

	public void addNote(String note, Date date) throws ServiceException {
		// parameters validation
		if (note == null || "".equals(note)){
			throw new ServiceException("Wrong parameter!");
		}
		
				
		Note newNote = new Note();
		
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.add(newNote);
		
		public void clearNoteBook() {

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			noteBook.clearNoteBook();

		}



		public List<Note> findNotesByContent(String strToFind) throws ServiceException {

			// parameters validation

			if (strToFind == null || "".equals(strToFind)){

				throw new ServiceException("Wrong parameter!");

			}

			

			List<Note> foundNotes = new ArrayList<Note>();

			

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			foundNotes = noteBook.FindNotesByContent(strToFind); 

			

			return foundNotes;

		}



		@Override

		public List<Note> findNotesByDate(String dateToFind) throws ServiceException {

			// parameters validation

			if (dateToFind == null || "".equals(dateToFind)){

				throw new ServiceException("Wrong parameter!");

			}



			List<Note> foundNotes = new ArrayList<Note>();



			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			foundNotes = noteBook.FindNotesByDate(dateToFind); 

			

			return foundNotes;

		}



		@Override

		public void showAllNotes() {

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			noteBook.showNotes();

		}



		@Override

		public void writeNotesFromFile(String fileLocation) throws ServiceException {

			try {

				FileInputStream is = new FileInputStream(fileLocation);

				ObjectInputStream ois = new ObjectInputStream(is);

				

				NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

				

				while(is.available() > 0) {

					Note currentNote = (Note) ois.readObject();

					noteBook.addNote(currentNote);

				}

				

				ois.close();

				is.close();

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

				for(Note note : noteBook.getNotes()) {

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
