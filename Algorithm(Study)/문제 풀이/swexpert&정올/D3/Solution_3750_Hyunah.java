import java.util.Scanner;

public class Solution_3750_Hyunah {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			String n = sc.next();
			while(n.length() != 1) {
				int sum = 0;
				for(int i=0; i<n.length(); i++) {
					sum+=(n.charAt(i)-'0');
				}
				n = sum+"";
			}
			System.out.println("#" + t + " " + n);
		}
		sc.close();
	}

}
