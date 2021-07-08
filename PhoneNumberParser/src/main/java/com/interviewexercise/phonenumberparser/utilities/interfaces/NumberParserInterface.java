package com.interviewexercise.phonenumberparser.utilities.interfaces;

public interface NumberParserInterface {

    static String PHONE_REGEX = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";

    String parse(String dialledNumber, String userNumber);

    enum PREFIXES {

        GB("0"), USA("1");

        private String prefixes;

        public String getPrefixes()
        {
            return this.prefixes;
        }

        private PREFIXES(String prefixes)
        {
            this.prefixes = prefixes;
        }
    }

    enum  COUNTRY {

        GB("44"), USA("1");

        private String country;

        public String getCountry()
        {
            return this.country;
        }

        private COUNTRY(String country)
        {
            this.country = country;
        }
    }
}
