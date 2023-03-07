package example.springframework.spring6webapp.bootstrap;

import example.springframework.spring6webapp.domain.Author;
import example.springframework.spring6webapp.domain.Book;
import example.springframework.spring6webapp.domain.Publisher;
import example.springframework.spring6webapp.repositories.AuthorRepository;
import example.springframework.spring6webapp.repositories.BookRepository;
import example.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        luma.setFirstName("luma");
        luma.setLastName("Rick");

        Book spring = new Book();
        spring.setTitle("Spring Learn");
        spring.setIsbn("4323421");

        Author lumaSaved = authorRepository.save(luma);
        Book springSaved = bookRepository.save(spring);

        pumaSaved.getBooks().add(dddSaved);
        lumaSaved.getBooks().add(springSaved);
        dddSaved.getAuthors().add(pumaSaved);
        springSaved.getAuthors().add(lumaSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("1234 Main");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        springSaved.setPublisher(savedPublisher);

        pumaSaved.getBooks().add(dddSaved);
        lumaSaved.getBooks().add(springSaved);

        authorRepository.save(lumaSaved);
        authorRepository.save(pumaSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(springSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());


        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
