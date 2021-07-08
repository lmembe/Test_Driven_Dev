package com.interviewexercise.phonenumberparser.utilities;

import com.interviewexercise.phonenumberparser.utilities.interfaces.NumberParserInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser implements NumberParserInterface {

    private final char plusSign = '+';
    private  Map countryCodes = null;
    private Map prefixes = null;

    public NumberParser(Map<String, Integer> countryCodes, Map<String, String> prefixes) {
        this.countryCodes = new HashMap();
        this.countryCodes = countryCodes;
        this.prefixes = new HashMap();
        this.prefixes = prefixes;
    }

    @Override
    public String parse(String dialledNumber, String userNumber) {

        String result = "Invalid Number";
        //UK compare phoneNumber without dialling code
        int dialledNumberLen = dialledNumber.length();
        int userNumberLen = userNumber.length();
        Pattern pattern = Pattern.compile(NumberParserInterface.REGEX_USA);
        Matcher matcher = pattern.matcher(dialledNumber);

        if (matcher.matches() && !dialledNumber.contains("=")) {
            if ((dialledNumberLen >= 10 && userNumberLen >= 10)) {
                if (dialledNumber.charAt(0) == plusSign) {
                    result = dialledNumber;
                } else {

                    if (dialledNumber.substring(0, 1).equals(prefixes.get(COUNTRY.GB.toString()))) {
                        result = String.valueOf(plusSign) + countryCodes.get(COUNTRY.GB.toString()) + dialledNumber.replaceFirst("^0+(?!$)", "");
                    } else if (dialledNumber.substring(0, 1).equals(prefixes.get(COUNTRY.USA.toString()))) {
                        result = String.valueOf(plusSign) + countryCodes.get(COUNTRY.USA.toString()) + dialledNumber.replaceFirst("^0+(?!$)", "");
                    } else {
                        result = String.valueOf(plusSign) + countryCodes.get(COUNTRY.USA.toString()) + dialledNumber.replaceFirst("^0+(?!$)", "");
                    }

                }
            }
        }
        return result;
    }
}
