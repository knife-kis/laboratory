package ru.optima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.optima.repr.UserRepr;
import ru.optima.persist.model.User;
import ru.optima.persist.repo.UserRepository;
import ru.optima.warning.UserNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void save(UserRepr userRepr) {
        User user = new User();
        user.setId(userRepr.getId());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        user.setEmail(userRepr.getEmail());
        user.setFirstName(userRepr.getFirstName());
        user.setLastName(userRepr.getLastName());
        user.setPhone(userRepr.getPhone());
        user.setRoles(userRepr.getRoles());
        user.setWorks(userRepr.getWorks());
        userRepository.save(user);
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void edit(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<UserRepr> findAll() {
        return userRepository.findAll().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public Optional<UserRepr> findByLastName(String lastName) {
        return userRepository.findUserByLastName(lastName).map(UserRepr::new);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
