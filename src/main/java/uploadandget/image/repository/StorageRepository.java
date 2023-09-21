package uploadandget.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uploadandget.image.domain.ImageData;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {
    Optional<ImageData> findByName(String fileName);
}
