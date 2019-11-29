package top.dfghhj.leetCode.search;

import java.util.*;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/11 21:07
 * @Description:
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * 示例 1:
 *   输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 *   输出：6
 *   解释：
 *   可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 *   注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 *   因为当拨动到 "0102" 时这个锁就会被锁定。
 */
public class OpenLock {

    public static void main(String[] args) {
//        String[] deadends = {"0201","0101","0102","1212","2002"};
//        String target = "0202";

//        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
//        String target = "8888";

//        String[] deadends = {"0003"};
//        String target = "0001";

        String[] deadends = {"0000"};
        String target = "8888";

        OpenLock openLock = new OpenLock();
        System.out.println(openLock.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        String root = "0000";
        if (deadendSet.contains(root)) {
            return -1;
        }

        Set<String> alreadySet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        alreadySet.add(root);
        int step = -1;
        while (!queue.isEmpty()) {
            step ++;
            int size = queue.size();
            for (int i=0;i<size;i++) {
                String now = queue.poll();
                if (target.equals(now)) {
                    return step;
                } else {
                    List<String> afters = getAfter(now);
                    for (String after:afters) {
                        if (deadendSet.contains(after)) {
                            continue;
                        } else if (alreadySet.contains(after)) {
                            continue;
                        } else {
                            queue.add(after);
                            alreadySet.add(after);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getAfter(String now) {
        List<String> afters = new ArrayList<>(8);
        for (int i=0;i<now.length();i++) {
            StringBuilder sb = new StringBuilder(now);
            // 判断是否是数字
            //if (Character.isDigit(sb.charAt(i))){
            int num = Integer.parseInt(String.valueOf(sb.charAt(i)));
            int a = num+1 == 10 ? 0 : num+1;
            sb.replace(i,i+1, a+"");
            afters.add(sb.toString());

            int b = num-1 < 0 ? 9 : num-1;
            sb.replace(i,i+1, b+"");
            afters.add(sb.toString());
            //}
        }
        return afters;
    }
}
