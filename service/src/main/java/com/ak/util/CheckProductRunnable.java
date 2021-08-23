package com.ak.util;

import com.ak.dto.BaseDto;
import com.ak.dto.ProductDto;
import com.ak.interfaces.ProductService;
import com.ak.util.filemanager.ConfigFileManager;
import com.ak.util.filemanager.DtoJsonFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CheckProductRunnable implements Runnable {

    private final ApplicationContext context = new AnnotationConfigApplicationContext(ConfigFileManager.class);
    private final DtoJsonFileManager fileManager = context.getBean(DtoJsonFileManager.class);
    private final BaseDto dto;
    @Autowired
    ProductService productService;

    public CheckProductRunnable(BaseDto dto) {
        this.dto = dto;
    }

    public void run() {
        ProductDto dtoFromFile = (ProductDto) fileManager.get(dto);
        if (!dto.equals(dtoFromFile)) {
            productService.update(dtoFromFile.getId(), dtoFromFile);
        }
    }
}
