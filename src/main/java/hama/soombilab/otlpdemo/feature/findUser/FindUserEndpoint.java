package hama.soombilab.otlpdemo.feature.findUser;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindUserEndpoint {

    private final FindUserUsecase findUserUsecase;

    @GetMapping("/user")
    public ResponseEntity<List<FindUserResponse>> findUsers() {
        return ResponseEntity.ok(findUserUsecase.findUsers());
    }
}
