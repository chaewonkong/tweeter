package cc.leon.tweeter.service;

import cc.leon.tweeter.model.User;
import cc.leon.tweeter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        User savedUser = userRepository.save(user);

        return savedUser;
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
