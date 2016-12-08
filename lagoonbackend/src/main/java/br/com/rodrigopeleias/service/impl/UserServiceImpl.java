package br.com.rodrigopeleias.service.impl;

import br.com.rodrigopeleias.models.User;
import br.com.rodrigopeleias.repository.UserRepository;
import br.com.rodrigopeleias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
