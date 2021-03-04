package ru.optima.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.optima.controller.repr.UserRepr;
import ru.optima.persist.model.User;
import ru.optima.service.UserService;
import ru.optima.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class RestUserController {
    private final UserService userService;

    @Autowired
    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRepr>> getallUsers() {
        List<UserRepr> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
