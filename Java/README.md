### 자바

---

##### 자바 특징

> 객체 지향
>
> 플랫폼 독립적
>
> 간단함 (메모리 관리)
>
> 분산 프로그래밍 지원
>
> 멀티 스레드



##### 객체 지향 특징

> 추상화
>
> 캡슐화
>
> 상속
>
> 다형성



##### 기본형

> 정수 타입: byte (1byte), short (2byte), int (4byte), long (8byte)
>
> 부동소수점 타입: float (4byte) , double (8byte)  
>
> 부울 타입: boolean (1byte) // true,false 두 가지 값만 표현 
>
> 문자 데이터 타입: char (2byte)

- float에는 꼭 F 붙여야 함 `float a = 10.2F`



##### Array

> 배열 복사 : arraycopy



##### 메모리 공간

> 스택 : 메소드 수행
>
> 힙 : 객체 생성
>
> 클래스 area : 클래스, static 정보 등



##### 가비지 컬렉션

> 힙 영역(클래스 포함)에 생성된 객체들의 메모리를 관리하는 프로그램
>
> 사용하지 않는 객체들을 점검하고 제거함



##### 전역 변수

> 클래스 내에 정의되는 변수
>
> 힙에 생성
>
> static : class가 메모리 로딩 시 할당이 이루어지고, 자동 초기화, 클래스 제거시 같이 제거
>
> instance : 객체 생성 시 자동 초기화, 객체 제거시 같이 제거



##### 지역 변수

> 메소드나 생성자 안에서 정의되는 변수
>
> 스택에 생성
>
> 호출 시 생성되고, 수행 종료 시 제거
>
> 자동 초기화 안되므로 반드시 '초기화'해서 사용



##### 오버로딩

> 비슷한 일을 하는 메소드 구현 시, 메소드 이름을 같게 정의 (사용하기 편리하도록)
>
> 메소드 이름은 같고, 매개변수를 다르게 함



##### 오버라이딩

> 부모 클래스의 메소드를 자식 클래스에서 재정의해서 사용
>
> 메소드, 매개변수 모두 같음



##### 접근 제한자

![1547986240590](C:\Users\김규철\AppData\Roaming\Typora\typora-user-images\1547986240590.png)

> private : 같은 클래스 내에서만 사용
>
> default : 아무것도 정의하지 않았을 때, 같은 클래스와 패키지에서만 사용 가능
>
> protected : 패키지 다르면 사용 불가능, 단 상속 받으면 사용 가능
>
> public : 어디서든 사용 가능



##### 사용 제한자

> static : 객체 생성 없이 사용하고 싶을 때
>
> final : 변경할 수 없음
>
> abstract : 미완성 상태



##### 캡슐화

> 중요하거나 상세한 구현은 private 이용해서 숨김
>
> getter setter를 통해 접근 및 제어



##### 상속

> extends
>
> 속성이나 기능을 선택적으로 상속 불가능 (부모 클래스의 전체 기능을 상속)
>
> 상속은 단 하나의 클래스만 받을 수 있음 (여러 클래스 상속 불가)
>
> 다중 상속하려면? interface 활용 
>
> super는 생성자 첫 라인에서만 사용 가능



##### 레퍼런스 타입 캐스팅

> 상속관계일 경우 형변환 허용
>
> - 자동 형변환
>   자식 객체 내에는 항상 부모 객체가 같이 있기 때문에 부모 객체 타입으로 자식 객체를 참조 가능
>
>   `Parent var = new Child();`
>
>
>
> ##### 예시
>
> ```
> // 부모의 부모 클래스
> class GrandParent {
> 	String name = "Bill";
> 	
> 	public void printName() {
> 		System.out.println("name:"+name);
> 	}
> 
> 	public void printAddress() {
> 		System.out.println("");
> 	}
> }
> 
> // 부모 클래스
> class Parent extends GrandParent {
> 	private String name = "Tom";
> 	public String address = "Seoul";
> 	
> 	Parent(){
> 	//	System.out.println("Parent 생성자입니다");
> 	}
> 	
> 	public void printName() {
> 		System.out.println("name : " + name);
> 	}
> 	public void printAddress() {
> 		System.out.println("address : " + address);
> 	}
> }
> 
> 
> 
> // 자식 클래스
> 
> public class Child extends Parent {
> 	int age = 25;
> 	Child(){
> 	//	System.out.println("Child 생성자입니다");
> 	}
> 	
> 	// method overriding : 부모한테서 물려 받은 메소드를 자식 클래스에 맞게 수정하는 일
> 	// method 이름, 리턴타입, 파라메터 타입 모두 동일해야 함
> 	// 접근지정자는 부모의 지정자와 같거나 큰 것만 가능
> 	
> 	@Override
> 	public void printName() {
> 		System.out.println("name : Tomson");
> 	}
> 	
> 	public void callSuper() {
> 		super.printName();
> 	}
> 	
> 	
> 	public static void main(String[] args) {
> 		
> 		GrandParent c = new Child(); // 다형성(생성된 객체를 가리키는 레퍼런스(변수)의 타입이 여러가지인 경우)
> 		System.out.println(c.getClass());
> 		
> 		
> 		c.printName();
> 		c.printAddress();
> 		
> 		//c.callSuper();
> 		//super.printName();//super, this --> static 메소드 안에서는 사용안됨
> 		//c.address = "la";
> 		
> 		//Child ch = (Child) new Parent();
> 	}
> 
> 
> }
> ```
>
>
> main 안에 내용만 다시 살펴보기
>
> ```
> GrandParent c = new Child();
> //다형성 이용, GrandParent가 가장 큰 범위이므로 Child로 생성자 만들 수 있음
> 
> Child ch = (Child) new Parent();
> //에러는 안나지만 컴파일 시, ClassCast 오류 발생
> 
> System.out.println(c.getClass()); //class Child
> 		
> c.printName(); // 자식 클래스에 정의된 이름 출력 
> c.printAddress(); // GrandParent에는 printAddress 메소드가 있고, 자식 클래스에는 없으므로, 상속하는 부모 클래스의 주소 출력
> 
> //c.callSuper(); // GrandParent에 callSuper 메소드가 없으므로 불가능
> //((Child) c).callSuper(); //이렇게 타입캐스팅 해줘야 Parent로부터 가져옴
> //super.printName();//super, this --> static 메소드 안에서는 사용안됨
> //c.address = "la";
> ```
>
>
>
> - 명시적 형변환
>   자동 형변환에 의해 변환된 부모 타입 변수는 자식 객체가 추가한 메소드 수행 불가능
>   따라서 원래 타입으로 변경하고자 할 때 명시적 형변환 사용
>   `Parent var = new Child();`
>
>   `Child c = (Child) var;`
>
>   이를 통해 자식 객체만 따로 가지고 있는 변수를 접근할 수 있음
>   하지만, 자식 객체만 가지고 있지 않을 때 ClassCast 오류 발생. 따라서 instanceof를 활용해서 형변환 하기 전에 서브 객체를 갖고 있는지 확인해야 함
>
>   ```
>   if(c instanceof Child){
>       Child cc = (Child) c;
>   }
>   ```
>
>   instanceof : 객체의 존재여부를 물어보는 연산자



##### String (문자열)

> concat : 추가
>
> replace : 대체
>
> substring : 일부 추출 (2,5면 2~4까지 추출)
>
> trim : 문자열 앞뒤 여백 제거
>
> startsWith : 특정 문자열 시작



##### StringBuilder

> append : 끝에 추가
>
> insert(int index, String s) : index에 s 추가
>
> reverse : 뒤집기



##### Wrapper

> 기본형 데이터 타입을 객체화 시키는 클래스
>
> 기본형 앞글자 대문자로



##### int → String

```
int i = 1;
String s = Integer.toString(i);
```

##### String →  int

```
String s = "1";
int i = Integer.parseInt(s);
```



static은 객체 생성 없이 사용 가능

final는 상수라고 생각하면 됨 (상속, 오버라이드 불가능)

interface는 변수 사용 불가능, 모두 상수로 정의 (public static final)

abstract는 미완성이라 객체 생성 불가능. 상속 받은 클래스가 메소드를 모두 구현해야 생성 가능



##### 인터페이스(interface)

> implements
>
> 상수, 구현되지 않은 메소드로만 구성
>
> 상수를 특별히 명시하지 않아도 자동으로 변경됨 (public도 같이)
>
> 인터페이스는 다중 상속 가능



##### Collection

![1547991840369](C:\Users\김규철\AppData\Roaming\Typora\typora-user-images\1547991840369.png)

1. set

   > 객체 저장 시 순서 없이 저장
   >
   > 같은 데이터는 무시
   >
   > - HashSet
   >
   >   > set 구현 클래스
   >   >
   >   > 같은 내용 들어오면 무시
   >
   > - TreeSet
   >
   >   > sortedset 구현 클래스
   >   >
   >   > 객체들을 sort해서 관리
   >
   >
   >
   > ##### 출력
   >
   >
   > ```
   > // iterator 활용
   > Iterator<String> i = list.iterator();
   > while (i.hasNext()) {
   >     String ob = i.next();
   >     Syso(ob);
   > }
   > 
   > //for-each 활용
   > for (String s : list){
   >     syso(s);
   > }
   > ```



2. List

   > 객체 저장 시 인덱스를 가지고 순서대로 저장
   >
   > 중복된 데이터도 상관없이 저장



3. Map

   > 데이터 저장,관리 시 검색을 쉽게 하기 위함
   >
   > key와 value로 구성
   >
   > TreeMap : sort된 map
   >
   >
   >
   > ##### 출력
   >
   >
   > ```
   > Iterator<String> i = list.keySet().iterator;
   > while(i.hasNext()){
   >     String key = i.next();
   >     String value = list.get(key);
   >     syso(key, value)
   > }
   > ```



##### Singleton pattern

> 객체 생성을 딱 한번만 수행하고, 그 이후에는 생성한 객체를 공유하는 방식

```
public class SingletonObject {

	// 필드는 private static으로
	private static SingletonObject instance;
	
	private SingletonObject() {}
	
	public static SingletonObject getInstance() {
		if(instance == null) {
			instance = new SingletonObject();
		}
		return instance;
	}
	
	public void print() {
		System.out.println("hello, print~");
	}

}
```

```
public class SingletonObjectUser {

	public static void main(String[] args) {
		SingletonObject o1 = SingletonObject.getInstance();
		SingletonObject o2 = SingletonObject.getInstance();
		SingletonObject o3 = SingletonObject.getInstance();
		
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		
		//하나로 공유하는 방식이라 모두 같음
		System.out.println(o1 == o2); // true
	}

}
```

