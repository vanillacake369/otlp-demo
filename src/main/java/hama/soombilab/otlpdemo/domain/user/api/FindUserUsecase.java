package hama.soombilab.otlpdemo.domain.user.api;

import hama.soombilab.otlpdemo.domain.user.api.dto.FindUserResponse;
import java.util.List;

public interface FindUserUsecase {

    List<FindUserResponse> findUsers();
}
