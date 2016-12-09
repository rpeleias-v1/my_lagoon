package br.com.rodrigopeleias.repository;

import br.com.rodrigopeleias.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    User save(User user);

    User findByUserName(String userName);
}
