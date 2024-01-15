package uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uvt.commands.*;
import uvt.models.*;
import uvt.repos.BookRepository;
import uvt.repos.AuthorRepository;
import uvt.repos.SectionRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
public class BookController {
    //private List<Book> books = new ArrayList<>();
    private final CreateBookCommand addBook;
    private final DeleteBookCommand deleteBook;
    private final UpdateBookCommand updateBook;
    private final GetAllBooksCommand getAllBooks;
    private final GetBookByNameCommand getBookByName;

    private final BookRepository bookRepository;
    private final SectionRepository sectionRepository;
    private final AuthorRepository authorRepository;

    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BookController(CreateBookCommand addBook, DeleteBookCommand deleteBook, UpdateBookCommand updateBook, GetAllBooksCommand getAllBooks, GetBookByNameCommand getBookByName, BookRepository bookRepository, SectionRepository sectionRepository, AuthorRepository authorRepository, AllBooksSubject allBooksSubject) {
        this.addBook = addBook;
        this.deleteBook = deleteBook;
        this.updateBook = updateBook;
        this.getAllBooks = getAllBooks;
        this.getBookByName = getBookByName;
        this.bookRepository = bookRepository;
        this.sectionRepository = sectionRepository;
        this.authorRepository = authorRepository;
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        /*List<Book> books = getAllBooks.execute();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }*/
        return getAllBooks.execute();
    }

    @PostMapping("/create")
    public CompletableFuture<Book> createBook(@RequestBody Book book) throws IOException {
        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            authorRepository.save(author);
        }
        for(Element e:book.getSections()){
            sectionRepository.save((Section) e);
        }

        addBook.setBook(book);
        allBooksSubject.add(book);
        return addBook.execute();
    }


    @GetMapping("books/{name}")
    public Optional<Book> getBookById(@PathVariable String name) {
        getBookByName.setBookName(name);
        return getBookByName.execute();
    }


    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
        updateBook.setBook(id,updatedBook);
        return updateBook.execute();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        deleteBook.setId(id);
        deleteBook.execute();
    }

}
