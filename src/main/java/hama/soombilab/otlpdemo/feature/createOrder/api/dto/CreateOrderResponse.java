package hama.soombilab.otlpdemo.feature.createOrder.api.dto;

import hama.soombilab.otlpdemo.global.value.Money;
import java.time.LocalDateTime;

public record CreateOrderResponse(
    Long id,
    ProductDto productDto,
    UserDto buyer,
    LocalDateTime orderedAt
) {

    public record ProductDto(
        Long id,
        String name,
        Money price,
        Long quantity,
        UserDto owner,
        LocalDateTime createdAt,
        LocalDateTime expiredAt
    ) {

    }

    public record UserDto(
        Long uuid,
        String name,
        String phoneNumber,
        LocalDateTime lastLogin,
        Money balance
    ) {

    }
}
