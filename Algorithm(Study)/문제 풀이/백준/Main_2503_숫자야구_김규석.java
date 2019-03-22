import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2503_���ھ߱�_��Լ� {

	static int N;
	static String[] str;
	static int[] strike;
	static int[] ball;
	
	static int[] set;
	static int[] num = {1,2,3,4,5,6,7,8,9}; // ���� 1~9 ����
	static int cnt;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		str = new String[N];
		strike = new int[N];
		ball = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
			str[i] = st.nextToken();
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}
	
		
		set = new int[9];
		
		for (int i = 0; i < 9; i++) {
			set[i] = i;
		}
		
		cnt = 0;
		
		perm(set, 0, 9, 3); // ���� ������
		
		System.out.println(cnt);
	}
	
	public static void perm(int[] set, int size, int N, int K) {
		
		if(size == K){
			String baseball = "";
			for (int i = 0; i < size; i++) {
				baseball += Integer.toString(num[set[i]]);
			}
			if(checking(baseball)) cnt++;
			return;
		}
		
		
		for (int i = size; i < N; i++) {
			swap(set, i, size);
			perm(set, size+1, N, K);
			swap(set, i, size);
		}
	}
	
	public static boolean checking(String baseball) {
		String[] chk = baseball.split("");
		
		for (int i = 0; i < N; i++) {
			
			String[] chk2 = str[i].split("");
			int s = 0; // ��Ʈ
			int b = 0; // ��
			
			for (int j = 0; j < chk.length; j++) { // ��Ʈ����ũ üũ
				if(chk[j].equals(chk2[j]))
					s++;
			}
			
			for (int j = 0; j < chk.length; j++) { // �� üũ
				for (int z = 0; z < chk2.length; z++) {
					if(j==z) continue;
					else {
						if(chk[j].equals(chk2[z]))
							b++;
					}
				}
			}
			
			if(strike[i] != s || ball[i] != b) // Ʋ���� ������ �ش�x
				return false;
			
		}
		
		return true;
	}
	
	public static void swap(int[] set, int i, int index){
		int temp = set[i];
		set[i] = set[index];
		set[index] = temp;
	}

}
