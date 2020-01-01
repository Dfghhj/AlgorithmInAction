package top.dfghhj.leetCode.string;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        int k = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (!"".equals(sArr[i])) {
                sArr[k] = sArr[i];
                k++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = k-1; i >= 0; i--) {
            result.append(sArr[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
