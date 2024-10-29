package com.microservices.ecommerce.order_service.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(List<OrderLineItemsDto> orderLineItemsDtoList) {
}
