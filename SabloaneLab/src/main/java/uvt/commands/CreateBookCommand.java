package uvt.commands;

import jakarta.persistence.Column;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import uvt.models.Author;
import uvt.models.Book;
import uvt.services.BooksService;

import java.util.concurrent.CompletableFuture;

@Component
public class CreateBookCommand implements Command<CompletableFuture<Book>>{
    private final BooksService booksService;
    private Book book;

    private Author author;

    public CreateBookCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    @Async
    public CompletableFuture<Book> execute() {
        return booksService.addBook(book);
    }
}
