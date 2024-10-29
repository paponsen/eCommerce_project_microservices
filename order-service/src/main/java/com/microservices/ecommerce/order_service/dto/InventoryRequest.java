package com.microservices.ecommerce.order_service.dto;

import lombok.Builder;

@Builder
public record InventoryRequest(String skuCode, Integer quantity) {
}
