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