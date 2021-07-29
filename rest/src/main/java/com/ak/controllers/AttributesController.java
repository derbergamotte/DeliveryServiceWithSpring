package com.ak.controllers;

import com.ak.dto.AttributeDto;
import com.ak.interfaces.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/attributes")
public class AttributesController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping
    public ResponseEntity<Collection<AttributeDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(attributeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeDto> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(attributeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AttributeDto> addSubmit(@RequestBody AttributeDto attributeDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(attributeService.add(attributeDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(attributeDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeDto> updateSubmit(@RequestBody AttributeDto attributeDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(attributeService.update(attributeDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(attributeDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            attributeService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("It wasn't deleted");
        }
    }
}
