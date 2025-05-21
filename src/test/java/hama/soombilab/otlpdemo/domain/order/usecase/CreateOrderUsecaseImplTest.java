package hama.soombilab.otlpdemo.domain.order.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import hama.soombilab.otlpdemo.domain.order.api.dto.CreatOrderRequest;
import hama.soombilab.otlpdemo.domain.order.usecase.dto.OrderCreatedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@SpringBootTest
class CreateOrderUsecaseImplTest {

    @Autowired
    CreateOrderUsecaseImpl publisher;
    @MockitoSpyBean
    AddOwnerBalance listener;

    @Test
    @DisplayName("이벤트 수신자 예외 발생 시 이벤트 발행자로 예외 전파합니다.")
    void 이벤트수신자예외발생시_이벤트발행자예외전파() {
        // GIVEN
        Long userId = 1L;
        Long productId = 10L;
        long quantity = 1L;
        CreatOrderRequest creatOrderRequest = new CreatOrderRequest(productId, quantity);
        BDDMockito.doThrow(new RuntimeException("boom"))
            .when(listener)
            .addOwnerBalance(BDDMockito.any(OrderCreatedEvent.class));

        // WHEN
        // THEN
        assertThrows(RuntimeException.class,
            () -> publisher.createOrder(userId, creatOrderRequest)
        );
    }
}