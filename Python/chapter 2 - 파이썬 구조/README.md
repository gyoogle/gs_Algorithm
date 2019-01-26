## Chapter 2 - 파이썬 구조

<br/>

**객체지향 프로그래밍 3가지 특징**

> 1. 추상성 : 꼭 필요한 부분만 구현
> 2. 상속성 : 부모 클래스에서 공통부분을 상속받는 것
> 3. 다형성 : 동일한 인터페이스에 대해 구체적 인스턴스마다 다른 동작을 할 수 있는 것

<br/>

**클래스 정의 및 인스턴스 객체 생성**

```
class Person:
	name = "Default Name"
	def print(self):
		print("My name is {0}".format(self.name))
		
p1 = Person()
p1.print()
# My name is Default Name

p2 = Person()
P2.name = "Joe"
p2.print()
# My name is Joe
```

<br/>

**인스턴스 객체 멤버 변수 이름 해석 순서**

> 인스턴스 객체 내부 → 클래스 객체 내부 → 전역 공간

<br/>

**self** : 자기 자신을 참조함

```
str = "Not Class Member"
class GString:
	str = ""
	def set(self, msg):
		self.str = msg
	def print(self):
		print(self.str)

g = GString()
g.set("First Message")
g.print()
# First Message
```

<br/>



**생성자&소멸자**

> - 생성자 : 객체의 초기화 담당 : 객체 생성 시 가장 먼저 호출
> - 소멸자 : 객체의 소멸을 담당 : 객체 레퍼런스 카운트가 0이 될 때 자동 호출

```
class MyClass:
	def __init__(self,value):
		self.value = value
		print("Class is created! Value = ", value)
	def __del__(self):
		print("Class is deleted!")

d = MyClass(10)
del d
```

 <br/>

**정적 메소드**

> 클래스에서 직접 호출 가능
>
> self라는 인자 선언하지 않음
>
> 클래스 이름, 메소드 명으로 호출

```
class MyCalc(object):
	@staticmethod
	def my_add(x,y):
		return x+y

#클래스에서 직접 호출
a = MyCalc.my_add(5,7)
print(a)
```

@staticmethod : 데코레이터 문법(메타 데이터 전달)

<br/>



**private**

> 선언 : `__name` 
>
> 외부 접근 : `_클래스 명__name`

| 식별자(예약어) | 정의                               | 예시      |
| -------------- | ---------------------------------- | --------- |
| `_*`           | 다른 파일에서 접근할 수 없음       | `_name`   |
| `__*__`        | 시스템에서 정의한 이름             | `__doc__` |
| `__*`          | 외부로 노출되지 않는 식별자로 인식 | `__name`  |

```
class BankAccount:
    __id = 0
    __name = ""
    __balance = 0

    def __init__(self, id, name, balance):
        self.__id = id
        self.__name = name
        self.__balance = balance
    def deposit(self, amount):
        self.__balance += amount
    def withdraw(self, amount):
        self.__balance -= amount
    def __str__(self):
        return "{0}, {1}, {2}".format(self.__id, self.__name, self.__balance)

account1 = BankAccount(100, "전우치", 15000)
account1.withdraw(3000)
print(account1)

#balance에 접근하려면 private이므로 아래처럼 작성해야 함
print(account1._BankAccount__balance)
```

<br/>

**상속** : 부모 클래스의 모든 멤버를 자식에게 물려주는 것

**다형성** : 상속받은 메소드의 바디를 덮어쓰기

```
class Person:
    def __init__(self, name, phoneNumber):
        self.name = name
        self.phoneNumber = phoneNumber
    def printInfo(self):
        print("Info(Name:{0}, Phone Number:{1}".format(self.name, self.phoneNumber))

class Student(Person):
    def __init__(self, name, phoneNumber, subject, studentID):
        Person.__init__(self,name,phoneNumber) #부모 상속
        self.subject = subject
        self.studentID = studentID
    def printInfo(self):
        print("Info(Name:{0}, Phone Number:{1}".format(self.name, self.phoneNumber))
        print("Info(Subject:{0}, StudentID:{1}".format(self.subject, self.studentID))

p = Person("전우치", "010-1234-5678")
s = Student("이순신", "010-111-1234", "컴공", "99911")

print(p.printInfo())
print(s.printInfo())
print(p.__dict__)
print(s.__dict__)
```

`__dict__` : 객체 내부의 값을 볼 수 있음

<br/>

**다중 상속** : 두개 이상의 클래스를 동시에 상속

**다중 상속 이름 충돌 문제** : 상속 받은 두 클래스에서 같은 이름의 메소드가 있다면 누구의 것을 상속받는가?

> 먼저 작성한 클래스 대로 우선순위를 가지게 된다.

```
class Tiger:
    def jump(self):
        print("호랑이 점프!!")
    def cry(self):
        print("호랑이 어흥~")
class Lion:
    def play(self):
        print("사자 활동 중")
    def cry(self):
        print("사자 으르렁~")
class Liger(Tiger, Lion):
    def bite(self):
        print("라이거 물기")

l = Liger()
l.bite()
l.cry() # 다중 상속(먼저 상속받은 Tiger로)
```

<br/>

**모듈** : 여러 코드를 묶어 다른 곳에서 재사용 할 수 있도록 모아둔 것

내장 모듈(기본 제공 라이브러리)과 사용자 정의 모듈(직접 생성)로 구성

**자주 쓰이는 내장 모듈**

> 문자열(string), 날짜(date), 시간(time), 수학(math), 랜덤(random), 파일(file)
> sqlite3, os, sys, xml, http

**사용자 정의 모듈**

> 직접 함수 구현한 모듈을 c:\python\lib에 복사해두고 사용 가능

<br/>

**from절과 import절 활용**

- `from <module> import <func>` : import된 어트리뷰트를 바로 사용 가능
- `from <module> import * ` : 해당 모듈의 모든 어트리뷰트 사용 가능(__로 시작은 X)

<br/>



**파이썬 주요 에러 사항**

> - `IndexError : list index out of range`  : 인덱스 첨자가 벗어난 상황
> - `TypeError : unsupported operand type for /: int and str` : 형식이 잘못된 경우

<br/>



**try except** : 실행시간에 에러가 발생하여 코드가 중단되는 것을 방지

```
def divide(a,b):
    return a / b

try:
    c = divide(5, 'string')
except ZeroDivisionError:
    print('분모가 0이면 안됩니다')
except TypeError:
    print('인자는 숫자여야 합니다')
except:
    print('또다른 이유로 발생한 에러')
else:
    print('Result: {0}'.format(c))
finally:
    print('무조건 실행')
```

<br/>



내장 예외 클래스로는 한계가 있기 때문에 사용자 정의 예외 클래스를 만들어 활용한다.

**raise** : 강제로 에러를 발생시키고 싶을 때 사용

사용자 정의 Exception 클래스는 부모클래스로 Exception 클래스를 상속 받아야 함

```
class NegativeDivisionError(Exception):
    def __init__(self, value):
        self.value = value
def positiveDivide(a,b):
    if(b < 0):
        raise NegativeDivisionError(b)
    return a/ b

try:
    ret = positiveDivide(10, -3)
    print('10/ 3 = {0}'.format(ret))
except NegativeDivisionError as e:
    print('Error - Second argument of PositiveDivide is', e.value)
except ZeroDivisionError as e:
    print('Error -', e.args[0])
```





