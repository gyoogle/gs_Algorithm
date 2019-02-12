import java.util.Scanner;

public class Solution5622 {
//백준 5622 다이얼
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		
		int sum=0; 
		for(int i=0;i<str.length();i++) {
			int now = str.charAt(i)-'A';
			
			if(now >= 15 && now<=18) now = 5;
			else if(now>=19 && now<=22) now = 6;
			else if(now >=23 && now<=26) now = 7;
			else now /= 3;
			sum+=(now+2);
		}
		
		System.out.println(sum+str.length());
	}
}


/*
 * A B C   0 1 2
 * D E F   3 4 5
 * G H I   6 7 8
 * J K L    9 10 11
 * M N O   12 13 14
 * P Q R S   15 16 17 18
 * T U V    19 20 21 22
 * W X Y Z    23 24 25 26
 * */
