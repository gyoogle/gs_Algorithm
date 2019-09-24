class 다음큰숫자 {
  public static int solution(int n) {
		int answer = 0;
		
		String b = Integer.toBinaryString(n);
		
		int cnt = 0;
		char[] c = b.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if(c[i] == '1') cnt++;
		}
		
		for (int i = n+1; i <= 1000000; i++) {
			
			b = Integer.toBinaryString(i);
			
			int cnt2 = 0;
			char[] c2 = b.toCharArray();
			for (int j = 0; j < c2.length; j++) {
				if(c2[j] == '1') cnt2++;
			}
			
			if(cnt == cnt2) {
				answer = i;
				break;
			}
			
		}
		
		return answer;
	}
}
