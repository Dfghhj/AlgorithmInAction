package top.dfghhj.leetCode.string;

/**
 * 67. 二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        int alength = achars.length;
        int blength = bchars.length;

        StringBuilder result = new StringBuilder();

        int resultLength = alength > blength ? alength : blength;

        char addNumber = '0';

        for (int i = 1; i <= resultLength+1; i++) {
            char achar = alength-i > -1 ? achars[alength-i] : '0';
            char bchar = blength-i > -1 ? bchars[blength-i] : '0';
            if (achar == '0' && bchar == '0') {
                result.insert(0, addNumber);
                addNumber = '0';
            } else if ((achar == '0' && bchar == '1') || (achar == '1' && bchar == '0')) {
                if (addNumber == '0') {
                    result.insert(0, 1);
                    addNumber = '0';
                } else {
                    result.insert(0, 0);
                    addNumber = '1';
                }
            } else {
                if (addNumber == '0') {
                    result.insert(0, 0);
                    addNumber = '1';
                } else {
                    result.insert(0, 1);
                    addNumber = '1';
                }
            }
        }
        int oneIndex = result.indexOf("1");
        if (oneIndex > -1) {
            result.delete(0, oneIndex);
            return result.toString();
        }
        return "0";
    }
}
