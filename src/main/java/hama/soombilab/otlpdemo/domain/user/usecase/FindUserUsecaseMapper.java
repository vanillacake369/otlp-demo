package hama.soombilab.otlpdemo.domain.user.usecase;

import hama.soombilab.otlpdemo.domain.user.model.User;
import hama.soombilab.otlpdemo.domain.user.api.dto.FindUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FindUserUsecaseMapper {

    FindUserResponse toFindUserResponse(User user);
}
