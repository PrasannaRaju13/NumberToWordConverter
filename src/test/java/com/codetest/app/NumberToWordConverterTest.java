package com.codetest.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumberToWordConverterTest {

	public int number;
	public String convertedWord;

	public NumberToWordConverterTest(int number, String convertedWord) {
		this.number = number;
		this.convertedWord = convertedWord;
	}

	@Parameters(name = "{index}: numberToWord({0}) = {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{-1, "Negative One"},
			{-10, "Negative Ten"},
			{-1000000,"Negative One Million"},
			{ 58, "Fifty Eight" }, 
			{89,"Eighty Nine"},
			{ 73, "Seventy Three" },
			{957,"Nine Hundred Fifty Seven"},
			{274,"Two Hundred Seventy Four"},
			{571,"Five Hundred Seventy One"},
			{40003,"Forty Thousand Three"},
			{24646,"Twenty Four Thousand Six Hundred Forty Six"},
			{98834,"Ninety Eight Thousand Eight Hundred Thirty Four"},
			{44838098,"Forty Four Million Eight Hundred Thirty Eight Thousand Ninety Eight"},
			{76301064,"Seventy Six Million Three Hundred One Thousand Sixty Four"},
			{91660820,"Ninety One Million Six Hundred Sixty Thousand Eight Hundred Twenty"},
		});
	}

	@Test
    public void test_NumberToWord() {
        assertEquals(convertedWord , NumberToWordConverter.convert(number));
    }
}
