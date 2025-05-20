package hama.soombilab.otlpdemo.domain.product.model;

import hama.soombilab.otlpdemo.domain.user.model.User;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.domain.product.infra.data.ProductDao;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PROTECTED)
public class Product {

    private Long id;
    private String name;
    private Money price;
    private Long quantity;
    private User owner;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    public static Product fromDao(ProductDao productDao) {
        return Product.builder()
            .id(productDao.getPrdIdx())
            .name(productDao.getName())
            .price(new Money(productDao.getPrice()))
            .quantity(productDao.getQuantity())
            .owner(User.fromDao(productDao.getOwner()))
            .createdAt(productDao.getCreatedAt())
            .expiredAt(productDao.getExpiredAt())
            .build();
    }
}
