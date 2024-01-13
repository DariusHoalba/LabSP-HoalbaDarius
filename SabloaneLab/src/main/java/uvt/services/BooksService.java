package uvt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uvt.models.Book;
import uvt.repos.BookRepository;
import uvt.repos.SectionRepository;
import uvt.repos.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class BooksService {
    private List<Book> books = new ArrayList<>();
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BooksService(BookRepository bookRepository , AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByName(String name) {
        return books.stream()
                .filter(book -> book.getTitle().equals(name))
                .findFirst()
                .orElse(null);
    }

    public CompletableFuture<Book> addBook(Book book) {
        Book createdBook = bookRepository.save(book);
        return CompletableFuture.completedFuture(createdBook);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Long bookId, Book updatedBookData) {
        if (bookRepository.existsById(Math.toIntExact(bookId))) {
            updatedBookData.setId(bookId);
            bookRepository.save(updatedBookData);

        }
    }

}
