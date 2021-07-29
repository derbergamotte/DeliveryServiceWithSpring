package com.ak.controllers;

import com.ak.dto.ClientDto;
import com.ak.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<Collection<ClientDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDto> addSubmit(@RequestBody ClientDto clientDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.add(clientDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(clientDto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateSubmit(@RequestBody ClientDto clientDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.update(clientDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(clientDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            clientService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("It was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("It wasn't deleted");
        }
    }
}
