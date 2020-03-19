package com.codetest.app.service;

import com.codetest.app.exception.InvalidDataException;
import com.codetest.app.exception.NullDataException;

public interface NumberToWordConverter {

	public String convert(Integer number) throws NullDataException, InvalidDataException;
}
