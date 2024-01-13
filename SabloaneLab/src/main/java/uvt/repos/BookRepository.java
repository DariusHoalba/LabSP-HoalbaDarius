package uvt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uvt.models.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
