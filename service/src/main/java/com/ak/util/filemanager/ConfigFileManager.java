package com.ak.util.filemanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFileManager {

    @Bean DtoJsonFileManager dtoJsonFileManager(){
        return new DtoJsonFileManagerImpl();
    }
}
