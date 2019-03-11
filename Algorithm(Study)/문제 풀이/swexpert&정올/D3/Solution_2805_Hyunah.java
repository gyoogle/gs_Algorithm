import java.util.Scanner;

public class Solution_2805_Hyunah {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int sum=0;
			for(int i=n/2; i>=0; i--) {
				String s = sc.next();
				for(int j=i; j<n-i; j++) {
					sum += s.charAt(j)-'0';
				}
			}
			for(int i=1; i<=n/2; i++) {
				String s = sc.next();
				for(int j=i; j<n-i; j++) {
					sum += s.charAt(j)-'0';
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}

}
