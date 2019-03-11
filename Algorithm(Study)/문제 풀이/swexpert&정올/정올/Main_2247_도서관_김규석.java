package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2247_도서관_김규석 {

	static class Student implements Comparable<Student>{
		int start;
		int end;
		
		Student(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Student o) {
			if(this.start == o.start)
				return this.end < o.end ? -1 : 1;
			else return this.start < o.start ? -1 : 1;
		}

		@Override
		public String toString() {
			return "Student [start=" + start + ", end=" + end + "]";
		}
	}
	
	static int max;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		Student[] student = new Student[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			student[i] = new Student(start, end);
		}
		
		Arrays.sort(student);
		
		
		max = Integer.MIN_VALUE;
		min = Integer.MIN_VALUE;
		
		for (int i = 0; i < student.length-1; i++) {
			int k = 1;
			while(true) {
				if(i+k >= student.length) break;
				if(student[i].end >= student[i+k].start) {
					if(student[i].end <= student[i+k].end)
						student[i].end = student[i+k].end;
					else
						student[i+k].end = student[i].end;
					int v = student[i].end - student[i].start;
					k++;
					if(max < v) max = v;
				}
				else {
					int v = student[i+k].start - student[i].end;
					if(min < v) min = v;
					break;
				}
			}
		}
		
		System.out.println(max + " " + min);
		
	}
}
