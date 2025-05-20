package hama.soombilab.otlpdemo.feature.createOrder;

import hama.soombilab.otlpdemo.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CreateOrderUsecaseMapper {

    @Mapping(target = "productDto", source = "order.product")
    CreateOrderResponse toCreateOrderResponse(Order order);
}
