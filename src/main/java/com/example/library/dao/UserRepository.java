package com.example.library.dao;

import com.example.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);
}
