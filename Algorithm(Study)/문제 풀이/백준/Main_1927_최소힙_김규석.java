import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1927_최소힙_김규석 {
	
	public static class minHeap {
		
		private ArrayList<Integer> heap;
		
		minHeap() {
			heap = new ArrayList<Integer>();
			heap.add(0);
		}
		
		public void insert(int val) {
			
			heap.add(val);
			
			int p = heap.size() - 1;
			
			while(p > 1 && heap.get(p/2) > heap.get(p)) {
				
				int temp = heap.get(p/2);
				heap.set(p/2, heap.get(p));
				heap.set(p, temp);
				
				p /= 2;
			}
		}
		
		public int delete() {
			
			if(heap.size() == 1) {
				return 0;
			}
			
			int deleteItem = heap.get(1);
			heap.set(1, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			
			while((pos*2) < heap.size()) {
				
				int min = heap.get(pos*2);
				int minPos = pos * 2;
				
				if(((pos*2+1) < heap.size()) && heap.get(pos*2) > heap.get(pos*2+1)) {
					
					min = heap.get(pos*2+1);
					minPos = pos * 2 + 1;
				}
				
				if(heap.get(pos) < min) break;
				
				int temp = heap.get(pos);
				heap.set(pos, min);
				heap.set(minPos, temp);
				pos = minPos;
			}
			
			return deleteItem;
		}
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		minHeap heap = new minHeap();
		
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				System.out.println(heap.delete());
			} else {
				heap.insert(val);
			}
		}
	}

}
