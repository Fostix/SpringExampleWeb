package example.springframework.spring6webapp.services;

import example.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
