package uvt.services;

import uvt.models.Book;

import java.io.IOException;

public interface Observer {

    void update(Book book) throws IOException;

}