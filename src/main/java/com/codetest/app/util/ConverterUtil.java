package com.codetest.app.util;

import java.util.LinkedList;

import com.codetest.app.exception.InvalidDataException;
import com.codetest.app.exception.NullDataException;

public class ConverterUtil {

	public static String listToString(LinkedList<String> parts) throws NullDataException, InvalidDataException {
		
		if( parts == null ) {
			throw new NullDataException("List should not be null");
		}
		
		if(parts.isEmpty()) {
			throw new InvalidDataException("List should not be empty");
		}
		
		StringBuilder sb = new StringBuilder();
		while (parts.size() > 1) {
			sb.append(parts.pop());
			sb.append(" ");
		}
		sb.append(parts.pop());
		return sb.toString().trim();
	}
	
}
