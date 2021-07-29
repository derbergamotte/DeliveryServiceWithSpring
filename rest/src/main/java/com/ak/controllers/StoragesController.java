package com.ak.controllers;

import com.ak.dto.StorageDto;
import com.ak.interfaces.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/storages")
public class StoragesController {

    @Autowired
    StorageService storageService;

    @GetMapping
    public ResponseEntity<Collection<StorageDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageDto> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.getById(id));
    }

    @PostMapping
    public ResponseEntity<StorageDto> addSubmit(StorageDto storageDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(storageService.add(storageDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(storageDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StorageDto> updateSubmit(StorageDto storageDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(storageService.update(storageDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(storageDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            storageService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("It wasn't deleted");
        }
    }
}
