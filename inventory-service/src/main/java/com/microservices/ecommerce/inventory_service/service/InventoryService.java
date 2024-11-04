package com.microservices.ecommerce.inventory_service.service;

import com.microservices.ecommerce.inventory_service.dto.InventoryRequest;
import com.microservices.ecommerce.inventory_service.dto.InventoryResponse;
import com.microservices.ecommerce.inventory_service.model.Inventory;
import com.microservices.ecommerce.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity){
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

//    public List<InventoryResponse> isInStock(List<String> skuCode){
//        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
//                .map(inventory ->
//                        InventoryResponse.builder()
//                                .skuCode(inventory.getSkuCode())
//                                .isInStock(inventory.getQuantity() > 0).build()
//                ).toList();
//    }

    public List<InventoryResponse> isInStock(List<InventoryRequest> inventoryRequests){
        System.out.println("check");
        Map<String, Integer> inventoryMap = inventoryRequests.stream()
                .collect(Collectors.toMap(inventoryRequest -> inventoryRequest.skuCode(),
                        inventoryRequest -> inventoryRequest.quantity()));

        List<String> skuCodes = inventoryRequests.stream()
                .map(inventoryRequest -> inventoryRequest.skuCode()).toList();

                return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > inventoryMap.get(inventory.getSkuCode())).build()
                ).toList();

    }


}
