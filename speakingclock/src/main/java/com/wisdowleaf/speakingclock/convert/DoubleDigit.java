package com.wisdowleaf.speakingclock.convert;

import java.util.stream.Stream;
/*
 * @author Sandeep
 */
public enum DoubleDigit {
	TWENTY(20), THIRTY(30), FOURTY(40), FIFTY(50);

	final int number;

	DoubleDigit(int number) {
		this.number = number;
	}

	public static Stream<DoubleDigit> stream() {
		return Stream.of(DoubleDigit.values());
	}

}
