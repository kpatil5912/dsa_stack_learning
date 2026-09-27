package org.example;

import java.util.Collections;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int[] stones =  {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }


    public static  int lastStoneWeight(int[] stones) {
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