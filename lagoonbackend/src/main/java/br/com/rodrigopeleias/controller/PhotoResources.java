package br.com.rodrigopeleias.controller;

import br.com.rodrigopeleias.models.Photo;
import br.com.rodrigopeleias.models.User;
import br.com.rodrigopeleias.service.PhotoService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PhotoResources {

    private String imageName;

    private PhotoService photoService;

    @Autowired
    public PhotoResources(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public String upload(HttpServletResponse response, HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> it = multipartRequest.getFileNames();
        MultipartFile multipartFile = multipartRequest.getFile(it.next());
        String filename = multipartFile.getOriginalFilename();
        this.imageName = filename;

        String path = new File("src/main/resources/static/images").getAbsolutePath() + "\\" + filename;

        try {
            multipartFile.transferTo(new File((path)));
            System.out.print(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Upload Image successful!";
    }

    @RequestMapping(value = "/photo/add", method = RequestMethod.POST)
    public Photo addPhoto(@RequestBody Photo photo) {
        photo.setImageName(imageName);
        return photoService.save(photo);
    }

    @RequestMapping(value = "/photo/user", method = RequestMethod.POST)
    public List<Photo> getPhotosByUser(@RequestBody User user) {
        return photoService.findByUser(user);
    }
}

