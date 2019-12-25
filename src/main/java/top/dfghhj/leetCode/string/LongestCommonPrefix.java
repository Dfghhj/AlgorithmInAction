package top.dfghhj.leetCode.string;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs == null || strs.length == 0) return result.toString();
        if (strs.length == 1) return strs[0];
        for (int index = 0; index < strs[0].length(); index++) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < index+1 || strs[i].charAt(index) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}
