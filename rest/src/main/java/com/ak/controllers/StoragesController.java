package com.ak.controllers;

import com.ak.dto.StorageDto;
import com.ak.interfaces.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/storages")
public class StoragesController {

    @Autowired
    StorageService storageService;

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("storages");
        modelAndView.addObject("storages", storageService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("storage");
        modelAndView.addObject("storage", storageService.getById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSubmit(StorageDto storageDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            storageService.add(storageDto);
            modelAndView.setView(new RedirectView("storages#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("storages#error"));
        }
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateSubmit(StorageDto storageDto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            storageService.update(storageDto);
            modelAndView.setView(new RedirectView("{id}#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("{id}#error"));
        }
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        storageService.remove(id);
        return new ModelAndView(new RedirectView(""));
    }
}
