package org.example.assignmet6;

import java.util.Collections;
import java.util.PriorityQueue;

public class StackExamples {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : stones){
            queue.add(num);
        }

        while(queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();

            if(x != y){
                int diff = x - y;
                queue.add(diff);
            }

        }
        return queue.isEmpty() ? 0 : queue.peek();







    }
}
