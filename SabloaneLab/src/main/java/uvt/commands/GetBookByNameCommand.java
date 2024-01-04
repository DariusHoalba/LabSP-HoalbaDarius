package uvt.commands;

import uvt.services.BooksService;

public class GetBookByNameCommand implements Command{
    private final BooksService booksService;
    private String bookName;

    public GetBookByNameCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void execute() {
        booksService.getBookByName(bookName);
    }
}
