package ru.optima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.optima.controller.repr.UserRepr;
import ru.optima.persist.repo.RoleRepository;
import ru.optima.service.UserService;
import ru.optima.service.UserServiceImpl;
import ru.optima.warning.NotFoundException;

import javax.validation.Valid;

@Controller
public class UserController {

    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public UserController(RoleRepository roleRepository,
                          UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/admin/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userService.findById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @GetMapping("/admin/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new UserRepr());
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @PostMapping("/admin/user")
    public String adminUpsertUser(@Valid UserRepr user, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            return "user_form";
        }

        userService.save(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/user/{id}/delete")
    public String adminDeleteUser(Model model, @PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/roles")
    public String adminRolesPage(Model model) {
        model.addAttribute("activePage", "Roles");
        return "index";
    }
}
