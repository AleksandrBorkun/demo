package epam.howork.task3.bean.entity;

import epam.howork.task3.date.FullDate;

public class Note {

	private String note;

	public Note(String note) {

		this.note = note;

	}

	public String getNote() {
		return FullDate.getFullDate() + ": " + note;
	}
}
