package com.microservices.ecommerce.order_service.client;

import com.microservices.ecommerce.order_service.dto.InventoryRequest;
import com.microservices.ecommerce.order_service.dto.InventoryResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Spring and OpenFeign client will automatically have the necessary implementation
 * to call the inventory service using the get method.
 * This is similar to Spring data jpa
 */
//@FeignClient(value = "inventory", url = "${inventory.url}")
@FeignClient(name = "inventory-service")
public interface InventoryClient {
    //Need to define what kind of method this HTTP client is going to call
    //@RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    //boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
    //List<InventoryResponse> isInStock(@RequestParam List<String> skuCode);

    @RequestMapping(method = RequestMethod.POST, value="/api/inventory")
    @LoadBalanced
    List<InventoryResponse> isInStock(@RequestBody List<InventoryRequest> inventoryRequests);
}
