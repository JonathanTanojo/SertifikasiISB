package be.sertifikasi.isb.user.controller;

import be.sertifikasi.isb.response.model.Response;
import be.sertifikasi.isb.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Response> readUsers() {
        return userService.readUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> readUsersById(@PathVariable Long id) {
        return userService.readUsersById(id);
    }

}
