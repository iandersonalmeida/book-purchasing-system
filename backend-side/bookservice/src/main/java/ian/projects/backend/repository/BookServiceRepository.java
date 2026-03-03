package ian.projects.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ian.projects.backend.domain.Book;

/**
 * Repository interface for managing Book entities in the database. Provides
 * CRUD operations via JpaRepository and custom queries.
 */
public interface BookServiceRepository extends JpaRepository<Book, Integer> {

	/**
	 * Finds all books written by the specified author.
	 *
	 * @param author the name of the author
	 * @return a list of Book objects written by the given author
	 */
	// @Query("select b from Book b where b.author = ?1")
	public List<Book> findByAuthor(String author);

	/**
	 * Retrieves all books from the database.
	 *
	 * @return a list of all Book objects
	 */
	@Query("select b from Book b")
	public List<Book> findAllBooks();
}
