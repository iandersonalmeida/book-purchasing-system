package ian.projects.backend.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import ian.projects.backend.domain.Book;
import ian.projects.backend.service.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.apache.hc.core5.http.HttpStatus;

@WebMvcTest(BookController.class)
public class BookControllerTest {

	@MockitoBean
	private BookServiceImpl bookService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Should return book when id exists")
	public void shouldReturnBookWhenIdExists() throws Exception {
		// Given
		Book book = new Book();
		book.setBookCode(1L);
		book.setTitle("The Human Condition");
		book.setAuthor("Hannah Arendt");

		given(bookService.findBookByCodeBook(book.getBookCode())).willReturn(book);

		// When
		MockHttpServletResponse response = mockMvc
				.perform(get("/bookservice/api/books/{book-code}", book.getBookCode()).accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse();

		// Then
		assertEquals(HttpStatus.SC_OK, response.getStatus());
	}
}
