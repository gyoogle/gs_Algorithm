import java.util.Arrays;

class 파일명정렬 {
	  static class File {
			String head;
			String number;
			String tail;
			int idx;
			
			public File(String head, String number, String tail, int idx) {
				this.head = head;
				this.number = number;
				this.tail = tail;
				this.idx = idx;
			}

			@Override
			public String toString() {
				return head + number + tail;
			}
			
			
		}
		
		static File[] list;
		static int headIdx, numberIdx;
		static String head, number, tail;
		static int s = 0;

		public static String[] solution(String[] files) {
			String[] answer = {};
			
			list = new File[files.length];
			
			char[] c;
			
			for (int i = 0; i < files.length; i++) {
				headIdx = numberIdx = 0;
				head = number = tail = "";
				
				String file = files[i];
				c = file.toCharArray();
				
				for (int j = 0; j < c.length; j++) {
					if(c[j] - '0' >= 0 && c[j] - '0' <= 9) {
						headIdx = j-1;
						break;
					}
				}
				int chk = 0;
				for (int j = headIdx+1; j < c.length; j++) {
					if(chk == 5) {
						numberIdx = j-1;
						break;
					}
					
					if(c[j] - '0' >= 0 && c[j] - '0' <= 9) {
						chk++;
						if(j == c.length-1)
							numberIdx = j;
					}
					else {
						numberIdx = j-1;
						break;
					}
				}
				
				for (int j = 0; j < c.length; j++) {
					if(j <= headIdx) {
						head += c[j];
					}
					else if(j <= numberIdx) {
						number += c[j];
					}
					else if(j > numberIdx)
						tail += c[j];
				}
				list[i] = new File(head, number, tail, s++);
			}
			
			quickSort(list, 0, list.length-1);
			
			answer = new String[list.length];
			
			for (int i = 0; i < list.length; i++) {
				answer[i] = list[i].toString();
			}
			
			return answer;
		}
		
		public static void quickSort(File[] arr, int left, int right) {
			
			if(left >= right) return;
			
			if(left < right) {
				
				File pivot = arr[(left+right)/2];
				int i = left-1;
				int j = right+1;
				
				while(true) {
					
					while(arr[++i].head.toLowerCase().compareTo(pivot.head.toLowerCase()) < 0 ||
							(arr[i].head.toLowerCase().compareTo(pivot.head.toLowerCase()) == 0 && (Integer.parseInt(arr[i].number) < Integer.parseInt(pivot.number))) ||
						  (arr[i].head.toLowerCase().compareTo(pivot.head.toLowerCase()) == 0 && (Integer.parseInt(arr[i].number) == Integer.parseInt(pivot.number)) && arr[i].idx < pivot.idx)
							) {}
					while(arr[--j].head.toLowerCase().compareTo(pivot.head.toLowerCase()) > 0 ||
							(arr[j].head.toLowerCase().compareTo(pivot.head.toLowerCase()) == 0 && (Integer.parseInt(arr[j].number) > Integer.parseInt(pivot.number))) ||
							  (arr[j].head.toLowerCase().compareTo(pivot.head.toLowerCase()) == 0 && (Integer.parseInt(arr[j].number) == Integer.parseInt(pivot.number)) && arr[j].idx > pivot.idx)
							  ) {}
					
					if(i >= j) break;
					
					File temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				
				quickSort(arr, left, i-1);
				quickSort(arr, j+1, right);
			}
			
		}
		
		public static void main(String[] args) {
			
			String[] files = {"F-15", "F-16", "F-15.zip"};
			System.out.println(Arrays.toString(solution(files)));
		}
	}
