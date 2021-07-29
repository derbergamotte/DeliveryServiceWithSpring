package com.ak.controllers;

import com.ak.dto.CategoryDto;
import com.ak.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Collection<CategoryDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> addSubmit(@RequestBody CategoryDto categoryDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.add(categoryDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(categoryDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateSubmit(@RequestBody CategoryDto categoryDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(categoryDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(categoryDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            categoryService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("It wasn't deleted");
        }
    }
}
