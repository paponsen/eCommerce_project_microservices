package com.microservices.ecommerce.inventory_service.dto;

import lombok.Builder;

@Builder
public record InventoryRequest(String skuCode, Integer quantity) {
}
