package hu.ponte.hr.services;

import hu.ponte.hr.controller.ImageMeta;
import hu.ponte.hr.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageStore {
    @Autowired
    private ImagesRepository imagesRepository;

    public static String uploadDirectory = System.getProperty("user.dir")+ "/uploads";
    public void saveImages(ImageMeta imageMeta){
        imagesRepository.save(imageMeta);
    }
}
