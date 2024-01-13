package uvt.commands;

import org.springframework.stereotype.Component;
import uvt.models.Book;
import uvt.services.BooksService;

import java.util.List;


@Component
public class GetAllBooksCommand implements Command<List<Book>>{
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        /*List<Book> books = booksService.getAllBooks();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }*/
        return booksService.getAllBooks();
    }
}
