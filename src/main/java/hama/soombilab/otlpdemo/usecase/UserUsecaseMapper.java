package hama.soombilab.otlpdemo.usecase;

import hama.soombilab.otlpdemo.controller.dto.response.UserResponse;
import hama.soombilab.otlpdemo.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserUsecaseMapper {

    UserResponse toUserResponse(User user);
}
