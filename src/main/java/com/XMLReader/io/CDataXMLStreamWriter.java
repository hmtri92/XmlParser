package com.XMLReader.io;

import java.util.regex.Pattern;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

public class CDataXMLStreamWriter extends DelegatingXMLStreamWriter {

	private static final Pattern XML_CHARS = Pattern.compile("[&<>]");

	protected CDataXMLStreamWriter(XMLStreamWriter out) {
		super(out);
	}

	@Override
	public void writeCharacters(String text) throws XMLStreamException {
		boolean useCData = XML_CHARS.matcher(text).find();
		if (useCData) {
			super.writeCData(text);
		} else {
			super.writeCharacters(text);
		}
	}

}
