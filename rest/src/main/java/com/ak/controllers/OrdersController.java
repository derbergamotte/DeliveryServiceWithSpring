package com.ak.controllers;

import com.ak.dto.OrderDto;
import com.ak.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Collection<OrderDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> add(@RequestBody OrderDto orderDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(orderService.add(orderDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body(orderDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            orderService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It wasn't deleted");
        }
    }
}
