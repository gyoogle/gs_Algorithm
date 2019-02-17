## 2월 11일(월)



### 복잡도 분석

---



시간 복잡도

공간 복잡도

가독성



##### O(Big-Oh) 표기

> 복잡도의 점근적 상한을 나타냄
>
> f(n) = 2n^2-7n+4 라면 f(n)의 O-표기는 O(n^2) - 실행시간이 n^2에 비례



& : AND

| : OR

^ : XOR

~ : NOT

<< : left shift



##### 비트 연산

```
public class Z25_비트연산 {

	public static void main(String[] args) {
		
		//int n = 123; // 10진수
		//int n = 0x12f; // 16진수 0x, 0X
		//int n = 123; // 8진수 0
		//int n = 0b101; // 2진수 0b 0B
		int n = 0b100110111; // 9자리 2진수
		
		for (int i = 0; i < 9; i++) {
			System.out.print((n & (1 << i)) == 0 ? 0 : 1);
		}
		
		System.out.println();
		// 9자리인 것을 알아내기(자리수)
		int k = (int) (Math.log(n) / Math.log(2)) + 1;
		System.out.println(k + "자리");
		
		/*
		System.out.println((n & 0b1) == 0 ? 0 : 1); // 비트 마스킹
		System.out.println((n & 0b10) == 0 ? 0 : 1);
		System.out.println((n & 0b100) == 0 ? 0 : 1);
		System.out.println((n & 0b1000) == 0 ? 0 : 1);
		System.out.println((n & 0b10000) == 0 ? 0 : 1);
		System.out.println((n & 0b100000) == 0 ? 0 : 1);
		System.out.println((n & 0b1000000) == 0 ? 0 : 1);
		System.out.println((n & 0b10000000) == 0 ? 0 : 1);
		System.out.println((n & 0b100000000) == 0 ? 0 : 1);
		*/
		
		System.out.println(n + " 10 진수로 변경한 값1");
		// int n = 0b100110111; // 9자리 2진수
		
		// 2진수 값을 10진수로 변경하기
		int result = 0; // n을 10진수로 변경한 값을 저장할 변수
		for (int i = 0; i < 9; i++) { 
			if((n & (1<<i)) != 0) { // 비트가 1인 자리
				result += ( n & (1<<i));
			}
		}
		System.out.println(result+ " 10 진수로 변경한 값2");
		
		result = 0; // n을 10진수로 변경한 값을 저장할 변수
		for (int i = 8; i >= 0; i--) { // 앞자리서부터 내려오기
			result = result << 1; // result <<= 1; // 자리수를 올림 
			if((n & (1<<i)) != 0) { // 비트가 1인 자리
				result = result + 1;
			}
		}
		System.out.println(result+ " 10 진수로 변경한 값3");
		
		
		
	} // end of main

} // end of class
```



