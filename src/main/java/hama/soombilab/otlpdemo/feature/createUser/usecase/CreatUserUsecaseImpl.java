package hama.soombilab.otlpdemo.feature.createUser.usecase;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreatUserRequest;
import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreateUserResponse;
import hama.soombilab.otlpdemo.feature.createUser.api.CreateUserUsecase;
import hama.soombilab.otlpdemo.infra.UserInfraImpl;
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
