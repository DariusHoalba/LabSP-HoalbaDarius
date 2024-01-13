package uvt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uvt.models.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
