package hama.soombilab.otlpdemo.feature.findUser;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.repository.UserRepository;
import hama.soombilab.otlpdemo.feature.createUser.FindUserUsecaseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUserUsecaseImpl implements FindUserUsecase {

    private final FindUserUsecaseMapper findUserUsecaseMapper;
    private final UserRepository userRepository;

    @Override
    public List<FindUserResponse> findUsers() {
        List<User> users = userRepository.findUsers();
        return users
            .stream()
            .map(findUserUsecaseMapper::toFindUserResponse)
            .toList();
    }
}
