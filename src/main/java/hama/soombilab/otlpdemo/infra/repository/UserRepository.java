package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private static final List<UserDao> USER_DAOS = new ArrayList<>(List.of(
        new UserDao(UUID.randomUUID(), "John", "010-1234-1234", LocalDateTime.now()),
        new UserDao(UUID.randomUUID(), "Jane", "010-1234-1234", LocalDateTime.now()),
        new UserDao(UUID.randomUUID(), "Jackson", "010-1234-1234", LocalDateTime.now()),
        new UserDao(UUID.randomUUID(), "Joe", "010-1234-1234", LocalDateTime.now())
    ));

    public List<User> findUsers() {
        List<UserDao> userDaos = List.copyOf(USER_DAOS);
        return userDaos
            .stream()
            .map(User::fromDao)
            .toList();
    }

    public User save(User user) {
        UserDao userDao = UserDao.fromDomain(user);
        USER_DAOS.add(userDao);
        return User.fromDao(userDao);
    }
}
