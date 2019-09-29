   static Queue<info> q;
   static class info {
      long sum;
      long next;
      
      public info(long sum, long next) {
         this.sum = sum;
         this.next = next;
      }
   }

   private static long Solution(long nth) {
      q = new LinkedList<>();
      q.add(new info(1 * 2, 3));
      
      // 추가하기.
      long cth = 1;
      long start = 2;
      long answer = 2;
      
      while(cth < nth) {
         long nxt = q.peek().sum * q.peek().next;
         cth++;
         
         // 새로 들어올 것이 더 작은 경우
         if (start * (start + 1) < nxt) {
            answer = start * (start + 1);
            q.add(new info(start * ++start, start + 1));
         } 
         
         // 새로 들어와야 하는 경우
         else if (start * (start + 1) == nxt) {
            answer = nxt;
            start++;
            q.add(new info(nxt, q.peek().next + 1));
            q.poll();
         }
         
         // 큰 경우
         else {
            answer = nxt;
            q.add(new info(nxt, q.peek().next + 1));
            q.poll();
         }
      }
      return answer;
   }
