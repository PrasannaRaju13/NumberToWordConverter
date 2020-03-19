package com.codetest.app.util;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import com.codetest.app.exception.InvalidDataException;
import com.codetest.app.exception.NullDataException;

public class ConvertUtilTest {
	
	@Test(expected = NullDataException.class)
	public void shouldHandleNull() throws NullDataException, InvalidDataException {
		ConverterUtil.listToString(null);
	}

	@Test(expected = InvalidDataException.class)
	public void shouldHandleEmptyList() throws NullDataException, InvalidDataException {
		LinkedList<String> parts = new LinkedList<String>();
		ConverterUtil.listToString(parts);
	}

	@Test
	public void shouldConvertListToString_Smalls() throws NullDataException, InvalidDataException {
		LinkedList<String> parts = new LinkedList<String>();
		parts.add("One");
		assertEquals("One", ConverterUtil.listToString(parts));
	}

	@Test
	public void shouldConvertListToString() throws NullDataException, InvalidDataException {
		LinkedList<String> parts = new LinkedList<String>();
		parts.add("Five");
		parts.add("Hundred");
		parts.add("Seventy");
		parts.add("One");
		assertEquals("Five Hundred Seventy One", ConverterUtil.listToString(parts));
	}

}
