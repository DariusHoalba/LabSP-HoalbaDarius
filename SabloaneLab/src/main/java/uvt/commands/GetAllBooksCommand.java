package uvt.commands;

import uvt.services.BooksService;

public class GetAllBooksCommand implements Command{
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public void execute() {
        booksService.getAllBooks();
    }
}
