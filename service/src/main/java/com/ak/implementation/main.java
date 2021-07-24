package com.ak.implementation;

import com.ak.dto.CategoryDto;
import com.ak.dto.ClientDto;
import com.ak.interfaces.ClientService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClientService clientService = context.getBean("clientServiceImpl", ClientServiceImpl.class);
        clientService.add(new ClientDto());
        context.getBean("categoryServiceImpl", CategoryServiceImpl.class).add(new CategoryDto());
    }
}


