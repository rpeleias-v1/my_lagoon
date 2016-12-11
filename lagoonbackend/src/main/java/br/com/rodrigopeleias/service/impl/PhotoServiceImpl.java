package br.com.rodrigopeleias.service.impl;

import br.com.rodrigopeleias.models.Photo;
import br.com.rodrigopeleias.models.User;
import br.com.rodrigopeleias.repository.PhotoRepository;
import br.com.rodrigopeleias.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    private PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public List<Photo> findByUser(User user) {
        return photoRepository.findByUser(user);
    }
}
