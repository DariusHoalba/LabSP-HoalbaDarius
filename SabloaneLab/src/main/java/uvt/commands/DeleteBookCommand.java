package uvt.commands;

import org.springframework.stereotype.Component;
import uvt.models.Book;
import uvt.services.BooksService;

import java.util.concurrent.CompletableFuture;

@Component
public class DeleteBookCommand implements Command<Void> {
    private final BooksService booksService;

    private Integer id;
    private String bookName;

    private Book Book;

    public DeleteBookCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public Void execute() {
        booksService.deleteBook(id);
        return null;
    }

    public void setId(Integer id){
        this.id=id;

    }
}
