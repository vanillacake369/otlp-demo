package hama.soombilab.otlpdemo.infra;

import hama.soombilab.otlpdemo.domain.User;
import java.util.List;

public interface UserInfra {

    List<User> findUsers();

    User save(User user);

    User findUser(Long userIdx);
}
