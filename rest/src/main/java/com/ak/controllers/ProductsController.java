package com.ak.controllers;

import com.ak.dto.ProductDto;
import com.ak.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("product", productService.getById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSubmit(ProductDto productDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            productService.add(productDto);
            modelAndView.setView(new RedirectView("products#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("products#error"));
        }
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateSubmit(ProductDto productDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            productService.update(productDto);
            modelAndView.setView(new RedirectView("{id}#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("{id}#error"));
        }
        return modelAndView;
    }


    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        productService.remove(id);
        return new ModelAndView(new RedirectView(""));
    }
}
