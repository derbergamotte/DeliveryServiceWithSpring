package com.ak.controllers;

import com.ak.dto.CategoryDto;
import com.ak.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categories", categoryService.getAll());
        modelAndView.addObject("newcategory", new CategoryDto());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("category", categoryService.getById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSubmit(CategoryDto categoryDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            categoryService.add(categoryDto);
            modelAndView.setView(new RedirectView("categories#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("categories#error"));
        }
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateSubmit(CategoryDto categoryDto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            categoryService.update(categoryDto);
            modelAndView.setView(new RedirectView("{id}#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("{id}#error"));
        }
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        categoryService.remove(id);
        return new ModelAndView(new RedirectView(""));
    }
}
