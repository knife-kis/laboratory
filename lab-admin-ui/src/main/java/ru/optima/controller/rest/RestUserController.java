package ru.optima.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.optima.controller.repr.UserRepr;
import ru.optima.service.UserService;
import ru.optima.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class RestUserController {
    private final UserServiceImpl userService;

    @Autowired
    public RestUserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRepr>> getallUsers() {
        List<UserRepr> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
