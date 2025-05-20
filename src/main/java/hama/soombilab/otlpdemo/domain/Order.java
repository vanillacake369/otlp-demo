package hama.soombilab.otlpdemo.domain;

import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.infra.data.OrderDao;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PROTECTED)
public class Order {

    private Long id;
    private User buyer;
    private Product product;
    private Long quantity;
    private Money finalPrice;
    private LocalDateTime orderedAt;

    public static Order createFrom(User buyer, Product product, Long quantity) {
        Money balance = buyer.getBalance();
        Money finalPrice = Money.getFinalPrice(product.getPrice(), quantity);
        boolean chargeable = balance.isChargeable(finalPrice);
        if (!chargeable){
            throw new RuntimeException("주문상품보다 잔액이 적습니다.");
        }
        return Order.builder()
            .buyer(buyer)
            .product(product)
            .finalPrice(finalPrice)
            .orderedAt(LocalDateTime.now())
            .build();
    }

    public static Order fromDao(OrderDao orderDao) {
        return Order.builder()
            .buyer(User.fromDao(orderDao.getBuyer()))
            .product(Product.fromDao(orderDao.getProduct()))
            .quantity(orderDao.getQuantity())
            .finalPrice(new Money(orderDao.getFinalPrice()))
            .orderedAt(orderDao.getOrderedAt())
            .build();
    }
}
