package com.ssafy.algo;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_∏∂¿Ã¬È_±Ë±‘ºÆ {
    
    public static void main(String[] args) {
        int[] arr = new int[21];
        Queue<Integer> q = new LinkedList<>();
        int now = 0;
        int total = 20;
        while(true) {
            q.add(++now);


            int poll = q.poll();
            arr[poll]++;
            total-=arr[poll];
            if(total<=0) {
                System.out.println(poll+"π¯");
                break;
            }
            q.add(poll);
        }
    }
}