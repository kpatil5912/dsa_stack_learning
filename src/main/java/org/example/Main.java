package org.example;

import org.example.assignmet6.StackExamples;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {

        StackExamples st = new StackExamples();
        int[] stones =  {2,7,4,1,8,1};
        System.out.println(st.lastStoneWeight(stones));

        int[] tickets  =  {2,3,2};
        System.out.println(st.timeRequiredToBuy(tickets, 2));



      /*  MyQueue obj = new MyQueue();
            obj.push(10);
            obj.push(20);
            obj.push(30);
            int param_2 = obj.pop();
            int param_3 = obj.peek();
            boolean param_4 = obj.empty();*/
    }


    // Leetcode : 232
    private static class MyQueue {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();

        public MyQueue() {

        }

        public void push(int x) {
            st1.push(x);
        }

        public int pop() {
            if (st2.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }

            return st2.pop();
        }

        public int peek() {
            if(st2.isEmpty()){
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
            }
            return st2.peek();
        }

        public boolean empty() {
            return st1.isEmpty() && st2.isEmpty();
        }
    }
}