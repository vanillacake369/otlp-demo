package hama.soombilab.otlpdemo.controller;

import hama.soombilab.otlpdemo.controller.dto.request.UserRequest;
import hama.soombilab.otlpdemo.controller.dto.response.UserResponse;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
import hama.soombilab.otlpdemo.usecase.UserCommandUsecase;
import hama.soombilab.otlpdemo.usecase.UserQueryUsecase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserQueryUsecase userQueryUsecase;
    private final UserCommandUsecase userCommandUsecase;

    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> findUsers() {
        return ResponseEntity.ok(userQueryUsecase.findUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(
        @RequestBody UserRequest userRequest
    ) {
        return ResponseEntity.ok(userCommandUsecase.createUser(userRequest));
    }
}
