# Git 사용법

<br>

Git Bash 터미널을 열어 사용해보자!

<br>

#### 명령어

---

##### cd [폴더 이름] : 해당 디렉토리로 이동

```
$ cd documents : 현재폴더의 하위폴더인 documents 폴더로 이동
$ cd /c/workspace : 절대경로 /c/workspace 로 이동
$ cd .. : 상위 폴더로 이동 
```

##### mkdir [폴더 이름] : 디렉토리 생성

```
$ mkdir test : 현재 위치에 test 디렉토리 생성
```

##### touch [파일 이름] : 빈 파일 생성

```
$ touch index.txt : 현재 위치에 index.txt 파일을 생성
```

##### ls : 현재 디렉토리 폴더, 파일을 보여줌

```
$ ls
```

<br>

<br>



#### Git 사용

---

- 사용자 등록

  > user.email과 user.name을 등록한다.

  ```
  $ git config --global user.email "[이메일주소]"
  $ git config --global user.name "[이름]"
  ```

  <br>

- 저장소 생성 및 commit

  ```
  $ git init
  ```

  init을 하면, master branch가 생성됨 (git bash 현재 폴더명에 branch 이름(master) 추가)

  > git bash에서 뒤에 (master)와 같이 branch 이름이 보이면 git 저장소가 설정된 폴더다

  init 이후에 해당 폴더에는 .git이라는 숨김 폴더가 생성되는데, 여기는 건드리지 말기

  ```
  $ git add .
  ```

  add 뒤에 `.`은 현재 새로 만들어진 모든 파일을 저장할 대상으로 지정한다는 뜻

  (하나만 지정하려면 해당 파일 이름을 적어도 됨)

  ```
  $ git commit -m "[메세지]"
  ```

  *commit이란?*

  > 쉽게 생각하면, 우리가 게임을 하면서 save 기능을 사용하는 것과 같다.

  add를 통해 지정한 파일들을 commit한다. `-m`은 메세지를 남긴다는 명령어로, 어떤 내용을 commit하는지 상황에 따라 작성해주면 된다

  ```
  $ git log
  ```

  > commit 된 list를 보여줌

  log를 통해보면, 7자리로 commit id가 지정된 모습을 확인할 수 있다.

  <br>

- 이전 commit 돌아가기

  ```
  $ git reset --hard [commit 아이디]
  ```

  때때로 이전 commit 상태로 돌아가고 싶을 때가 있다

  reset 기능을 통해 해당 commit 상태로 되돌리는 것이 가능함

  > --hard : commit 당시 상태로 완전히 되돌림
  >
  > --soft : commit만 취소하고 파일들은 현재 상태를 유지
  >
  > (soft는 즉, commit id는 삭제되지만 해당 commit id로 저장한 파일은 사라지지 않음)

<br>

#### 원격 저장소에 연동하기

---

원격 저장소에 연동하기에 앞서, 로컬 저장소는 다음과 같이 구성되어 있다

```
1. 작업 디렉토리 : 실제 파일들이 존재
2. 인덱스 : 준비 영역의 역할
3. 헤드 : 최종 확정본(commit)
```

> *git add를 하면?* : 인덱스에 추가됨
>
> *git commit을 하면?* : 헤드에 추가, 실제로 변경 내용을 확정

이후에 `git push`를 통해 원격 저장소에 반영을 하게 된다

<br>

push는 로컬 저장소에 원격 저장소를 연결하고 사용해야 함

> github 사이트에서 연동할 repository를 생성해두고 진행

<br>

- 원격 저장소 연동하기

  ```
  $ git remote add origin [연동할 github repository url].git
  ```

  이제 해당 로컬 저장소와 원격 저장소가 연동된다

  잘 연동되었는 지 확인하려면 아래와 같이 작성하면 된다

  ```
  $ git remote -v
  ```

  콘솔창에 내 github repository 주소가 잘 나오면 문제가 없는 것이다

  <br>

- 원격 저장소에 올리기

  ```
  $ git push origin master
  ```

  데이터가 전송되는 모습이 나오면서, commit한 데이터가 github에 올라간 모습을 확인할 수 있다

  

