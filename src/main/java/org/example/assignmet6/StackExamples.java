package org.example.assignmet6;

import java.util.*;

public class StackExamples {
    public StackExamples() {
    }

    // LeetCode : 1046
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

    // Leetcode 2073. Time Needed to Buy Tickets
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for( int i = 0; i< tickets.length; i++){
            if (i <= k) time += Math.min(tickets[i],tickets[k]);
            else time += Math.min(tickets[i],tickets[k] -1);
        }

        return time;
    }

    //Leetcode 84. Largest Rectangle in Histogram
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){

            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight){
                int height = heights[stack.pop()];
                int width ;
                if(stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;

                int area = height * width;
                maxArea = Math.max(maxArea, area);

            }

            stack.push(i);
        }
        return maxArea;
    }

//Leetcode 530. Minimum Absolute Difference in BST
    public int getMinimumDifference(TreeNode root) {
        TreeNode previous = null;
        int result = Integer.MAX_VALUE;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node){
        TreeNode previous = null;
        int result = Integer.MAX_VALUE;
        if(node == null) return;

        inOrder(node.left);
        if(previous != null){
            result = Math.min(result, (node.val - previous.val));
        }
        previous = node;
        inOrder(node.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Hacker Rank:  Maximum Element https://www.hackerrank.com/challenges/maximum-element/problem
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();


        for(String opr : operations){
            String [] part = opr.split(" ");
            int type = Integer.parseInt(part[0]);


            if(type == 1){
                int x = Integer.parseInt(part[1]);
                stack.push(x);
                if(maxStack.isEmpty()) maxStack.push(x);
                else maxStack.push(Math.max(x, maxStack.peek()));
            }else if(type == 2){
                stack.pop();
                maxStack.pop();
            }else if( type == 3){
                result.add(maxStack.peek());
            }
        }

        return result;
    }
}
