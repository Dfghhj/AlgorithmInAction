package top.dfghhj.leetCode.string;

/**
 * 557. 反转字符串中的单词 III
 */
public class ReverseWords3 {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=0; i<sArr.length; i++) {
            result.append(reverseWord(sArr[i]));
            if (i<sArr.length-1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    private String reverseWord(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
