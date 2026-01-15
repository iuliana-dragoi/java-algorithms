package com.iuliana.algorithms.strings;

public class ValidateIpAddress {

    static void main() {
        String[] testIPs = {
                "192.168.0.1",
                "255.255.255.255",
                "256.100.0.1",
                "192.168.01.1",
                "abc.def.ghi.jkl",
                "0.0.0.0",
                ""
        };
        // It consists of 4 bytes, separated by .
        // Each byte is a number between 0 and 255
        // It has no unnecessary leading zeros (e.g. 01 is not valid)
        // It does not contain any other characters (letters, symbols)

        for (String ip : testIPs) {
            System.out.println(ip + " : " + (isValid(ip) ? "Valid" : "Invalid"));
        }
    }

    static Boolean isValid(String address) {

        if(!isValidString(address)) return false;

        String[] parts = address.split("\\.");

        for(String part : parts) {
            // Check empty String
            if(!isValidString(part)) return false;

            // Check if Numeric
            if(!isValidNumber(part)) return false;

            int num;
            try {
                num = Integer.parseInt(part);
            }
            catch (NumberFormatException e) {
                return false;
            }

            if(num < 0 || num > 255) return false;

            if(part.length() > 1 && part.charAt(0) == '0') return false;
        }

        return true;
    }

    static Boolean isValidString(String input) {
        if(input == null || input.isBlank()) return false;
        return true;
    }

    static Boolean isValidNumber(String input) {
        for(char c: input.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
