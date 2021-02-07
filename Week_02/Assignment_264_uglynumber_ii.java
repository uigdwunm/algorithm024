package Week_02;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Assignment_264_uglynumber_ii {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        priorityQueue.add(1L);
        set.add(1L);

        Long num = 1L;
        for (int i = 0; i < n; i++) {
            num = priorityQueue.poll();
            set.remove(num);
            long temp = num * 2;
            if (set.add(temp)) {
                priorityQueue.add(temp);
            }
            temp = num * 3;
            if (set.add(temp)) {
                priorityQueue.add(temp);
            }
            temp = num * 5;
            if (set.add(temp)) {
                priorityQueue.add(temp);
            }
        }

        return (int)(long)num;
    }
}
