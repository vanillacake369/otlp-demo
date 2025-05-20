package hama.soombilab.otlpdemo.domain.user.api;

import hama.soombilab.otlpdemo.domain.user.api.dto.CreatUserRequest;
import hama.soombilab.otlpdemo.domain.user.api.dto.CreateUserResponse;

public interface CreateUserUsecase {

    CreateUserResponse createUser(CreatUserRequest creatUserRequest);
}
