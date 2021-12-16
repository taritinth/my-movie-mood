package com.sop.chapter7.productservice.command.rest;

import org.springframework.web.bind.annotation.*;
import com.sop.chapter7.productservice.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
@RestController
@RequestMapping("/products")

public class ProductCommandController {

    private final CommandGateway commandGateway;

    @Autowired
    public ProductCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel model){
//        CreateProductCommand command = CreateProductCommand.builder()
//                .productId(UUID.randomUUID().toString())
//                .title(model.getTitle())
//                .price(model.getPrice())
//                .quantity(model.getQuantity())
//                .build();
//        String result;
//        try{
//            result = commandGateway.sendAndWait(command);
//        } catch (Exception e){
//            result = e.getLocalizedMessage();
//        }
//        return result;
        return "bla";
//        return "product created: " + model.getTitle();
    }

    @DeleteMapping
    public String deleteProduct(){
        return "product deleted";
    }
}
