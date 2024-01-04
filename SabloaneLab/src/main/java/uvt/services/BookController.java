package uvt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uvt.commands.*;
import uvt.models.*;
import uvt.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BooksService booksService;

    @Autowired
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = booksService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Book> getBookById(@PathVariable String name){
        Book book = booksService.getBookByName(name);
        if(book == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        CreateBookCommand createBookCommand = new CreateBookCommand(booksService);
        createBookCommand.setBook(book);
        createBookCommand.execute();
        return new ResponseEntity<>("Book created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?>deleteBook(@PathVariable String name){
        DeleteBookCommand deleteBookCommand = new DeleteBookCommand(booksService);
        deleteBookCommand.setBookName(name);
        deleteBookCommand.execute();
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        GetAllBooksCommand getAllBooksCommand = new GetAllBooksCommand(booksService);
        getAllBooksCommand.execute();
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<?>getBook(@PathVariable String name){
        GetBookByNameCommand getBookByNameCommand = new GetBookByNameCommand(booksService);
        getBookByNameCommand.setBookName(name);
        getBookByNameCommand.execute();
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<?>updateBook(@PathVariable String name){
        UpdateBookCommand updateBookCommand = new UpdateBookCommand(booksService);
        updateBookCommand.setBookName(name);
        updateBookCommand.execute();
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> printStatistics(){
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
