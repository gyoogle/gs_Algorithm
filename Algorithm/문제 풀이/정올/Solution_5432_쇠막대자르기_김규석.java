package com.ssafy.algo;

import java.util.Scanner;

public class Solution_5432_¼è¸·´ëÀÚ¸£±â_±è±Ô¼® {
    static int[] stack = new int[100010];
    static int top = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        int tc = Integer.parseInt(a);

        for (int p = 1; p <= tc; p++) {
            int cnt = 0;
            a = sc.nextLine();
            String[] arr = a.split("");

            if (arr[0].equals("(")) {
                stack[++top] = 1;
            } else {
                top--;
            }

            for (int i = 1; i < arr.length; i++) {
                if (arr[i].equals("(")) {
                    stack[++top] = 1;

                }

                else if (arr[i].equals(")")) {
                    top--;
                    if (top != -1 && arr[i - 1].equals("(")) {
                        cnt += top + 1;
                    } else if (top == -1) {
                        if (arr[i - 1].equals("(")) {
                        } else {
                            cnt++;
                        }
                    } else {
                        cnt++;
                    }

                }
            }
            System.out.println("#" + p + " " + cnt);
        }
    }
}