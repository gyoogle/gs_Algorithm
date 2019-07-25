import java.io.BufferedReader;
import java.io.InputStreamReader;

class Trie {
	boolean end;
	boolean pass;
	Trie[] child;
	
	Trie() {
		end = false;
		pass = false;
		child = new Trie[10];
	}
	
	public boolean insert(String str, int idx) {
		
		//������ �ܾ� ������ false ����
		if(end) return false;
		
		//idx�� str��ŭ ������
		if(idx == str.length()) {
			end = true;
			if(pass) return false; // �� �������� �ܾ� ������ false ����
			else return true;
		}
		//���� �ȿ��� ��
		else {
			int next = str.charAt(idx) - '0';
			if(child[next] == null) {
				child[next] = new Trie();
				pass = true;
			}
			return child[next].insert(str, idx+1);
		}
		
	}
}

public class Main5052_Test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			
			int N = Integer.parseInt(br.readLine());
			boolean chk = false;
			Trie trie = new Trie();
			for (int j = 0; j < N; j++) {
				if(!chk){
					if(!trie.insert(br.readLine(), 0)){
						sb.append("NO").append("\n");
						chk = true;
					}
				}
				else
					br.readLine();
			}
			if(!chk) {
				sb.append("YES").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
