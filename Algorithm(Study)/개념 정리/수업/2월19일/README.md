## 트라이(TRIE)

> re**trie**val



문자열의 집합을 표현하는 트리를 말한다

`모든 문자열은 다른 문자열의 접두어가 아니라고 가정`

![1550542899989](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1550542899989.png)



- 부분 문자열 검사

  > ba가 abac의 부분 문자열인가?

- 두개 접두사의 최장 공통 접두어 찾기

  > abac와 ac의 최장 공통 접두어는?

- 사전적 순서로 정렬된 k번째 접미사 찾기

  > abac의 3번째 접미사는? : abac, ac, bac, c (정답 : bac)



각 간선은 하나의 문자에 대응한다

같은 노드에 나오는 간선들은 같은 레벨을 갖지 않음

각 문자열은 단말 노드에 대응한다



![1550543039901](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1550543039901.png)



##### Compressed Trie

> 노드들과 간선들을 부분 문자열로 압축

*(= 접미어 트리(Suffix Tree))*

![1550543482856](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1550543482856.png)







##### 문자열 S = {xabxac}에 대한 접미어 트리

![1550543683926](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1550543683926.png)



##### 발생하는 문제점

![1550543856361](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1550543856361.png)



##### 해결책

> 하나의 접미어가 다른 접미어의 접두어가 되는 경우를 표현하기 위해 문자열 끝에 특수문자 추가



![1550543893639](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1550543893639.png)





#### 접미어 배열

> 접미어 트리보다 메모리를 좀 더 효율적으로 사용할 수 있음 (구조가 간단)
>
> 2개의 선형 크기 배열로 구성되며 트리에 비해 1/4 크기 메모리 사용
>
> 하지만 느린 단점 또한 존재



트리보다 접미어 배열이 더 많이 사용되는 추세



##### 복잡도

> 메모리 크기 : O(n)
>
> 시간 : O(nlogn)

