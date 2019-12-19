package top.dfghhj.leetCode.search;

import java.util.*;

/**
 * @Author: Dfghhj
 * @Date: 2019/12/19 22:06
 * @Description: 841. 钥匙和房间
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> used = new HashSet<>();
        queue.add(0);
        used.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int roomNumber = queue.poll();
                used.add(roomNumber);
                List<Integer> ysList = rooms.get(roomNumber);
                for (Integer ys : ysList) {
                    if (used.contains(ys)) {
                        continue;
                    }
                    queue.add(ys);
                }
            }
        }
        if (used.size() == rooms.size()) {
            return true;
        }
        return false;
    }
}
