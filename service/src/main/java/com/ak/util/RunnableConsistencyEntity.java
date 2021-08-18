package com.ak.util;

import com.ak.dto.BaseDto;
import com.ak.util.filemanager.ConfigFileManager;
import com.ak.util.filemanager.DtoJsonFileManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnableConsistencyEntity implements Runnable {

    private final ApplicationContext context = new AnnotationConfigApplicationContext(ConfigFileManager.class);
    private final DtoJsonFileManager fileManager = context.getBean(DtoJsonFileManager.class);
    private final BaseDto dto;

    public RunnableConsistencyEntity(BaseDto dto) {
        this.dto = dto;
    }

    public void run() {
        BaseDto dtoFromFile;
        dtoFromFile = fileManager.get(dto);
        if (dtoFromFile == null || dto.equals(dtoFromFile)) {
            fileManager.save(dto);
        }
    }
}
