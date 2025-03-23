package com.Buyuklyan.journalBuy.domain.services;


import com.Buyuklyan.journalBuy.domain.Role;
import com.Buyuklyan.journalBuy.domain.User;
import com.Buyuklyan.journalBuy.domain.entity.*;
import com.Buyuklyan.journalBuy.domain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.STUDENT);
        user.setRoles(roles);
        return save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Поиск пользователя по имени
        User user = userRepository.findByUsername(username);

        // Если пользователь не найден, выбрасываем исключение
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Возвращаем пользователя как объект UserDetails
        return (UserDetails) user;
    }

    public User save(User user) {
        User userFromDB = userRepository.save(user);
        return userFromDB;
    }
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public List<User> findALl(){
        return userRepository.findAll();
    }
}