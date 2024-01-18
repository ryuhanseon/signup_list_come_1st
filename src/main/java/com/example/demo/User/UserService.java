package com.example.demo.User;


import com.example.demo.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User create(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
    public User getUser(String username){
        Optional<User> user = this.userRepository.findByUsername(username);
        if (user.isPresent()){
            return user.get();
        }else {
            throw new DataNotFoundException("user not found");
        }

    }


    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }


}
