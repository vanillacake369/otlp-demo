package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.User;
import java.util.List;

public interface UserRepository {

    List<User> findUsers();

    User save(User user);

    User findUser(Long userIdx);
}
