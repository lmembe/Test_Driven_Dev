package com.interviewexercise.phonenumberparser.utilities.interfaces;

public interface NumberParserInterface {

    static String REGEX_USA = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    static String PHONE_REGEX = "(?:(?:(?:\\+|00)44[\\s\\-\\.]?)?(?:(?:\\(?0\\)?)[\\s\\-\\.]?)?(?:\\d[\\s\\-\\.]?){10})|(?=" +
            "\\(?\\d*\\)?[\\x20\\-\\d]*)(\\(?\\)?\\x20*\\-*\\d){11}";

    // used to check if phone number has any special characters other than +
    static  String SPECIAL_CHARS =
            "/^(?:(?:\\(?(?:00|\\+)([1-4]\\d\\d|[1-9]\\d?)\\)?)?[\\-\\.\\ \\\\\\/]?)?((?:\\(?\\d{1,}\\)?[\\-\\.\\ \\\\\\" +
            "/]?){0,})(?:[\\-\\.\\ \\\\\\/]?(?:#|ext\\.?|extension|x)[\\-\\.\\ \\\\\\/]?(\\d+))?$/i";

            // "[!@#$%&*()_=|<>?{}\\[\\]~-]";

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
