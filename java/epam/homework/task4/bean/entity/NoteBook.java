package epam.homework.task4.bean.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class NoteBook implements Serializable{

//	Note newNote;
	List<Note> notes = null;

	public NoteBook() {
		notes = new LinkedList<Note>();
	}

	public void add(Note newNote) {
		this.notes.add(newNote);
	}

	//
//	public static void setNotes(List<Note> notes) {
//		NoteBook.notes = notes;
//	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void clearNoteBook() {
		notes.clear();
		
		
	}

	public List<Note> FindNotesByContent(String strToFind) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Note> FindNotesByDate(String dateToFind) {
		// TODO Auto-generated method stub
		return null;
	}

	public void showNotes() {
		// TODO Auto-generated method stub
		
	}

	public void addNote(Note currentNote) {
		// TODO Auto-generated method stub
		
	}
}
