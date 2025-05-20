package hama.soombilab.otlpdemo.infra.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Comment("고객 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdIdx;

    @Column
    private String name;

    @Column
    private Long quantity;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime expiredAt;
}
