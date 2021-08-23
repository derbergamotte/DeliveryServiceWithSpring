package com.ak.util;

import com.ak.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConsistencyProduct {

    @Autowired
    private ProductService productService;

    @Scheduled(cron = "* */10 * * * *")
    public void consistencyProduct(){
        productService.getAll().forEach(p -> {
            CheckProductRunnable runnable = new CheckProductRunnable(p);
            new Thread(runnable).start();
        });
    }
}
