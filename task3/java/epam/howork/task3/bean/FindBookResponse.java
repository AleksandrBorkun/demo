package epam.howork.task3.bean;

import java.util.List;

import epam.howork.task3.bean.entity.Note;
import epam.howork.task3.bean.entity.NoteBook;

public class FindBookResponse extends Response {
	private List<Note> findBook;

	public List<NoteBook> getFindBook() {
		return FindBookResponse;
	}

	public void setFindBook(List<Note> findBook) {
		this.findBook = findBook;
	}

	
}
