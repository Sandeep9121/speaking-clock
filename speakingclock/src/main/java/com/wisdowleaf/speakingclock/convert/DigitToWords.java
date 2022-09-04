package com.wisdowleaf.speakingclock.convert;

import java.util.stream.Stream;
/*
 * @author Sandeep
 */

public enum DigitToWords {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(12),
	THIRTEEN(13), FOURTEEN(14), FIFTEEN(15), SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINETEEN(19),
	TWENTY(20), THIRTY(30), FOURTY(40), FIFTY(50);

	final int number;

	DigitToWords(int number) {
		this.number = number;
	}

	public static Stream<DigitToWords> stream() {
		return Stream.of(DigitToWords.values());
	}

}
