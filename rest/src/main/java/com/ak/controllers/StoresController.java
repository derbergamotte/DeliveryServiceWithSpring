package com.ak.controllers;

import com.ak.dto.CategoryDto;
import com.ak.dto.StoreDto;
import com.ak.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@Controller
@RequestMapping("/stores")
public class StoresController {

    @Autowired
    StoreService storeService;

    @GetMapping
    public ResponseEntity<Collection<StoreDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<StoreDto> addSubmit(StoreDto storeDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(storeService.add(storeDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(storeDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDto> updateSubmit(StoreDto storeDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(storeService.update(storeDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(storeDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            storeService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("It wasn't deleted");
        }
    }
}
