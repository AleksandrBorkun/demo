package epam.homework.task12;

import java.security.GeneralSecurityException;

public class Book {

	private String title;

	private String author;

	private int price;

	private int edition;

	public Book(String title, String author, int price, int edition) {

		this.title = title;

		this.author = author;

		this.price = price;

		this.edition = edition;

	}

	@Override

	public String toString() {

		return "name = " + getClass() + " title = " + title + " by author " + author + ". The price is " + price;

	}

	@Override
	public boolean equals(Object obj) {

		if (!super.equals(obj))
			return false;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Book otherObj = (Book) obj;
		return this.edition == otherObj.edition;

	}

	@Override

	public int hashCode() {

		return 17 + 55 * edition;

	}

}