package com.codetest.app.service.imp;

import static com.codetest.app.util.Constants.BIGS;
import static com.codetest.app.util.Constants.HUNDRED;
import static com.codetest.app.util.Constants.SMALLS;
import static com.codetest.app.util.Constants.TENS;

import java.util.LinkedList;

import com.codetest.app.exception.InvalidDataException;
import com.codetest.app.exception.NullDataException;
import com.codetest.app.service.NumberToWordConverter;
import com.codetest.app.util.ConverterUtil;

public class NumberToWordConverterServiceImpl implements NumberToWordConverter{

	public String convert(Integer number) throws NullDataException, InvalidDataException {
		
		if(number == null) {
			throw new NullDataException("Number should not be null");
		}
		
		if(number < 0) {
			throw new InvalidDataException("Enter valid number");
		}
		
		if (number == 0) {
			return SMALLS[0];
		}
		
		LinkedList<String> parts = new LinkedList<String>();
		int chunkCount = 0;
		
		while (number > 0) {
			if (number % 1000 != 0) {
				String chunk = convertChunk(number % 1000) + " " + BIGS[chunkCount];
				parts.addFirst(chunk);
			}
			number /= 1000;
			chunkCount++;
		}
		
		return ConverterUtil.listToString(parts);
	}

	private String convertChunk(int number) throws NullDataException, InvalidDataException {
		LinkedList<String> parts = new LinkedList<String>();
		
		if (number >= 100) {
			parts.addLast(SMALLS[number / 100]);
			parts.addLast(HUNDRED);
			number %= 100;
		}
		
		if (number >= 10 && number <= 19) {
			parts.addLast(SMALLS[number]);
		} else if (number >= 20) {
			parts.addLast(TENS[number / 10]);
			number %= 10;
		}
		
		if (number >= 1 && number <= 9) {
			parts.addLast(SMALLS[number]);
		}
		
		return ConverterUtil.listToString(parts);
	}
	
}
