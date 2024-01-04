package uvt.services;

import org.springframework.stereotype.Service;
import uvt.models.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookByName(String name) {
        return books.stream()
                .filter(book -> book.getTitle().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public void updateBook(Book book) {
        Book bookToUpdate = getBookByName(book.getTitle());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setSections(book.getSections());
    }

}
