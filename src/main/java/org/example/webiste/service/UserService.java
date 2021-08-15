package org.example.webiste.service;

import org.example.webiste.DTO.UserDto;
import org.example.webiste.entity.User;
import org.example.webiste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDto dto) {
        System.out.println("create user " + dto.getName() + " " + dto.getBirthYear());
        if (dto.getName() != null && dto.getBirthYear() != 0) {
            User user = new User(dto.getName(), dto.getBirthYear());
            return userRepository.save(user);
        }
        return null;
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        System.out.println("delete user " + id);
        userRepository.deleteById(id);
    }

    public UserDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return  toDto(user.get());
        } else  {
            System.out.println("user not found");
            return null;
        }
    }

    public void edit(UserDto dto) {
        Optional<User> userOptional = userRepository.findById(dto.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println("update user " + user.getName() + " " + user.getBirthYear() + " to value " + dto.getBirthYear());

            user.setBirthYear(dto.getBirthYear());
            userRepository.save(user);
        } else {
            System.out.println("user not found");
        }

    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getBirthYear());
    }

}
