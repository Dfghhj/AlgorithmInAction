package top.dfghhj.leetCode.string;

/**
 * 28. 实现 strStr()
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle) || haystack.equals(needle)) return 0;
        int m = haystack.length();
        int n = needle.length();
        int[] occ = new int[128];
        for (int i = 0; i < occ.length; i++) {
            occ[i] = -1;
        }
        for (int i = 0; i < needle.length(); i++) {
            occ[needle.charAt(i)] = i;
        }
        int jump = 0;
        for (int i = 0; i <= m-n; i += jump) {
            int j = 0;
            while (j < n && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i;
            }
            jump = i+n<m ? n-occ[haystack.charAt(i+n)] : 1;
        }
        return -1;
    }
}
