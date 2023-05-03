package com.not.monopoly.Objects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

public class FileManager {
	private File file;

	public FileManager(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(String path) {
		this.file = new File(path);
	}

	public List<String> readData() throws IOException {
		return Files.readAllLines(file.toPath());
	}

	public List<Integer> readNumData() throws IOException {
		List<Integer> returnData = new ArrayList<>();
		List<String> temp = Files.readAllLines(file.toPath());
		for (String data : temp) {
			returnData.add(Integer.parseInt(data));
		}
		return returnData;
	}

	public void writeData(File file, String data) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(data);
		writer.close();
	}
}