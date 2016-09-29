package epam.howork.task3.bean.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import epam.howork.task3.date.FullDate;

public class Note {

	private String note;
	public Note(String note) {
		
		this.note = note;
/*		File addNote = new File("text.txt");
		try {
			PrintWriter someAdd = new PrintWriter(new BufferedWriter(new FileWriter(addNote)));
			someAdd.println(note);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}
	public String getNote() {
		return FullDate.getFullDate()+ ": "+ note;
	}
}
