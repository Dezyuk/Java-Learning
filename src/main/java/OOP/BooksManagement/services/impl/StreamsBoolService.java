package OOP.BooksManagement.services.impl;

import OOP.BooksManagement.Author;
import OOP.BooksManagement.Book;
import OOP.BooksManagement.Publisher;
import OOP.BooksManagement.services.BookService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamsBoolService implements BookService {
    @Override
    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        if (author == null || books == null) {
            return new Book[0];
        }
        return Arrays.stream(books).filter(Objects::nonNull).filter(book -> book.hasAuthor(author)).toArray(Book[]::new);
    }

    @Override
    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        if (publisher == null || books == null) {
            return new Book[0];
        }
        return Arrays.stream(books).filter(Objects::nonNull).filter(book -> book.getPublisher().equals(publisher)).toArray(Book[]::new);
    }

    @Override
    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        if (yearFromInclusively <= 0 || books == null) {
            return new Book[0];
        }
        return Arrays.stream(books).filter(Objects::nonNull).filter(book -> book.getPublishingYear()>yearFromInclusively).toArray(Book[]::new);
    }
}
