package org.example.webiste.repository;

import org.example.webiste.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User saved);

    List<User> findAll();

    void deleteById(Long id);

    Optional<User> findById (Long id);

    List<User> findByName(String name);
}
