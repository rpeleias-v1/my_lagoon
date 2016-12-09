package br.com.rodrigopeleias.service;

import br.com.rodrigopeleias.models.User;

public interface UserService {

    User save(User user);

    User findByUserName(String userName);
}
