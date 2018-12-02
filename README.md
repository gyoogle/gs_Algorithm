## SSAFY 파이썬 사전 학습 개념 요약 정리

*삼성 청년 소프트웨어 아카데미 1기*

*사전 동영상 강의에서 기억할 내용 정리*

<br/>

**인덱스 활용**

```
>>> var = "python"
>>> var[0] #p
>>> var[1] #y
>>> var[0:3] #pyt

>>> var = "python is powerful"
>>> var[10:] #powerful

끝에서부터 가져오고 싶다면?
>>> var[-3:] #ful
>>> var[-8:] #powerful

>>> var[:] #python is powerful
```

<br/>

```
>>> def change(x):
		x[0] = 'H'
>>> wordlist = ['J', 'A', 'M']
>>> change(wordlist)
>>> wordlist #['H', 'A', 'M']

원본 데이터를 변경시키지 않고 싶으면?
>>> def change(x):
		x = x[:] # 복사본을 만들어 return
		x[0] = 'H'
>>> wordlist = ['J', 'A', 'M']
>>> change(wordlist)
>>> wordlist #['J', 'A', 'M']
```

실수로 값을 변경하는 것을 막으려면 불변형에 담아두자

지속적으로 데이터 추가/삭제가 필요하면, 가변형인 리스트나 딕셔너리 사용하자

<br/>

**스코핑 룰**

> 파이썬에서 함수는 별도의 이름 공간(namespace)
>
> 이때 이름을 찾는 방법이 '스코핑 룰'
>
> 변수 사용을 위해서는 반드시 알아야 할 규칙

<br/>

**변수 이름 해석 단계**

> 함수 내부 공간에서 지역(**L**ocal) 변수를 찾음
>
> 없으면 함수 외부 공간의 전역(**G**lobal) 변수에서 찾음
>
> 없으면 파이썬 자체의 내장(**B**uilt-in) 함수에서 찾음
>
> - LGB 순서로 검색!

<br/>

**튜플** : (1,2,3)

**리스트** : [1,2,3]

**셋** : {1,2,3}

**딕셔너리** : {'a':1, 'b':2}

<br/>

**가변 인자 처리** : *을 붙인다

`def union2(*ar)`

**정의되지 않은 인자 처리** : **을 붙인다

`def userURI(server, port, **user)`

<br/>

```
>>> def union2(*ar):
		res = []
		for item in ar:
			for x in item:
				if not x in res:
					res.append(x)
		return res

>>> union2("HAM", "EGG") #['H','A','M','E','G']
>>> union2("HAM", "EGG", "SPAM") #['H','A','M','E','G','S','P']
```

<br/>

**익명 함수** : `lambda`

```
>>> g = lambda x,y : x*y
>>> g(2,3) #6

정의하자마자 값 호출 (일회성 함수)
>>> (lambda x : x*x(3)) #9
```

<br/>

**그냥 넘어갈 때** : `pass`

```
무한루프에서 벗어날 때는 Ctrl+C
```

<br/>

**생성한 함수의 설명 추가** : `__doc__, help`

```
>>> def add(a,b):
>>> 	return a+b
>>> add.__doc__ = "이 함수는 2개의 인자를 받아 덧셈을 수행합니다"
>>> help(add)
```

<br/>

**순회 가능 형식에서 값을 안전하고 빠르게 나열하고 싶을 때** : `이터레이터 객체`

```
>>> for element in [1,2,3]:
>>> 	print(element)
1
2
3

>>> for element in 'abc':
>>> 	print(element)
a
b
c
```

<br/>