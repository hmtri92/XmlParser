package com.XMLReader.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	List<File> lstFileName = new ArrayList<File>();
	public List<File> getXMLFiles(String folderPath) {
		File file = new File(folderPath);
		File[] files = file.listFiles();
		
		for (File item : files) {
			if (item.isDirectory()) {
				getXMLFiles(item.getAbsolutePath());
			} else {
				if (item.getName().endsWith(".hbm.xml")) {
					continue;
				} else if (item.getName().endsWith(".xml")) {
					lstFileName.add(item);
				}
			}
		}
		
		return lstFileName;
	}

}
