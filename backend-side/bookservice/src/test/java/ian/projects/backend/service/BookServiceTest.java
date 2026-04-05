package ian.projects.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import ian.projects.backend.BookServiceApplication;
import ian.projects.backend.domain.Book;
import ian.projects.backend.repository.BookRepository;
import ian.projects.backend.service.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Unit test class for BookService. This class tests the business logic of
 * BookService using Mockito to mock the BookRepository dependency.
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository bookRepository;

	/**
	 * @InjectMocks creates a real instance of the class to be tested and injects
	 * 
	 *              mocks created with @Mock.
	 */
	@InjectMocks
	private BookServiceImpl bookService;

	@Test
	void returnBookById() {

		// given
		Book book = new Book();
		book.setBookCode(1L);
		book.setTitle("The Human Conditon");
		book.setAuthor("Hannah Arendt");
		book.setPrice(new BigDecimal("50.50"));

		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

		// when
		Book result = bookService.findBookByCodeBook(book.getBookCode());

		// then
		assertEquals("The Human Conditon", result.getTitle());
	}

}
