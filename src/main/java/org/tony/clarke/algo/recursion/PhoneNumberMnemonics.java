package org.tony.clarke.algo.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PhoneNumberMnemonics {

    public static void main(String args[]) {
        PhoneNumberMnemonics phoneNumberMnemonics = new PhoneNumberMnemonics();
        ArrayList<String> abc = phoneNumberMnemonics.phoneNumberMnemonics("1905");
        Stream.of(abc).forEach(i -> System.out.println(i));
    }

    private static Map<Character, String> number2char = new HashMap();

    static {
        number2char.put('0', "0");
        number2char.put('1', "1");
        number2char.put('2', "abc");
        number2char.put('3', "def");
        number2char.put('4', "ghi");
        number2char.put('5', "jkl");
        number2char.put('6', "mno");
        number2char.put('7', "pqrs");
        number2char.put('8', "tuv");
        number2char.put('9', "wxyz");
    }

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> solutions = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return solutions;
        }
        search(solutions, phoneNumber, 0, new StringBuilder());
        return solutions;
    }

    private void search(ArrayList<String> solutions, String phoneNumber, int i, StringBuilder built) {
        if( i == phoneNumber.length()) {
            solutions.add(built.toString());
            return;
        }
        char c = phoneNumber.charAt(i);
        String mapped2 = number2char.get(c);
        for (char next : mapped2.toCharArray()) {
            built.append(next);
            search(solutions, phoneNumber, i+1, built);
            built.deleteCharAt(built.length() - 1);
        }
    }

}
