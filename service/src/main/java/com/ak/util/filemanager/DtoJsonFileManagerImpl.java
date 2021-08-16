package com.ak.util.filemanager;

import com.ak.dto.BaseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DtoJsonFileManagerImpl implements DtoJsonFileManager{

    private String basePath;
    private String fileName;

    {
        File file = new File("service/src/main/resources/config.properties");
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(file));
            basePath = property.getProperty("path");
            fileName = property.getProperty("fileName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(BaseDto dto){
        File file = getFile(dto.getId(), true);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BaseDto get(BaseDto dto) {
        File file = getFile(dto.getId(), false);
        ObjectMapper mapper = new ObjectMapper();
        BaseDto dtoFromFile = null;
        try {
            dtoFromFile = mapper.readValue(file, dto.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dtoFromFile;
    }

    private File getFile(Long id, boolean whetherToCreateFolders ){
        String path = basePath + id.toString();
        if (whetherToCreateFolders) {
            directoryControl(path);
        }
        return new File(path + fileName);
    }

    private void directoryControl(String stringPath) {
        Path path = Paths.get(stringPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
