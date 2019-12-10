package top.dfghhj.leetCode.search;

import java.util.*;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/11 21:07
 * @Description: 752.打开转盘锁
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
