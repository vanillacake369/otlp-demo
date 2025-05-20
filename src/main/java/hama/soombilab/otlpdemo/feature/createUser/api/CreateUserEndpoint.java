package hama.soombilab.otlpdemo.feature.createUser.api;

import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreatUserRequest;
import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateUserEndpoint {

    private final CreateUserUsecase createUserUsecase;

    @PostMapping("/user")
    public ResponseEntity<CreateUserResponse> createUser(
        @RequestBody CreatUserRequest creatUserRequest
    ) {
        return ResponseEntity.ok(createUserUsecase.createUser(creatUserRequest));
    }
}
