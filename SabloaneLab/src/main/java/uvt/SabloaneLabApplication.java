package uvt;

import uvt.models.*;
import uvt.repos.BookRepository;
import uvt.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"uvt.models", "uvt.services", "uvt.repos", "uvt.commands"})
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

        Author a1 = new Author("Author1");
        Author a2 = new Author("Author2");

        Book b1 = new Book("Book1");
        b1.addAuthor(a1);
        b1.addAuthor(a2);

        BookRepository bookRepository = context.getBean(BookRepository.class);

        bookRepository.save(b1);
    }
}
