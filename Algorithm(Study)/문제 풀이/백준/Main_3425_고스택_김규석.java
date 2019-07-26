import java.io.BufferedReader;
import java.io.InputStreamReader;

class ListNode {
    long data;
    ListNode prev;
    ListNode next;
     
    public ListNode()
    {
        data = 0;
        prev = this;
        next = this;
    }
 
    public static ListNode appendListNode(ListNode head, long data)
    {
        ListNode node = new ListNode();
        node.data = data;
        if (head == null)
        {
            head = node;
        }
        else
        {
            ListNode last = head.prev;
            last.next = node;
            head.prev = node;
            node.prev = last;
            node.next = head;
        }
        return head;
    }
     
    public static ListNode removeListNode(ListNode head, ListNode node)
    {
        if (head == head.next)
        {
            return null;
        }
        else
        {
            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            return (head == node) ? nextNode : head;
        }
         
    }
}

public class Main3425 {
	
	static String[] cal = new String[100001];
	static long[] add = new long[100001];
	static int idx, numidx;
	static int a, b;
	
	static long error = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//END를 받을 때까지 프로그램 수행 연산을 받는다.
		//개수를 알지 못하기 때문에, ArrayList에 저장?
		
		//NUM은 공백으로 숫자가 하나 들어온다
		
		//END 이후에는 N값과 N개의 수가 들어옴
		
		//빈칸이 들어오면 ArrayList 비워주기
		
		//QUIT이 들어오면 프로그램 종료
		
		idx = 0;
		numidx = 0;
		a = b = 0;
		
		while(true) {
			
			String[] input = br.readLine().split(" ");
			//종료조건
			if(input[0].equals("QUIT")) {
				break;
			}
			
			
			if(input[0].equals("END")) { // 하나의 프로그램 끝남 - N값 받고 실행
				int N = Integer.parseInt(br.readLine());
				
				for (int i = 0; i < N; i++) {
					long res = solution(Long.parseLong(br.readLine()));
					
					if(res == error)
						System.out.println("ERROR");
					else
						System.out.println(res);
				}
				
			}
			else if(input[0].equals("")) { // 공백일 때 ( 초기화 )
				idx = numidx = 0;
				System.out.println(); // 출력 시 띄어쓰기
			}
			else {
				cal[idx++] = input[0];
				a = idx;
				
				if(input[0].equals("NUM")) {
					add[numidx++] = Integer.parseInt(input[1]);
					b = numidx;
				}
			}
			
		}
	}
	
	public static long solution(long num) {
		//cal 배열에 연산 프로그램이 들어가있는 상태
		//해당 num을 가지고 스택연산 실행해야 함 (연결리스트 활용)
		ListNode head = null;
		head = ListNode.appendListNode(head, num);
		
		idx = numidx = 0;
		while(idx < a && numidx <= b) {
			
			if(cal[idx].equals("NUM")) { // 스택 가장 위 저장
				long number = add[numidx++];
				head = ListNode.appendListNode(head, number);
				
			} else if(cal[idx].equals("POP")) { // 가장 위 숫자 제거
				if(head != null)
					head = ListNode.removeListNode(head, head.prev);
				else
					return error;
					
			} else if(cal[idx].equals("INV")) { // 첫번째 수 부호 바꿈
				long number = head.prev.data;
				head.prev.data = -number;
				
			} else if(cal[idx].equals("DUP")) { // 첫번째 숫자 하나 더 가장 위에 저장
				long number = head.prev.data;
				ListNode.appendListNode(head, number);
				
			} else if(cal[idx].equals("SWP")) { // 첫번째와 두번재 숫자 바꿈
				
				long top = head.prev.data; // 맨위 숫자
				long second = head.prev.prev.data;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //맨위 숫자 제거
				else
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //다음 숫자 제거
				else
					return error;
				
				head = ListNode.appendListNode(head, top);
				head = ListNode.appendListNode(head, second);
				
			} else if(cal[idx].equals("ADD")) { // 첫번째 두번재 숫자 하나로 더함
				long top = head.prev.data; // 맨위 숫자
				long second = head.prev.prev.data;
				long sum = top + second;
				
				if(sum > 1000000000 || sum < -1000000000)
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //맨위 숫자 제거
				else
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //다음 숫자 제거
				else
					return error;
				
				head = ListNode.appendListNode(head, sum);
				
			} else if(cal[idx].equals("SUB")) { // 두번째 숫자 - 첫번째 숫자
				long top = head.prev.data; // 맨위 숫자
				long second = head.prev.prev.data;
				long sum = second - top;
				
				if(sum > 1000000000 || sum < -1000000000)
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //맨위 숫자 제거
				else
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //다음 숫자 제거
				else
					return error;
				
				head = ListNode.appendListNode(head, sum);
			} else if(cal[idx].equals("MUL")) { // 첫번째 두번재 숫자 하나로 곱합
				long top = head.prev.data; // 맨위 숫자
				long second = head.prev.prev.data;
				long sum = top * second;
				
				if(sum > 1000000000 || sum < -1000000000)
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //맨위 숫자 제거
				else
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //다음 숫자 제거
				else
					return error;
				
				head = ListNode.appendListNode(head, sum);
			} else if(cal[idx].equals("DIV")) { // 첫번째 두번재 숫자 나눈 몫 저장
				
				long top = head.prev.data; // 맨위 숫자
				if(top == 0) return error; // 0으로 나눴을 때
				long second = head.prev.prev.data;
				long sum = Math.abs(second) / Math.abs(top);
				
				//음수 체크
				int minusCnt = 0;
				if(top < 0) minusCnt++;
				if(second < 0) minusCnt++;
				
				if(minusCnt == 1) {
					sum = -sum;
				}
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //맨위 숫자 제거
				else
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //다음 숫자 제거
				else
					return error;
				
				head = ListNode.appendListNode(head, sum);
				
			} else if(cal[idx].equals("MOD")) { // 나누고 나머지 저장
				
				long top = head.prev.data; // 맨위 숫자
				if(top == 0) return error; // 0으로 나눴을 때
				long second = head.prev.prev.data;
				long sum = Math.abs(second) % Math.abs(top);
				
				if(second < 0) {
					sum = -sum;
				}
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //맨위 숫자 제거
				else
					return error;
				
				if(head != null)
					head = ListNode.removeListNode(head, head.prev); //다음 숫자 제거
				else
					return error;
				
				head = ListNode.appendListNode(head, sum);
				
			} 
			
				
			idx++;
		}
		
		
		int count = 0;
		long data = 0;
		
		while(head != null) {
			data = head.data;
			head = ListNode.removeListNode(head, head.prev);
			count++;
		}
		
		if(count == 1) {
			return data;
		}
		else {
			return error;
		}
	}

}
