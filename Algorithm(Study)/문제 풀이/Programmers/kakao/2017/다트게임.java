package algorithm;

public class ��Ʈ���� {
	
	static int[] score;

	public static int solution(String dartResult) {
		int answer = 0;
		
		char[] c = dartResult.toCharArray();
		score = new int[3];
		
		int scoreIdx = 0;
		int idx = 0;
		
		while(idx < c.length) {
			
			char k = c[idx];
			
			switch (k) {
			case 'S':
				// 1����
				break;
			case 'D':
				int temp = score[scoreIdx-1];
				score[scoreIdx-1] = temp * temp;
				break;
			case 'T':
				temp = score[scoreIdx-1];
				score[scoreIdx-1] = temp * temp * temp;
				break;
			case '*':
				temp = score[scoreIdx-1];
				score[scoreIdx-1] = temp * 2;
				if(scoreIdx-1 > 0) {
					int temp2 = score[scoreIdx-2];
					score[scoreIdx-2] = temp2 * 2;
				}
				break;
			case '#':
				temp = score[scoreIdx-1];
				score[scoreIdx-1] = -score[scoreIdx-1];
				break;

			default:
				if(c[idx+1] == '0') { // 10�� ���
					score[scoreIdx++] = 10;
					idx++;
				}
				else
					score[scoreIdx++] = k - '0';
				break;
			}
			
			
			idx++;
		}
		
		for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
		
		return answer;
	}

	public static void main(String[] args) {

		String dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));
	}

}
