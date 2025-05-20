package hama.soombilab.otlpdemo.feature.createOrder.api.dto;

public record CreatOrderRequest(
    Long prdIdx,
    Long quantity
) {

}
