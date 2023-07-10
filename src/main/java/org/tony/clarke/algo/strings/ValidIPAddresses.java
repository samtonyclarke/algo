package org.tony.clarke.algo.strings;

import java.util.ArrayList;

public class ValidIPAddresses {

    public static void main(String args[]) {
        ValidIPAddresses validIPAddresses = new ValidIPAddresses();
        ArrayList<String> strings = validIPAddresses.validIPAddresses("1921680");
        strings.forEach(System.out::println);
    }

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList toReturn = new ArrayList<String>();
        // need to distribute out the 3 separators
        for (int i = 1; i < string.length() - 2; i++) {
            for (int j = i + 1; j < string.length() - 1; j++) {
                for (int k = j + 1; k < string.length(); k++) {
                    String valid = isValid(string, i, j, k);
                    if (valid != null) {
                        toReturn.add(valid);
                    }
                }
            }
        }

        return toReturn;
    }

    private String isValid(String string, int i, int j, int k) {
        String first = string.substring(0, i);
        if (!isValid(first)) {
            return null;
        }
        String second = string.substring(i, j);
        if (!isValid(second)) {
            return null;
        }
        String third = string.substring(j, k);
        if (!isValid(third)) {
            return null;
        }
        String forth = string.substring(k);
        if (!isValid(forth)) {
            return null;
        }
        return first + "." + second + "." + third + "." + forth;
    }

    private boolean isValid(String s) {
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        return true;
    }

}
