package hama.soombilab.otlpdemo.domain.order.api;

import hama.soombilab.otlpdemo.domain.order.api.dto.CreatOrderRequest;
import hama.soombilab.otlpdemo.domain.order.api.dto.CreateOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateOrderEndpoint {

    private final CreateOrderUsecase createOrderUsecase;

    @PostMapping("/order")
    public ResponseEntity<CreateOrderResponse> createOrder(
        @RequestBody CreatOrderRequest creatOrderRequest
    ) {
        // Authentication 에서 userIdx 가져왔다고 가정
        Long userIdx = 3L;
        return ResponseEntity.ok(createOrderUsecase.createOrder(userIdx,creatOrderRequest));
    }
}
