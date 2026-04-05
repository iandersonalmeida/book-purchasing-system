package ian.projects.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ian.projects.backend.domain.Book;
import ian.projects.backend.repository.BookRepository;

/**
 * Service class for Book-related business logic. Handles operations such as
 * retrieving books from the database. Communicates with the BookRepository to
 * fetch Book entities.
 */
@Service
public class BookServiceImpl implements BookService {

	/**
	 * Repository used to perform CRUD operations on Book entities.
	 */
	private BookRepository bookRepository;

	/**
	 * Constructs a BookService with the given BookRepository. The BookRepository is
	 * automatically injected by Spring.
	 *
	 * @param bookRepository the repository used for database operations
	 */
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAllBooks();
	}

	@Override
	public Book findBookByCodeBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

}
