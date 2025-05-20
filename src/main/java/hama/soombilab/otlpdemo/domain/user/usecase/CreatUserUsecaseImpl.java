package hama.soombilab.otlpdemo.domain.user.usecase;

import hama.soombilab.otlpdemo.domain.user.api.CreateUserUsecase;
import hama.soombilab.otlpdemo.domain.user.model.User;
import hama.soombilab.otlpdemo.domain.user.api.dto.CreatUserRequest;
import hama.soombilab.otlpdemo.domain.user.api.dto.CreateUserResponse;
import hama.soombilab.otlpdemo.domain.user.infra.UserInfraImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatUserUsecaseImpl implements CreateUserUsecase {

    private final CreateUserUsecaseMapper usecaseMapper;
    private final UserInfraImpl userRepositoryImpl;

    public CreateUserResponse createUser(CreatUserRequest creatUserRequest) {
        User user = User.create(creatUserRequest);
        User savedUser = userRepositoryImpl.save(user);
        return usecaseMapper.toCreateUserResponse(savedUser);
    }
}
