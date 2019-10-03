import java.util.ArrayList;
import java.util.Collections;

class 단속카메라 {
    static class Car implements Comparable<Car>{
		int start;
		int end;
		int dis;
		
		public Car(int start, int end, int dis) {
			this.start = start;
			this.end = end;
			this.dis = dis;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getDis() {
			return dis;
		}

		public void setDis(int dis) {
			this.dis = dis;
		}

		@Override
		public int compareTo(Car o) {
			if(this.start==o.start)
				return this.dis > o.dis ? -1 : 1;
			return this.start < o.start ? -1 : 1;
		}
	}
	
	static ArrayList<Car> list;
	
	public static int solution(int[][] routes) {
        int answer = 0;
        
        list = new ArrayList<>();
        
        for (int i = 0; i < routes.length; i++) {
			int start = routes[i][0];
			int end = routes[i][1];
			int dis = end - start;
			list.add(new Car(start, end, dis));
		}
        
        // sort
        Collections.sort(list);
        
//        for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).start + " : " + list.get(i).end);
//		}
        
        int s = list.get(0).start;
        int e = list.get(0).end;
        
        for (int i = 1; i < list.size(); i++) {
			int ls = list.get(i).start;
			int le = list.get(i).end;
			
			if(e < ls) {
				answer++;
				e = le;
			}
			else if(e == ls) {
				e = ls;
			}
			else {
				if(e > le) e = le;
			}
			
			//System.out.println("now : " + s + " , " + e);
		}
        answer++;
        
        // if(s == list.get(0).start || e == list.get(0).end) {
        // 	answer = 1;
        // }
        
        
        return answer;
    }
}
