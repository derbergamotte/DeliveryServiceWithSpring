package com.ak.controllers;

import com.ak.dto.CategoryDto;
import com.ak.dto.StoreDto;
import com.ak.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/stores")
public class StoresController {

    @Autowired
    StoreService storeService;

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("stores");
        modelAndView.addObject("stores", storeService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("store");
        modelAndView.addObject("store", storeService.getById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSubmit(StoreDto storeDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            storeService.add(storeDto);
            modelAndView.setView(new RedirectView("stores#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("stores#error"));
        }
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateSubmit(StoreDto storeDto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            storeService.update(storeDto);
            modelAndView.setView(new RedirectView("{id}#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("{id}#error"));
        }
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        storeService.remove(id);
        return new ModelAndView(new RedirectView(""));
    }
}
