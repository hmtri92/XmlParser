package com.XMLReader.io;

import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class Reader {
	
	FileReader fr = null;
	
	public FileReader read(String fileName) {
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fr;
	}

}
