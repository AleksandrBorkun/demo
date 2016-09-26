package epam.homework.task12;

public class resultOfOverriding {

	public static void main(String args[]) {

		// Вводим значения в порядке : title : author : price : edition

		Book book = new Book("Title", "Name Surname", 200, 2012);
		Book otherBook = new Book("New Title", "Strange Name", 50, 2010);

		System.out.println(book.hashCode());
		System.out.println(otherBook.hashCode());

		System.out.println(book.equals(otherBook));

		System.out.println(book.toString());

	}

}