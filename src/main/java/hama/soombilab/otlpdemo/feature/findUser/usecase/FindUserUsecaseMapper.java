package hama.soombilab.otlpdemo.feature.findUser.usecase;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.findUser.api.FindUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FindUserUsecaseMapper {

    FindUserResponse toFindUserResponse(User user);
}
