package com.interviewexercise.phonenumberparser;

import com.interviewexercise.phonenumberparser.utilities.NumberParser;
import com.interviewexercise.phonenumberparser.utilities.interfaces.NumberParserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PhoneNumberParserApplicationTests {

    NumberParserInterface numberParser;
    Map<String, Integer> countryCodes = null;
    Map<String, String> prefixes = null;

    @BeforeEach
    void setUp() {
        countryCodes = new HashMap<>();
        prefixes = new HashMap<>();
        countryCodes.put("GB", 44); prefixes.put("GB", "0");
        countryCodes.put("USA", 1); prefixes.put("USA", "1");
        numberParser = new NumberParser(countryCodes, prefixes);
    }

    @ParameterizedTest
    @CsvSource({"02079460056,+442079460056,+442079460056",
            "+13325550123,02079460056,+13325550123",
            "3325550123,+13325550123,+13325550123",
            "02071345678,07971475344, +442071345678"})
      void testParseDialledNumberFromFormat(String dialledNo, String userNo, String expectedNo) {

        assertEquals(expectedNo, numberParser.parse(dialledNo, userNo));
    }

    @ParameterizedTest
    @CsvSource({"=2079460056,=442079460056,Invalid Number",
            "+135550123,429460056,Invalid Number",
            "35550123,+135550123,Invalid Number",
            "2071345678,071475344, Invalid Number",
            "02071345678,071475344, Invalid Number"})
    void testParseDialledInvalidNumberFormat(String dialledNo, String userNo, String expectedNo) {

        assertEquals(expectedNo, numberParser.parse(dialledNo, userNo));
    }

}
