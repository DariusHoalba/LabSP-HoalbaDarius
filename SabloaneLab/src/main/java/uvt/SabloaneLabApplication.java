package uvt;

import uvt.models.Book;
import uvt.models.Element;
import uvt.models.Paragraph;
import uvt.models.Section;
import uvt.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"uvt.models", "uvt.services"})
public class   SabloaneLabApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SabloaneLabApplication.class, args);
        /*TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent)context.getBean("clientComponent");
        c.operation();*/


        BooksService booksService = context.getBean(BooksService.class);
        BookController bookController = context.getBean(BookController.class);

        Book book = new Book("Carte1");

        Section cap1 = new Section("Capitolul 1");
        cap1.add(new Paragraph("Paragraph 1"));
        cap1.add(new Paragraph("Paragraph 2"));
        cap1.add(new Paragraph("Paragraph 3"));
        book.addContent(cap1);
        book.addContent(new Paragraph("Multumesc!"));
        bookController.createBook(book);
        bookController.getAll();


    }
}
