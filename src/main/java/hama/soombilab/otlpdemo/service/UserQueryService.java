package hama.soombilab.otlpdemo.service;

import hama.soombilab.otlpdemo.model.User;
import hama.soombilab.otlpdemo.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public List<User> findUsers() {
        return userRepository.findUsers();
    }
}
