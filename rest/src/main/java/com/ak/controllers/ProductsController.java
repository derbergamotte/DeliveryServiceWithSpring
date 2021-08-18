package com.ak.controllers;

import com.ak.dto.ProductDto;
import com.ak.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Collection<ProductDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> add(@RequestBody ProductDto productDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(productService.add(productDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(productDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(productService.update(id, productDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body(productDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            productService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It wasn't deleted");
        }
    }

    @GetMapping("/byAttributes")
    public ResponseEntity<Collection<ProductDto>> getByAttributes(@RequestParam Collection<Long> values) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(productService.getByAttributes(values));
    }

    @GetMapping("/byCategories")
    public ResponseEntity<Collection<ProductDto>> getByCategories(@RequestParam Collection<Long> values) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(productService.getByCategories(values));
    }
}
