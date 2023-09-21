package uploadandget.image.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uploadandget.image.domain.ImageData;
import uploadandget.image.repository.StorageRepository;
import uploadandget.image.util.ImageUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile multipartFile) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .imageData(ImageUtils.compressImage(multipartFile.getBytes())).build());
        if(imageData != null){
            return "file upload successsfully : "+ multipartFile.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = storageRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
