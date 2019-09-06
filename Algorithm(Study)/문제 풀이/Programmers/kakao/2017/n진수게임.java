class n진수게임 {
  static char[] c;
	static String t;
	static StringBuilder sb;
	
	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		
		String temp = "0";
		
		int cnt = 1;
		while(true) {
			temp += make(cnt++, n);
			if(temp.length() > 100000) break;
		}
		
		c = temp.toCharArray();
		
		sb = new StringBuilder();

		while(t > 0) {
			sb.append(c[p-1]);
			
			p += m;
			
			t--;
		}
		
		return sb.toString();
	}
	
	public static String make(int num, int b) {
		
		t = "";
		int chk = 0;
		char check;
		
		while(num > 0) {
			chk = num % b;
			
			switch (chk) {
			case 10:
				check = 'A';
				break;
			case 11:
				check = 'B';
				break;
			case 12:
				check = 'C';
				break;
			case 13:
				check = 'D';
				break;
			case 14:
				check = 'E';
				break;
			case 15:
				check = 'F';
				break;
			default:
				check = '0';
				break;
			}
			if(check == '0')
				t += Integer.toString(chk);
			else
				t += check;
			
			num /= b;
		}
		
		sb = new StringBuilder();
		
		for (int i = t.length()-1; i >= 0; i--) {
			 sb.append(t.charAt(i));
		}
		
		return sb.toString();
	}
}
