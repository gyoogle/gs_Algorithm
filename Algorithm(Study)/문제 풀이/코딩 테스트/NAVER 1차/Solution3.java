package NAVER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
   static int cook_count;
   static int[] indegree, required_steps, required_times;
   static ArrayList<Integer>[] connection;
   static Queue<Integer> q;

   static int[] solution(int[] cook_times, int[][] order, int k) {

      int[] ret = new int[2];

      cook_count = cook_times.length;
      indegree = new int[cook_count];
      required_steps = new int[cook_count];
      required_times = new int[cook_count];
      connection = new ArrayList[cook_count];
      q = new LinkedList<Integer>();

      // 연결 상태 초기화 - 단방향 연결 리스트
      for (int c = 0; c < cook_count; c++) {
         connection[c] = new ArrayList<>();
      }

      // indegree 증가
      for (int o = 0; o < order.length; o++) {
         indegree[order[o][1] - 1]++;
         connection[order[o][0] - 1].add(order[o][1] - 1);
      }

      // 시간 추가
      for (int i = 0; i < cook_count; i++) {
         if (indegree[i] == 0) {
            required_steps[i] = 1;
            required_times[i] = cook_times[i];
            indegree[i] = -1;
            q.add(i);
         }
      }
      
      // 전부 돌 필요 없는 경우
      if (indegree[k - 1] == -1) {
         ret[0] = 0;
         ret[1] = required_times[k - 1];
         return ret;
      }
      
      // indegree 0 인 것 넣기
      while (!q.isEmpty()) {

         // iteration 만큼 회전
         while (!q.isEmpty()) {
            int cur = q.poll();
            
            // 해당 사이즈만큼 증가시키기.
            for (int i = 0; i < connection[cur].size(); i++) {
               int nxt = connection[cur].get(i);
               indegree[nxt]--;

               required_steps[nxt] += required_steps[cur];
               required_times[nxt] = (required_times[nxt] > cook_times[nxt] + required_times[cur])
                     ? required_times[nxt] : cook_times[nxt] + required_times[cur];
            }
         }

         // 0인 것 다시 추가해주기.
         for (int i = 0; i < cook_count; i++) {
            if (indegree[i] == 0) {
               q.add(i);
               indegree[i] = -1;
            }
         }
      }

      ret[0] = required_steps[k - 1];
      ret[1] = required_times[k - 1];

      return ret;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(solution(new int[] { 5, 30, 15, 30, 35, 20, 4 }, new int[][] { { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 1, 6 }, { 4, 6 }, { 5, 6 }, { 6, 7 } }, 6)));
      System.out.println(Arrays.toString(solution(new int[] { 5, 30, 15, 30, 35, 20, 4, 50, 40 }, new int[][] { { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 1, 6 }, { 4, 6 }, { 5, 6 }, { 6, 7 }, {8, 9} }, 9)));
      System.out.println(Arrays.toString(solution(new int[] { 5, 3, 2 }, new int[][] { { 1, 2 }, { 2, 3 }, { 1, 3 }}, 3)));
      
   }

}
