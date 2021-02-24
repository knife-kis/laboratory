package ru.optima.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.optima.controller.repr.UserRepr;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    void save(UserRepr userRepr);

    List<UserRepr> findAll();

    Optional<UserRepr> findById(Long id);

    void delete(Long id);
}
