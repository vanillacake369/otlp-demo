package hama.soombilab.otlpdemo.controller;

import hama.soombilab.otlpdemo.model.User;
import hama.soombilab.otlpdemo.service.UserQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserQueryService userQueryService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> findUsers() {
        return ResponseEntity.ok(userQueryService.findUsers());
    }
}
