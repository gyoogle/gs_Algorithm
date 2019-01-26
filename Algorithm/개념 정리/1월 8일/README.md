## 1월 8일(화) 알고리즘



*어제 복습!*

**버블정렬로 구현한 중간값 구하기**

```
//버블 정렬 : O(n^2)
//정렬 범위 : 0 ~ n-2, 시작 인덱스의 범위
		
		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				//두개씩 비교, 큰 것은 뒤로 보낸다
				
				if(arr[j] > arr[j+1]) { // 부등호 바꾸면 내림차순
					
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
				
				if (i == n/2-1) break; // 전체 정렬 필요없이 중간값만 찾으면 되기에 반만 정렬
					
			}
		}
		
System.out.println(arr[n/2]);
```



**카운트정렬로 구현한 중간값 구하기**

```
		int[] arr = {3,3,4,1,2,5,3,2,3,2};
		// 정렬할 데이터의 숫자의 범위를 미리 알아야 한다 min, max (1~5)
		int[] c = new int[6];
		
		//int c = 2; //숫자 2이 사용된 개수 카운팅
		
		for (int i = 0; i < arr.length; i++) {
			c[arr[i]]++;
		}
		System.out.println(Arrays.toString(c)); // 카운팅한 배열 출력
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i]; j++) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		// 중간 위치 값을 출력
		int x = 0;
		for (int i = 0; i < c.length; i++) {
			x += c[i]; // 사용된 숫자의 회수 누적
			if (x >= 11/2) {
				System.out.println(i);
				break;
			}
}
```



**입력 방법**

> 1. `Scanner s = new Scanner(System.in);`
>    시간이 많이 걸림, JDK5에서 추가됨
> 2. `BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
>    String str = br.readLine();`
>    매우 빠른 장점. but 문자열로만 가능



**출력 방법**

>1. `System.out.println();`
>   속도가 느림
>2. `BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
>   bw.write("abcd\n");`
>   줄을 따로 바꿔줘야 함



**문자열 → INT**

```
str = "20";
int num1 = Integer.parseInt(str); // 문자열을 숫자로 바꾸는 방법
int num2 = Integer.valueOf(str); 
// 똑같지만, valueOf는 내부적으로 parseInt를 호출해서 사용 (int long 등 모두 사용가능 하도록)
```



**split 활용(쪼개기)**

```
str = "1 2 3 4 5";
String[] srr = str.split(" ");
System.out.println(Arrays.toString(srr));
```



**static**

> - static 멤버는 non-static 멤버를 참조할 수 없다.
> - static 멤버가 먼저 사용할 수 있고 : 클래스의 정보가 처음 로딩될 때부터 프로그램 끝날 때까지
> - non-static 멤버는 나중에 사용할 수 있다 : 객체 생성시점 ~ 참조변수가 없어질 때까지

```
static void a() { // static을 붙여야 참조 가능
		
}
public static void main(String[] args) {
	a();
}
```





**재귀 함수**

> 나 자신의 함수를 다시 호출하는 함수
>
> 알고리즘 문제에서 필수적인 부분
>
> 속도가 비교적 느리다
>
> Call stack 영역 메모리를 많이 사용한다



**재귀 메소드는 if-else 구조 ( if는 빠져나올 때, else에는 다시 재귀 함수 실행)**



```
	static void a(int start, int end, int step) {
		
		if (start > end) { // 종료 파트
			System.out.println();
		}
		else { // 반복 파트
			System.out.print(start);
			a(start + step, end, step); // 나의 함수를 다시 호출
		}
		
	}
	public static void main(String[] args) {
		
		// for문 이용한 일반 출력
		// cpu의 연산만 사용해서 메모리의 사용은 적음
		for (int i = 0; i <= 4; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		// 재귀함수 활용한 출력
		a(0, 4, 1);
		
	}
```



**총 3가지 메모리 영역 생성** - Call stack, Heap, Method area

Call stack : main, 지역 변수 → a() 메소드 호출 → 반복

> 계속 반복되다가 Call stack 메모리가 부족하면 **스택 오버플로우** 발생

**따라서, 재귀 함수를 반드시 사용해야 하는 경우에만 사용하자**



**실습** : 사용자의 입력 start, end을 숫자로 받아서 start~end까지 합을 출력하는 재귀함수 e작성

```
	static int sum = 0;
	
	static void e(int start, int end) {
		
		if(start > end) {
			System.out.println("총 합 : " + sum);
			sum = 0; // 초기화
		} else {
			sum += start;
			e(start+1, end);
		}
	}
```







#### **★[Tip] 단축키**★

---

> - `Ctrl + SpaceBar` : **자동 완성**
> - `main + Ctrl + SpaceBar` : main 메서드 자동완성
> - `Ctrl + F11` : **컴파일 후 실행**
> - `F11` : **디버깅**
> - `Ctrl + M` : 전체화면 / 복귀 
> - `Ctrl + Shift + O` : import문 추가/삭제/정리
> - `Ctrl + Shift + F` : **전체/블록 영역 줄 정리**
> - `Ctrl + 마우스 클릭(=F3)` : 클래스/메서드/변수의 선언된 곳으로 화면 이동
> - `Alt + 왼/오른쪽 방향키` : 이전/이후 화면으로 이동





**팩토리얼 재귀 함수**

```
	public static void main(String[] args) {
		int n = 5;
		
		System.out.println(f(n));
	}
	
	public static int f(int n) {
		
		if(n == 1) {
			return 1;
		}else {
			return f(n-1) * n;
		}
		
	}
```



**2진수 3자리를 구성할 수 있는 모든 경우의 수 재귀함수 출력**

```
	binary(0, 3, new int[3]);
	
	public static void binary(int i, int end, int[] arr) {
		
		if( i == end ) { // 종료 조건
			System.out.println(Arrays.toString(arr));
		} else {
			arr[i] = 0;
			binary(i+1, end, arr);
			arr[i] = 1;
			binary(i+1, end, arr);
		}
		
	}
```



**탐욕 기법 Babygin** 

```
		int[] card = {0, 1, 4, 4, 4, 2};
		
		int[] cnt = new int[12]; // 각 숫자별 횟수 카운팅
		
		// 숫자 카드의 사용 횟수
		for (int i = 0; i < card.length; i++) {
			cnt[card[i]]++;
		}
		
		System.out.println(Arrays.toString(cnt));
		
		cnt[10] = cnt[0];
		cnt[11] = cnt[1];
		
		// 연속된 3개의 숫자 or 3번 이상 사용된 숫자를 찾기
		int check = 0;
		for (int i = 0; i < 10; i++) {
			if(cnt[i] >= 1 && cnt[i+1] >= 1 && cnt[i+2] >= 1) { //run
				System.out.println("RUN"); check++;
				cnt[i]--;
				cnt[i+1]--;
				cnt[i+2]--;
				i--;
			}
			if(cnt[i] >= 3) {// triplet
				System.out.println("TRIPLET"); check++;
				cnt[i] -= 3;
				i--;
			}
		}
		
		if(check == 2) System.out.println("Babygin");
		else System.out.println("Not Babygin");
```



**문제 풀때 배열을 조금 여유있게 만들기**

> 추가 배열은 쓰지 않으면 댐
>
> 기존의 cnt 배열을 10에서 12로 늘리고 `i+2 < cnt.length` 조건 제거
>
> ```
> int[] cnt = new int[12]; 
> 
> for (int i = 0; i < 10; i++) {
> 	if(cnt[i] >= 1 && cnt[i+1] >= 1 && cnt[i+2] >= 1) { //run
> 		System.out.println("RUN");
> 		cnt[i]--;
> 		cnt[i+1]--;
> 		cnt[i+2]--;
> 		i--;
> 	}
> 	if(cnt[i] >= 3) {// triplet
> 		System.out.println("TRIPLET");
> 		cnt[i] -= 3;
> 		i--;
> 	}
> }
> ```



