import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Problem1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int[] arr = new int[num]; // 입력 수 저장할 배열 생성
		Stack<Integer> stack = new Stack<>(); // 스택 생성
		ArrayList<String> str = new ArrayList<String>();
		
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine()); //입력할 수 arr에 저장
		}
		
		int cnt = 0; // 증가시킬 수
		int arrCnt = 0; // arr배열 인덱스
		
		while(arrCnt!=num){ // 인덱스 값이 num이랑 같기 전까지
			
			if(stack.isEmpty()) { // 스택 비어있으면 추가
				stack.push(++cnt);
				str.add("+");
			}
			
			else if(stack.peek() == arr[arrCnt]){ // 스택 맨 끝 값과 arr배열 값과 같으면 pop
				str.add("-");
				stack.pop();
				arrCnt++; // 다음 값 찾기위해 arr배열 인덱스 증가
			}
			else if (stack.peek() <= arr[arrCnt]){ 
				str.add("+");
				stack.push(++cnt);
			}
			
			else {
				System.out.println("NO");
				return;
			}
		}
		
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
		
		br.close();
	}

}