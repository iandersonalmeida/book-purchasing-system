package ian.projects.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ian.projects.backend.domain.Book;
import ian.projects.backend.repository.BookServiceRepository;

/**
 * Service class for Book-related business logic. Handles operations such as
 * retrieving books from the database. Communicates with the BookRepository to
 * fetch Book entities.
 */
@Service
public class BookServiceService {

	/**
	 * Repository used to perform CRUD operations on Book entities.
	 */
	private BookServiceRepository bookServiceRepository;

	/**
	 * Constructs a BookService with the given BookRepository. The BookRepository is
	 * automatically injected by Spring.
	 *
	 * @param bookRepository the repository used for database operations
	 */
	@Autowired
	public BookServiceService(BookServiceRepository bookServiceRepository) {
		this.bookServiceRepository = bookServiceRepository;
	}

	/**
	 * Retrieves all books written by the specified author.
	 *
	 * @param author the name of the author
	 * @return a list of Book objects written by the given author
	 */
	public List<Book> getBooksByAuthor(String author) {

		return bookServiceRepository.findByAuthor(author);
	}

	/**
	 * Retrieves all books from the database.
	 *
	 * @return a list of all Book objects
	 */

	public List<Book> getAllBooks() {
		return bookServiceRepository.findAllBooks();
	}

}
