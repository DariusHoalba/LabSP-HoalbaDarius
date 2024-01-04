package uvt.commands;

import uvt.models.Book;
import uvt.services.BooksService;

public class UpdateBookCommand implements Command{
    private final BooksService booksService;
    private String name;
    private Book updatedBook;

    public UpdateBookCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBookName(String name) {
        this.name = name;
    }

    public void setUpdatedBook(Book updatedBook) {
        this.updatedBook = updatedBook;
    }

    @Override
    public void execute() {
        booksService.updateBook(updatedBook);
    }
}
