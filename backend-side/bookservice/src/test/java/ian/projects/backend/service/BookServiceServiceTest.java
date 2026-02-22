package ian.projects.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ian.projects.backend.domain.Book;
import ian.projects.backend.repository.BookServiceRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceServiceTest {
	
	@Mock
	private BookServiceRepository bookServiceRepository;
	
	@InjectMocks
	private BookServiceService bookServiceService;
	
	
	@Test
	void shouldReturnBookByAuthor() {
		
		Book book1 = new Book();
		book1.setTitle("The Human Condition");
		book1.setAuthor("Hannah Arendt");
		
		Book book2 = new Book();
		book2.setTitle("Organo");
		book2.setAuthor("Aristotle");
		
		when(bookServiceRepository.findByAuthor("Hannah Arendt")).thenReturn(Collections.singletonList(book1));
		
		List<Book> result = bookServiceService.getBooksByAuthor("Hannah Arendt");
		
		assertEquals(1, result.size());
		
		assertEquals("Hannah Arendt", result.get(0).getAuthor());
		
		verify(bookServiceRepository, times(1)).findByAuthor("Hannah Arendt");		
	}

}
