package main.service;

import main.models.User;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @Transactional
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

//    @Transactional
    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

//    @Transactional
    public boolean getMatch(User user){
        if (findByLogin(user.getLogin()) == null) {
            return false;
        } else {
            User required = findByLogin(user.getLogin());
            return passwordEncoder.matches(user.getPassword(), required.getPassword());
        }
    }
}
