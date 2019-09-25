public class 점프와순간이동 {
	
	public static int solution(int n) {
        
		int count = 0;
		while(n != 0) {
			if(n % 2 == 1) {
				count++;
			}
			n/=2;
		}
		return count;
    }

	public static void main(String[] args) {
		System.out.println(solution(5000));
	}

}
