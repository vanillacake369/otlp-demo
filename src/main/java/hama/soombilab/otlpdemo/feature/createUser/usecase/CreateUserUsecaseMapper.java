package hama.soombilab.otlpdemo.feature.createUser.usecase;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.createUser.api.dto.CreateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CreateUserUsecaseMapper {

    CreateUserResponse toCreateUserResponse(User user);
}
