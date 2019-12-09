package top.dfghhj.algorithm.base.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：feifeng
 * @date ：Created in 2019/12/2 11:05
 * @description: 回文判断
 */
public class PalindromeTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("1");
        stringList.add("1");
        stringList.add("2");
        stringList.add("1");
        System.out.println(isPalindrome(stringList));
    }

    public static boolean isPalindrome(List<String> stringList) {
        int size = stringList.size();
        for (int i=0; i<size/2; i++) {
            if (!stringList.get(i).equals(stringList.get(size-i-1))) {
                return false;
            }
        }
        return true;
    }
}
