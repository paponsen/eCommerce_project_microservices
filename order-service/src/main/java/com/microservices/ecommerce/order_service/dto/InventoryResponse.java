package com.microservices.ecommerce.order_service.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public record InventoryResponse(String skuCode, boolean isInStock) {
}
