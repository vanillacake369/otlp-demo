package hama.soombilab.otlpdemo.domain.user.usecase;

import hama.soombilab.otlpdemo.domain.user.api.FindUserUsecase;
import hama.soombilab.otlpdemo.domain.user.model.User;
import hama.soombilab.otlpdemo.domain.user.api.dto.FindUserResponse;
import hama.soombilab.otlpdemo.domain.user.infra.UserInfra;
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
