package uploadandget.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uploadandget.image.domain.FileData;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
}
