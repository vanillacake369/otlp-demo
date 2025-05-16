package hama.soombilab.otlpdemo.usecase;

import hama.soombilab.otlpdemo.controller.dto.request.UserRequest;
import hama.soombilab.otlpdemo.controller.dto.response.UserResponse;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCommandUsecase {

    private final UserUsecaseMapper userUsecaseMapper;
    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        User user = User.create(userRequest);
        User savedUser = userRepository.save(user);
        return userUsecaseMapper.toUserResponse(savedUser);
    }
}
