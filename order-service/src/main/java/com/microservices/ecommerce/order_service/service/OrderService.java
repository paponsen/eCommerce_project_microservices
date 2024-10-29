package com.microservices.ecommerce.order_service.service;

import com.microservices.ecommerce.order_service.client.InventoryClient;
import com.microservices.ecommerce.order_service.dto.InventoryRequest;
import com.microservices.ecommerce.order_service.dto.InventoryResponse;
import com.microservices.ecommerce.order_service.dto.OrderLineItemsDto;
import com.microservices.ecommerce.order_service.dto.OrderRequest;
import com.microservices.ecommerce.order_service.model.Order;
import com.microservices.ecommerce.order_service.model.OrderLineItems;
import com.microservices.ecommerce.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.orderLineItemsDtoList().stream()
                .map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                        .map(orderLineItem -> orderLineItem.getSkuCode()).toList();

        List<InventoryRequest> inventoryRequests=order.getOrderLineItemsList().stream()
                .map(orderLineItem ->  InventoryRequest.builder()
                        .skuCode(orderLineItem.getSkuCode())
                        .quantity(orderLineItem.getQuantity()).build()).toList();

        List<InventoryResponse> inventoryResponses = inventoryClient.isInStock(inventoryRequests);

        //List<InventoryResponse> inventoryResponses = inventoryClient.isInStock(skuCodes);
        for(InventoryResponse response: inventoryResponses){
            System.out.println("Sku code:"+response.skuCode());
            System.out.println("is in stock:"+response.isInStock());

        }
        boolean allProductsInStock = inventoryResponses.stream().
                allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if(allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product is not in stock. Try again later");
        }

        //orderRepository.save(order);
//        boolean isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
//        if(isInStock){
//            Order order = new Order();
//            order.setOrderNumber(UUID.randomUUID().toString());
//            order.setPrice(orderRequest.price());
//            order.setSkuCode(orderRequest.skuCode());
//            order.setQuantity(orderRequest.quantity());
//            orderRepository.save(order);
//        } else {
//            throw new RuntimeException("Product with SkuCode "+orderRequest.skuCode()+" is not in stock");
//        }


    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.price());
        orderLineItems.setSkuCode(orderLineItemsDto.skuCode());
        orderLineItems.setQuantity(orderLineItemsDto.quantity());
        return  orderLineItems;
    }
}
