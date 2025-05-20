package hama.soombilab.otlpdemo.feature.createUser.api;

import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreatUserRequest;
import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreateUserResponse;

public interface CreateUserUsecase {

    CreateUserResponse createUser(CreatUserRequest creatUserRequest);
}
