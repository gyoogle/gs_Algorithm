import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1931_Seungah {
	//회의실배정
		static int N;
		static int[][] arr;

		public static void main(String[] args) throws Exception {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			N = Integer.parseInt(bf.readLine());
			arr=new int[N][2];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine()," ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr,new Comparator<int[]>() {
				//0 : o1==o2
				//1 : o1>o2
				//-1 : o1<o2
				//arr[n][1]을 기준으로 오름차순 정렬
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o2[1]==o1[1]) {
						return o1[0]-o2[0];
					}
					else return o1[1]-o2[1];
			
				
				}
			});
		
		
			

			System.out.println(solve());
			
		
		}
		
		static int solve(){
			
			int now=0;
			int cnt=1;
			
			for(int i=1;i<N;i++) {
				//다음 회의의 시작시간이 현재 회의의 종료시간보다 작으면 continue
				if(arr[i][0]<arr[now][1]) continue;
			
				cnt++;
				now=i;
			}
			
			
			return cnt;

			
		}//end of solve
}
