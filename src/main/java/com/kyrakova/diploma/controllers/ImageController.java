package com.kyrakova.diploma.controllers;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.SimpleModel;
import com.kyrakova.diploma.models.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping("/images")
public class ImageController extends BaseController<Image> {

    @Autowired
    ImageController(BaseDao<Image> imageDao) {
        super(imageDao);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<SimpleModel> upload(@RequestParam("image") MultipartFile file) throws Exception {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setImage(file.getBytes());

        objDao.saveOrUpdate(image);

        SimpleModel simpleModel = new SimpleModel();
        simpleModel.setId(image.getId());

        return new ResponseEntity<SimpleModel>(simpleModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getById(@PathVariable("id") Long id) {
        Image image = objDao.get(id);
        return new ResponseEntity<byte[]>(image.getImage(), HttpStatus.OK);
    }
}
