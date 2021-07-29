package com.ak.controllers;

import com.ak.dto.OrderDto;
import com.ak.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<Collection<OrderDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> addSubmit(@RequestBody OrderDto orderDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderService.add(orderDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(orderDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            orderService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("It wasn't deleted");
        }
    }
}
