package hama.soombilab.otlpdemo.repository;

import hama.soombilab.otlpdemo.model.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private final static List<User> USERS = List.of(
        new User(UUID.randomUUID(), "John","010-1234-1234", LocalDateTime.now()),
        new User(UUID.randomUUID(), "Jane","010-1234-1234", LocalDateTime.now()),
        new User(UUID.randomUUID(), "Jackson","010-1234-1234", LocalDateTime.now()),
        new User(UUID.randomUUID(), "Joe","010-1234-1234", LocalDateTime.now())
    );


    public List<User> findUsers() {
        return List.copyOf(USERS);
    }
}
