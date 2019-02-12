package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1218_°ýÈ£Â¦Áþ±â_±è±Ô¼® {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 1; i <= 1; i++) {
            String tc = br.readLine();
            
            String s = br.readLine();
            String[] arr = s.split("");
            int top1 = -1;
            int top2 = -1;
            int top3 = -1;
            int top4 = -1;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].equals("(")) top1++;
                else if(arr[j].equals(")")) top1--;
                else if(arr[j].equals("[")) top2++;
                else if(arr[j].equals("]")) top2--;
                else if(arr[j].equals("{")) top3++;
                else if(arr[j].equals("}")) top3--;
                else if(arr[j].equals("<")) top4++;
                else if(arr[j].equals(">")) top4--;
            }
            
            if(top1 == -1 && top2 == -1 && top3 == -1 && top4 == -1) {
                System.out.println("#"+i+" 1");
            }
            else {
                System.out.println("#"+i+" 0");
            }
        }
    }
}
