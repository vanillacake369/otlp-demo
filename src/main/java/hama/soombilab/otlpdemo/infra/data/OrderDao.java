package hama.soombilab.otlpdemo.infra.data;

import hama.soombilab.otlpdemo.domain.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table
@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid", nullable = false)
    private UserDao buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prd_idx", nullable = false)
    private ProductDao product;

    @Column
    private Long quantity;

    @Column
    private BigDecimal finalPrice;

    @Column
    private LocalDateTime orderedAt;

    public static OrderDao fromDomain(UserDao buyerDao, ProductDao productDao, Order order) {
        return OrderDao.builder()
            .buyer(buyerDao)
            .product(productDao)
            .quantity(order.getQuantity())
            .finalPrice(order.getFinalPrice().amount())
            .orderedAt(order.getOrderedAt())
            .build();
    }
}
