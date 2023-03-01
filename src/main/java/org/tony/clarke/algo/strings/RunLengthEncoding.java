package org.tony.clarke.algo.strings;

public class RunLengthEncoding {

    public static void main(String args[]) {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        String encoding = runLengthEncoding.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD");
        System.out.println(encoding);
    }

    public String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder();
        char[] chars = string.toCharArray();
        int counter = 1;
        boolean lastIncluded = false;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                counter++;
                if (i == chars.length - 2) {
                    lastIncluded = true;
                    appendNow(sb, chars[i], counter);
                }
            } else {
                appendNow(sb, chars[i], counter);
                counter = 1;
            }
        }
        if (!lastIncluded) {
            sb.append(1);
            sb.append(chars[string.length() - 1]);
        }
        return sb.toString();
    }

    private void appendNow(StringBuilder sb, char c, int count) {
        int times = count / 9;
        int remainder = count % 9;

        for (int i = 0; i < times; i++) {
            sb.append(9);
            sb.append(c);
        }
        if (remainder != 0) {
            sb.append(remainder);
            sb.append(c);
        }

    }

}
