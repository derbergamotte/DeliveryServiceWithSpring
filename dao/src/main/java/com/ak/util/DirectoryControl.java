package com.ak.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DirectoryControl {

    private static String path;
    private static String autoincrement;
    private static String startId;

    private DirectoryControl() {
    }

    static {
        File file = new File("dao/src/main/resources/config.properties");
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(file));
            path = property.getProperty("db.path");
            autoincrement = property.getProperty("db.autoincrement");
            startId = property.getProperty("db.startId");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPath(String className) {
        String stringPath = path + className + File.separator;
        directoryControl(stringPath);
        return stringPath;
    }

    private static void directoryControl(String stringPath) {
        Path path = Paths.get(stringPath);
        BufferedWriter writer = null;
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                writer = Files.newBufferedWriter(Paths.get(stringPath + autoincrement), StandardCharsets.UTF_8);
                writer.write(startId);
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                try {
                    assert writer != null;
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
