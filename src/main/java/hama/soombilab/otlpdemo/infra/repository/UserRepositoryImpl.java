package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
import hama.soombilab.otlpdemo.infra.dao.UserDaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class UserRepositoryImpl implements UserRepository {

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
