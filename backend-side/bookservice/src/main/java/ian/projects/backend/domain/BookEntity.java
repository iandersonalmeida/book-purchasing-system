package ian.projects.backend.domain;

import java.util.Objects;

//This class represents an Entity.

public class BookEntity {

	private final ISBN isbn;
	private final String title;
	private final String author;
	private final Price price;

	public BookEntity(ISBN isbn, String title, String author, Price price) {

		validateTitle(title);
		validateAuthor(author);
		validatePrice(price);
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;

	}

	private void validateTitle(String title) {

		if (title == null) {

			throw new IllegalArgumentException("Book Creation rejected. Title can not be null.");
		}
	}

	private void validateAuthor(String author) {

		if (author == null) {

			throw new IllegalArgumentException("Book Creation rejected. Author can not be null.");
		}

	}

	private void validatePrice(Price price) {

		if (price == null) {

			throw new IllegalArgumentException("Book Creation rejected. Price can not be null.");
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		return Objects.equals(isbn, other.isbn);
	}
	
	

}
