package com.demo.bookstore_app.repo;

import com.demo.bookstore_app.models.Book;
import com.demo.bookstore_app.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepoTest
{

    @Autowired
    private BookRepository repo;

    @Test
    public void testfindByBookName(){
        Book book = new Book();
        String testTitle = "The Little prince";
        book.setBookName(testTitle);
        repo.save(book);
        List<Book> foundBooks = repo.findByBookNameContainingIgnoreCase(testTitle);
        assertFalse(foundBooks.isEmpty(), "The list shoud not be empty!");
    }


    @Test
    public void testfindByAuthorName(){
        Book book = new Book();
        String testAuthor = "Antoine de Saint-Exupery";
        book.setAuthorName(testAuthor);
        repo.save(book);
        List<Book> foundBooks = repo.findByAuthorNameContainingIgnoreCase(testAuthor);
        assertFalse(foundBooks.isEmpty(), "The list shoud not be empty!");
    }
}
