package ian.projects.backend.service;

import ian.projects.backend.domain.Book;

/**
 * Service interface for managing books in the bookstore system.
 */
public interface BookService {

	/**
	 * Retrieve a book by its unique ID.
	 *
	 * @param id the ID of the book
	 * @return the Book object if found
	 * @throws RuntimeException if the book is not found
	 */

	Book findBookByCodeBook(Long id);
}
