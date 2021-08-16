package com.ak.controllers;

import com.ak.dto.StoreDto;
import com.ak.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/stores")
public class StoresController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<Collection<StoreDto>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(storeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(storeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<StoreDto> add(@RequestBody StoreDto storeDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(storeService.add(storeDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body(storeDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDto> update(@PathVariable Long id, @RequestBody StoreDto storeDto){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(storeService.update(id, storeDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body(storeDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            storeService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It wasn't deleted");
        }
    }
}
