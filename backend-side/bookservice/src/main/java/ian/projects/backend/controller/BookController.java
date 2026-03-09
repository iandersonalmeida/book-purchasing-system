package ian.projects.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ian.projects.backend.domain.Book;
import ian.projects.backend.service.BookServiceImpl;

/**
 * REST controller for handling HTTP requests related to books. Exposes
 * endpoints for retrieving books from the system.
 */
@RestController
@RequestMapping(value = "/bookservice/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	/**
	 * Service layer used to process business logic for books.
	 */
<<<<<<< HEAD
	private BookServiceImpl bookService;
=======
	private BookServiceImpl bookServiceService;
>>>>>>> 9ae297fd5112853881f338b94f8897cbed165071

	/**
	 * Constructs a BookController with the given BookService. The BookService is
	 * automatically injected by Spring.
	 *
	 * @param bookService the service responsible for book operations
	 */
	@Autowired
<<<<<<< HEAD
	public BookController(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

=======
	public BookController(BookServiceImpl bookServiceService) {
		this.bookServiceService = bookServiceService;
	}

	
>>>>>>> 9ae297fd5112853881f338b94f8897cbed165071
	/**
	 * Retrieves all books from the system.
	 *
	 * Example request: GET /api/books
	 *
	 * @return a list of all Book objects
	 */
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

}
