package com.example.nextstep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 받으면 0을 반환 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void paramCheckTest(String param) {

        int result = calculator.add(param);

        assertThat(result, is(0));
    }

    @DisplayName("숫자 하나를 입력 할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource({"'1', 1", "'9', 9"})
    void paramOneTest(String param, int answer) {

        int result = calculator.add(param);

        assertThat(result, is(answer));
    }

    @DisplayName("숫자 여러개를 콤마 구분자로 숫자들의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({"'1,9,5', 15"})
    void twoNumberTest(String param, int answer) {

        int result = calculator.add(param);

        assertThat(result, is(answer));
    }

    @DisplayName("숫자 구분자 \\n으로 사용할 수 있다.")
    @Test
    void multiTest() {
        String param = "1,2\n3";

        int result = calculator.add(param);

        assertThat(result, is(6));
    }

    @Test
    void checkComma() {
        String str = "1,2";

        assertThat(str.contains(","), is(true));
    }

}
