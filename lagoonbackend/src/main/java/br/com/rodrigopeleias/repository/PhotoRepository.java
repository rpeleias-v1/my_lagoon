package br.com.rodrigopeleias.repository;

import br.com.rodrigopeleias.models.Photo;
import br.com.rodrigopeleias.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long>{

    Photo save(Photo photo);

    List<Photo> findByUser(User user);

}
