package example.springframework.spring6webapp.services;

import example.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
