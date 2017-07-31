package com.XMLReader.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	public List<String> getXMLFiles(String folderPath) {
		File file = new File(folderPath);
		File[] files = file.listFiles(
				(dir, name) -> {
					return name.toLowerCase().endsWith(".xml");
				});
		
		List<String> lstFileName = new ArrayList<String>();
		for (File item : files) {
			lstFileName.add(item.getAbsolutePath());
		}
		
		return lstFileName;
	}

}
