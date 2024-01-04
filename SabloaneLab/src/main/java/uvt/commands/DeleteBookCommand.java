package uvt.commands;

import uvt.services.BooksService;

public class DeleteBookCommand implements Command{
    private final BooksService booksService;

    private String bookName;

    public DeleteBookCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void execute() {
        booksService.deleteBook(booksService.getBookByName(bookName));
    }
}
