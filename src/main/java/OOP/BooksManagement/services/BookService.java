package OOP.BooksManagement.services;

import OOP.BooksManagement.Author;
import OOP.BooksManagement.Book;
import OOP.BooksManagement.Publisher;

public interface BookService {
     Book[] filterBooksByAuthor(Author author, Book[] books) ;
     Book[] filterBooksByPublisher(Publisher publisher, Book[] books) ;
     Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) ;
}
