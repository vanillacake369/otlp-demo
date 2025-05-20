package hama.soombilab.otlpdemo.domain.order.api.dto;

public record CreatOrderRequest(
    Long prdIdx,
    Long quantity
) {

}
