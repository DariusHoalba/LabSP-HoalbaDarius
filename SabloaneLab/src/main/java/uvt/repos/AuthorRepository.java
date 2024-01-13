package uvt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uvt.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
