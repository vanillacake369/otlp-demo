package hama.soombilab.otlpdemo.domain.user.infra;

import hama.soombilab.otlpdemo.domain.user.infra.data.UserDao;
import hama.soombilab.otlpdemo.domain.user.infra.data.UserDaoRepository;
import hama.soombilab.otlpdemo.domain.user.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class UserInfraImpl implements UserInfra {

    private final UserDaoRepository userDaoRepository;

    public List<User> findUsers() {
        List<UserDao> userDaos = userDaoRepository.findAll();
        return userDaos
            .stream()
            .map(User::fromDao)
            .toList();
    }

    public User save(User user) {
        UserDao userDao = UserDao.fromDomain(user);
        userDaoRepository.save(userDao);
        return User.fromDao(userDao);
    }

    @Override
    public User findUser(Long userIdx) {
        UserDao userDao = userDaoRepository
            .findById(userIdx)
            .orElseThrow(() -> new RuntimeException("User Not Found"));
        return User.fromDao(userDao);
    }
}
