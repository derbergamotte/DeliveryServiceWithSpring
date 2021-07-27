package com.ak.controllers;

import com.ak.dto.OrderDto;
import com.ak.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("order", orderService.getById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSubmit(OrderDto orderDto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            orderService.add(orderDto);
            modelAndView.setView(new RedirectView("orders#result"));
        } catch (Exception e) {
            modelAndView.setView(new RedirectView("orders#error"));
        }
        return modelAndView;
    }
}
