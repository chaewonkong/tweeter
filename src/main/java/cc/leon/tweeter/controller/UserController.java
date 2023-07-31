package cc.leon.tweeter.controller;

import cc.leon.tweeter.model.User;
import cc.leon.tweeter.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{userId}")
    public ResponseEntity<User> findOne(@PathVariable Long userId) {
        return userService.findById(userId)
                .map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody  User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }
}
