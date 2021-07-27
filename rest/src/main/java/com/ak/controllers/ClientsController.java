package com.ak.controllers;

import com.ak.dto.ClientDto;
import com.ak.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ModelAndView getAll(){
    ModelAndView modelAndView = new ModelAndView("clients");
    modelAndView.addObject("clients", clientService.getAll());
    return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("client", clientService.getById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSubmit(ClientDto clientDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            clientService.add(clientDto);
            modelAndView.setView(new RedirectView("clients#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("clients#error"));
        }
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateSubmit(ClientDto clientDto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            clientService.update(clientDto);
            modelAndView.setView(new RedirectView("{id}#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("{id}#error"));
        }
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        clientService.remove(id);
        return new ModelAndView(new RedirectView(""));
    }
}
