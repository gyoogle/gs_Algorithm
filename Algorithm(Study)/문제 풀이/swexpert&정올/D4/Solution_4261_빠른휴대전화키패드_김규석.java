import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4261_빠른휴대전화키패드_김규석 {

	static String[] S;
	static int N;
	static String[] arr;
	static int alpha[] = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ts = Integer.parseInt(br.readLine());

		for (int t = 1; t <= ts; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			S = st.nextToken().split("");
			N = Integer.parseInt(st.nextToken());
			
			arr = new String[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			cnt = 0;
			
			for (int i = 0; i < arr.length; i++) {
				String[] str = arr[i].split("");
				String[] save = new String[str.length];
				for (int j = 0; j < str.length; j++) { // arr배열에 저장한 알파벳을 숫자로 변환하는 과정
					save[j] = Integer.toString(alpha[str[j].charAt(0) - 'a']);
				}
				
				boolean chk = true;
				for (int j = 0; j < S.length-1; j++) { // 만약 인덱스 끝에 가기전에 다른 숫자가 있으면 불가능
					if(!S[j].equals(save[j])) {
						chk = false;
						break;
					}
				}
				if(!chk) continue;
				
				if(S.length == save.length) { // 두 배열의 길이가 같고 마지막 인덱스 value 값이 같으면 추가
					if(S[S.length-1].equals(save[save.length-1])){
						cnt += 1;
					}
				}
			}
			
			System.out.println("#"+t+" " + cnt);
		}
	}

}
