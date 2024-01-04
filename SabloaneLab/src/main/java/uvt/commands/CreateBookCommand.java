package uvt.commands;

import uvt.models.Book;
import uvt.services.BooksService;

public class CreateBookCommand implements Command{
    private final BooksService booksService;
    private Book book;

    public CreateBookCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        booksService.addBook(book);
    }
}
