## Javascript 심화



ES2015+가 등장하면서, 기존의 자바스크립트 문법에서 더 편리한 기능들이 추가되었다.

Node.js에서 활용도가 높은 부분에 대해 알아보자



#### 1) const, let

보통 자바스크립트 변수 선언 시 var를 이용했음

하지만 이제 const와 let으로 대체!



기존의 var는 함수 스코프를 가졌지만, const와 let은 블록 스코프를 가짐

>  블록 스코프는 if, while, for, function 등에서 사용하는 중괄호에 속함



따라서 const와 let을 중괄호 안에서 사용하게 되면, 그 스코프 범위 안에서만 접근이 가능해짐

(이를 통해 기존의 호이스팅 문제를 해결 가능!)



***그럼 const와 let 차이가 뭐에요?***

let : 대입한 값을 계속 수정할 수 있음

const : 한번 대입하면 다른 값 대입 불가능 (초기화 시 값 필요)

```javascript
const a = 0;
a = 1; // error

let b = 0;
b = 1; // 1

const c; // error
```





#### 2) 템플릿 문자열

백틱(`)을 이용한 새로운 문자열 생성이 가능함 ( 백틱은 tab키 위에 있음 )

이제 문자열 안에 변수도 넣을 수 있게 됨. 

원래 기존 변수에서 따옴표와 +를 통해 문자열을 연결했지만, 백틱은 한번에 가능



```javascript
var string = num1 + ' + ' + num2 + ' = ' + result;

const string = `${num1} + ${num2} = ${result}`;
```





#### 3) 객체 리터럴

oldObject 객체에 동적으로 속성을 추가하는 상황

```javascript
var sayNode = function() {
    console.log('Node');
};
 
var es = 'ES';
var oldObject = {
    sayJS: function(){
        console.log('JS');
    },
    sayNode: sayNode,
};
 
oldObject[es + 6] = 'Fantastic';
 
oldObject.sayNode();
oldObject.sayJS();
console.log(oldObject.ES6);
```



아래와 같이 수정이 가능함

```javascript
var sayNode = function() {
  	console.log('Node');  
};

var es = 'ES';

const newObject = {
    sayJS() {
        console.log('JS');
    },
    sayNode,
    [es+6]: 'Fantastic',
};

newObject.sayNode();
newObject.sayJS();
console.log(newObject.ES6);
```



객체 안 메서드에서 콜론과 function을 붙이지 않아도 되고, 중복되는 이름의 변수는 sayNode 하나만 작성하는 식으로 구현 가능

객체 속성명을 동적으로 생성이 가능해짐. 이제 객체 리터럴 바깥에서 새로 만들지 않고, 안에서 추가할 수 있음



#### 4) 화살표 함수

아래 둘다 똑같은 기능을 함

```javascript
function add(x,y) {
    return x+y;
}


const add = (x,y) => x+y;
```



화살표 함수에서는 function 대신 => 기호 사용

(return문을 줄일 수 있는 장점)



이 밖에도 this 바인드 방식에서 차이점 존재



```javascript
var relationship1 = {
    name: 'kim',
    friends: ['a','b','c'],
    logFriends: function() {
    	var that = this; // relationship1을 가리키는 this를 that에 저장
        
        this.friends.forEach(function(friend) {
           console.log(that.name, friend);                  
        });
    },
};

relationship1.logFriends();
```



relationship1.logFriends()에서 forEach문 안에 function 선언문을 사용했음

따라서 각자 다른 함수 스코프 this를 가지게 되므로 that이라는 변수에 this를 미리 저장하고 사용해야 함



하지만 화살표 함수를 사용하면?



```javascript
const relationship2 = {
    name: 'kim',
    friends: ['a', 'b', 'c'],
    logFriends() {
        this.friends.forEach(friend => {
            console.log(this.name, friend);
        });
    },
};
relationship2.logFriends();
```

forEach 문에서 function을 선언하지 않고 화살표 함수를 사용했기 때문에 logFriends()의 this를 그대로 사용이 가능해짐

상황에 따라 맞게 사용할 것!



#### 5) 비구조화 할당

객체나 배열에서 속성 or 요소를 꺼내올 때 사용



기존 활용법

```javascript
var candyMachine = {
    status: {
        name: 'node',
        count: 5,
    },
    getCandy: function() {
        this.status.count--;
        return this.status.count;
    }
};

var getCandy = candyMachine.getCandy;
var count = candyMachine.status.count;
```



이제는?

```javascript
const candyMachine = {
    status: {
        name: 'node',
        count: 5,
    },
    getCandy: function() {
        this.status.count--;
        return this.status.count;
    }
};

const { getCandy, status: {count} } = candyMachine;
```

이처럼 간단히 한줄로 나타내는 것이 가능해짐



비구조화 할당을 이용하면, 배열의 위치마다 변수를 넣어 똑같은 역할을 하도록 만들 수 있음

코드 수를 줄일 수 있고, 노드는 모듈을 많이 사용하기 때문에 활용 빈도가 높음





#### 6) 프로미스(promise)



자바스크립트와 노드는 비동기 프로그래밍이라 이벤트 주도 방식을 활용하면서 '콜백 함수'를 많이 사용함

콜백함수는 자체만으로도 복잡한 구성으로 이루어져 있고, 자바스크립트를 배울 때 어려운 내용 중에 하나임



ES2015부터는 콜백 대신 프로미스 구반으로 재구성되고 있음

프로미스를 잘 활용하면 콜백 함수 지옥에서 벗어날 수 있기 때문에 잘 이해해둘 것



##### 프로미스 객체 구조

```javascript
const condition = true;

const promise = new Promise((resolve, reject) => {
    if (condition) {
        resolve('성공');
    } else {
        reject('실패');
    }
});

promise
    .then((message) => {
    	console.log(message);
	})
    .catch((error) => {
    	console.log(error);
	});
```

new Promise로 프로미스 생성

resolve와 reject를 매개변수로 갖는 콜백 함수로 구성



이제 선언한 promise 변수에 then과 catch 메서드를 통해 콜백안의 콜백을 대체

위의 코드에서는 condition이 true이기 때문에 resolve('성공')이 호출되고 message에 '성공'이 들어가 log로 출력된다.

만약 false면 reject('실패')가 호출되어 catch문이 실행되고 error에 '실패'가 출력된다.



실제로 콜백을 프로미스로 바꿔보자



##### 콜백 함수 활용

```javascript
function findAndSaveUser(Users) {
    
    Users.findOne({}, (err, user) => { // 첫번째 콜백
        if(err) {
            return console.error(err);
        } 
        user.name = 'kim';
        user.save((err) => { // 두번째 콜백
            if(err) {
                return console.error(err);
            }
            Users.findOne({gender: 'm'}, (err, user) => { // 세번째 콜백
                // 생략
            });
        });
    });
    
}
```

현재 콜백 함수가 3번 중첩된 모습을 볼 수 있음

콜백 함수가 계속 나오면, 코드가 깊어지고 각 콜백 함수마다 에러도 따로 처리해야 함



##### 프로미스 활용

```javascript
function findAndSaveUser(Users) {
    Users.findOne({})
    	.then((user) => {
            user.name = 'kim';
        	return user.save();
    	})
        .then((user) => {
        	return Users.findOne({gender: 'm'});
    	})
        .then((user) => {
        	// 생략
    	})
        .catch(err => {
        	console.error(err);
    	});
}
```



프로미스의 then을 활용해 코드가 깊어지지 않도록 만들었음

then 메서드는 순차적으로 실행되고, 에러는 마지막 catch를 통해 한번에 처리 가능



※ 모든 콜백 함수를 프로미스로 고칠 수 있는 건 아님 (find와 save 메소드가 프로미스 방식을 지원하기 때문에 가능)



***프로미스 여러개를 한꺼번에 실행하려면?***

Promise.all 활용

```javascript
const promise1 = Promise.resolve('성공1');
const promise2 = Promise.resolve('성공2');
 
Promise.all([promise1, promise2])
    .then((result) => {
        console.log(result);
    })
    .catch((error) => {
        console.error(err);
    });
```



promise.all에 해당하는 모든 프로미스가 resolve 상태여야 then으로 넘어감

만약 하나라도 reject가 있으면 catch문으로 감



이처럼 기존의 콜백 함수를 프로미스로 구현하면 여러번 중첩하지 않고 깔끔하게 만드는 것이 가능해짐!





#### 7) async/await

ES2017에 추가된 최신 기능

프로미스를 조금 더 깔끔하게 만들어주는 도움을 줌



##### 기존 프로미스 코드

```javascript
function findAndSaveUser(Users) {
    Users.findOne({})
    	.then((user) => {
            user.name = 'kim';
        	return user.save();
    	})
        .then((user) => {
        	return Users.findOne({gender: 'm'});
    	})
        .then((user) => {
        	// 생략
    	})
        .catch(err => {
        	console.error(err);
    	});
}
```



콜백 함수의 깊이 문제를 해결하긴 했지만, 여전히 코드가 김

새로운 async/await 문법을 사용하면 아래와 같이 변경 가능



```javascript
async function findAndSaveUser(Users) {
    try {
        let user = await Users.findOne({});
        user.name = 'kim';
        user = await user.save();
        user = await Users.findOne({gender: 'm'});
        // 생략
    } catch(err) {
        console.error(err);
    }
}
```

엄청 짧아진 모습을 볼 수 있음



function 앞에 async를 붙여주고, 프로미스 앞에 await을 붙이는 방식

await을 붙인 프로미스가 resolve 될 때까지 기다린 후 다음 로직으로 넘김



이번엔 화살표 함수를 이용해 async/await을 사용해보자



```javascript
const findAndSaveUser = async (Users) => {
    try {
        let user = await Users.findOne({});
        user.name = 'kim';
        user = await user.save();
        user = await Users.findOne({gender: 'm'});
        // 생략
    } catch(err) {
        console.error(err);
    }
}
```



앞으로는 콜백 함수를 프로미스 혹은 async를 적극 활용해서 만드는 습관을 기르자