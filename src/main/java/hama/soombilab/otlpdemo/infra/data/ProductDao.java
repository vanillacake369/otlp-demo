package hama.soombilab.otlpdemo.infra.data;

import hama.soombilab.otlpdemo.domain.Product;
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
import org.hibernate.annotations.Comment;
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
public class ProductDao {

    @Id
    @Comment("상품 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid", nullable = false)
    private UserDao owner;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Long quantity;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime expiredAt;

    public static ProductDao fromDomain(Product product) {
        return ProductDao.builder()
            .prdIdx(product.getId())
            .owner(UserDao.fromDomain(product.getOwner()))
            .name(product.getName())
            .price(product.getPrice().amount())
            .quantity(product.getQuantity())
            .createdAt(product.getCreatedAt())
            .expiredAt(product.getExpiredAt())
            .build();
    }
}
