package hu.ponte.hr.controller.upload;

import hu.ponte.hr.controller.ImageMeta;
import hu.ponte.hr.services.ImageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Component
@RequestMapping("api/file")
public class UploadController
{



    @Autowired
    private  ImageStore imageStore;
    public static String uploadDirectory = System.getProperty("user.dir")+ "/uploads";

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file) {

            String fileName= file.getOriginalFilename();
            String filePath= Paths.get(uploadDirectory, fileName).toString();
            String fileType = file.getContentType();
            long size = file.getSize();
           ImageMeta imageMeta = new ImageMeta();
            imageMeta.setName(fileName);
            imageMeta.setSize(size);
            imageMeta.setMimeType(fileType);
            imageMeta.setDigitalSign(fileName);

            imageStore.saveImages(imageMeta);
            return "";
    }
}
