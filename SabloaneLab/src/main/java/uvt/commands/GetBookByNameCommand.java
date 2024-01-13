package uvt.commands;

import org.springframework.stereotype.Component;
import uvt.models.Book;
import uvt.services.BooksService;

import java.util.Optional;


@Component
public class GetBookByNameCommand implements Command<Optional<Book>>{
    private final BooksService booksService;
    private String bookName;

    public GetBookByNameCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public Optional<Book> execute() {
        return Optional.ofNullable(booksService.getBookByName(bookName));
    }
}
