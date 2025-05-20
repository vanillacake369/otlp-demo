package hama.soombilab.otlpdemo.feature.createUser;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatUserUsecaseImpl implements CreateUserUsecase {

    private final CreateUserUsecaseMapper usecaseMapper;
    private final UserRepositoryImpl userRepositoryImpl;

    public CreateUserResponse createUser(CreatUserRequest creatUserRequest) {
        User user = User.create(creatUserRequest);
        User savedUser = userRepositoryImpl.save(user);
        return usecaseMapper.toCreateUserResponse(savedUser);
    }
}
