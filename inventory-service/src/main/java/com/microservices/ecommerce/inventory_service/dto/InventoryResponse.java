package com.microservices.ecommerce.inventory_service.dto;

import lombok.*;

@Builder
public record InventoryResponse(String skuCode, boolean isInStock) {
}
