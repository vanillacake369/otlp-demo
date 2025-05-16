package hama.soombilab.otlpdemo.usecase;

import hama.soombilab.otlpdemo.controller.dto.response.UserResponse;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQueryUsecase {

    private final UserUsecaseMapper userUsecaseMapper;
    private final UserRepository userRepository;

    public List<UserResponse> findUsers() {
        List<User> users = userRepository.findUsers();
        return users
            .stream()
            .map(userUsecaseMapper::toUserResponse)
            .toList();
    }
}
