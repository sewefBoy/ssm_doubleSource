package java.com.soecode.lyf.service.impl;

import static org.junit.Assert.fail;

import com.soecode.lyf.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.service.BookService;

import java.com.soecode.lyf.BaseTest;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}

	@Test
	public void getById() throws Exception {
		Book book = bookService.getById(1001);
		System.out.println(book.toString());
	}

}
