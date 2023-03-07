package example.springframework.spring6webapp.bootstrap;

import example.springframework.spring6webapp.domain.Author;
import example.springframework.spring6webapp.domain.Book;
import example.springframework.spring6webapp.repositories.AuthorRepository;
import example.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author puma = new Author();
        puma.setFirstName("Puma");
        puma.setLastName("Hellower");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234");

        Author pumaSaved = authorRepository.save(puma);
        Book dddSaved = bookRepository.save(ddd);

        Author luma = new Author();
        puma.setFirstName("luma");
        puma.setLastName("Rick");

        Book spring = new Book();
        spring.setTitle("Spring Learn");
        spring.setIsbn("4323421");

        Author lumaSaved = authorRepository.save(luma);
        Book springSaved = bookRepository.save(spring);

        pumaSaved.getBooks().add(dddSaved);
        lumaSaved.getBooks().add(springSaved);

        authorRepository.save(lumaSaved);
        authorRepository.save(pumaSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
