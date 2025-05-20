package hama.soombilab.otlpdemo.feature.findUser.usecase;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.findUser.api.FindUserResponse;
import hama.soombilab.otlpdemo.feature.findUser.api.FindUserUsecase;
import hama.soombilab.otlpdemo.infra.UserInfra;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUserUsecaseImpl implements FindUserUsecase {

    private final FindUserUsecaseMapper findUserUsecaseMapper;
    private final UserInfra userInfra;

    @Override
    public List<FindUserResponse> findUsers() {
        List<User> users = userInfra.findUsers();
        return users
            .stream()
            .map(findUserUsecaseMapper::toFindUserResponse)
            .toList();
    }
}
