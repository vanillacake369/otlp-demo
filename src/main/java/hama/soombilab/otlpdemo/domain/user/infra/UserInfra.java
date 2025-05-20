package hama.soombilab.otlpdemo.domain.user.infra;

import hama.soombilab.otlpdemo.domain.user.model.User;
import java.util.List;

public interface UserInfra {

    List<User> findUsers();

    User save(User user);

    User findUser(Long userIdx);
}
