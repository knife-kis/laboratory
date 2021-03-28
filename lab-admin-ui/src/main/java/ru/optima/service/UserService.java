package ru.optima.service;

import org.springframework.stereotype.Service;
import ru.optima.repr.UserRepr;
import ru.optima.persist.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    void save(UserRepr userRepr);

    List<UserRepr> findAll();

    User findById(Long id);

    void delete(Long id);

    User findByName(String name);

    void edit(User user);
}
