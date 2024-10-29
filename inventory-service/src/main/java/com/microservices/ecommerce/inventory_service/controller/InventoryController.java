package com.microservices.ecommerce.inventory_service.controller;

import com.microservices.ecommerce.inventory_service.dto.InventoryRequest;
import com.microservices.ecommerce.inventory_service.dto.InventoryResponse;
import com.microservices.ecommerce.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
//        return  inventoryService.isInStock(skuCode, quantity);
//    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
//        System.out.println("Inventory Service :::: sku code:"+skuCode.toString());
//        return inventoryService.isInStock(skuCode);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestBody List<InventoryRequest> inventoryRequests){
        //do code
        return inventoryService.isInStock(inventoryRequests);
    }
}
