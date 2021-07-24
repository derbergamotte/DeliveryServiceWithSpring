package com.ak.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerateId {
	
	private GenerateId() {
	}

	public static Long getId(String directoryPath) {
		String filePath = directoryPath + "autoincrement";
		BufferedWriter bufferedWriter = null;
		Long autoincrement = null;
		try {
			autoincrement = getAutoincrement(filePath) + 1;
			bufferedWriter = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8);
			bufferedWriter.write(autoincrement.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				assert bufferedWriter != null;
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return autoincrement;
	}

	private static Long getAutoincrement(String filePath) throws IOException {
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Long autoincrement = Long.valueOf(bufferedReader.readLine());
		bufferedReader.close();
		fileReader.close();
		return autoincrement;
	}
}
