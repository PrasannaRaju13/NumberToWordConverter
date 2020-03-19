package com.codetest.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.codetest.app.exception.InvalidDataException;
import com.codetest.app.exception.NullDataException;
import com.codetest.app.service.NumberToWordConverter;
import com.codetest.app.service.imp.NumberToWordConverterServiceImpl;

public class NumberToWordConverterServiceImplTest {

	private NumberToWordConverter numberToWordConverter;

	@Before
	public void init() {
		numberToWordConverter = new NumberToWordConverterServiceImpl();
	}

	@Test(expected = NullDataException.class)
	public void shouldHandleNull() throws NullDataException, InvalidDataException {
		numberToWordConverter.convert(null);
	}

	@Test(expected = InvalidDataException.class)
	public void shouldHandleNegativeNumbers() throws NullDataException, InvalidDataException {
		numberToWordConverter.convert(-1);
	}

	@Test
	public void shouldHandle() throws NullDataException, InvalidDataException {
		assertEquals("Fifteen", numberToWordConverter.convert(15));
	}

	@Test
	public void shouldHandleZero() throws NullDataException, InvalidDataException {
		assertEquals("Zero", numberToWordConverter.convert(0));
	}

	@Test
	public void shouldHandleSmallNumberToWord() throws NullDataException, InvalidDataException {
		assertEquals("Five", numberToWordConverter.convert(5));
	}

	@Test
	public void shouldHandleTwoDigitNumberToWord() throws NullDataException, InvalidDataException {
		assertEquals("Fifty Eight", numberToWordConverter.convert(58));
	}

	@Test
	public void shouldHandleThreeDigitNumberToWord() throws NullDataException, InvalidDataException {
		assertEquals("Nine Hundred Fifty Seven", numberToWordConverter.convert(957));
	}

	@Test
	public void shouldHandleThreeDigitNumberToWordThousand() throws NullDataException, InvalidDataException {
		assertEquals("One Thousand", numberToWordConverter.convert(1000));
	}

	@Test
	public void shouldHandle_40003_NumberToWordTenThousand() throws NullDataException, InvalidDataException {
		assertEquals("Forty Thousand Three", numberToWordConverter.convert(40003));
	}

	@Test
	public void shouldHandle_24646_NumberToWordTenThousands() throws NullDataException, InvalidDataException {
		assertEquals("Twenty Four Thousand Six Hundred Forty Six", numberToWordConverter.convert(24646));
	}

	@Test
	public void shouldHandle_98834_NumberToWordTenThousands() throws NullDataException, InvalidDataException {
		assertEquals("Ninety Eight Thousand Eight Hundred Thirty Four", numberToWordConverter.convert(98834));
	}

	@Test
	public void shouldHandle_44838098_NumberToWordMillion() throws NullDataException, InvalidDataException {
		assertEquals("Forty Four Million Eight Hundred Thirty Eight Thousand Ninety Eight",
				numberToWordConverter.convert(44838098));
	}

	@Test
	public void shouldHandle_76301064_NumberToWordSeventySixMillion() throws NullDataException, InvalidDataException {
		assertEquals("Seventy Six Million Three Hundred One Thousand Sixty Four",
				numberToWordConverter.convert(76301064));
	}

	@Test
	public void shouldHandle_91660820_NumberToWordNinetyOneMillion() throws NullDataException, InvalidDataException {
		assertEquals("Ninety One Million Six Hundred Sixty Thousand Eight Hundred Twenty",
				numberToWordConverter.convert(91660820));
	}

}
