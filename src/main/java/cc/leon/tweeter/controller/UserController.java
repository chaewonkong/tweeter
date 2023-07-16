package cc.leon.tweeter.controller;

import cc.leon.tweeter.model.User;
import cc.leon.tweeter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getAll() {
        return "users";
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody  User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
}
