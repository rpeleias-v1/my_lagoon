package br.com.rodrigopeleias.service;

import br.com.rodrigopeleias.models.Photo;
import br.com.rodrigopeleias.models.User;

import java.util.List;


public interface PhotoService {
    Photo save(Photo photo);

    List<Photo> findByUser(User user);
}
