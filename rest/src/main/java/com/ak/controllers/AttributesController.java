package com.ak.controllers;

import com.ak.dto.AttributeDto;
import com.ak.interfaces.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/attributes")
public class AttributesController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping
    public ResponseEntity<Collection<AttributeDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(attributeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeDto> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(attributeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AttributeDto> add(@RequestBody AttributeDto attributeDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(attributeService.add(attributeDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body(attributeDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeDto> update(@RequestBody AttributeDto attributeDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(attributeService.update(attributeDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body(attributeDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            attributeService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It wasn't deleted");
        }
    }
}
