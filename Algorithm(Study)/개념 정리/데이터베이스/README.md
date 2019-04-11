### 데이터베이스

---

##### 데이터베이스 구성 요소

> 개체 : 고객, 학생
>
> 속성 : 학생(학번, 이름, 학년, 주소)
>
> 관계 : 개체와 개체 or 개체와 속성간의 관계



##### DBMS

> 데이터베이스 관리 시스템



##### 데이터베이스 스키마

> 데이터베이스 구조 + 제약 조건



##### 데이터베이스 언어

> **데이터 정의어(DDL)** : 관리자 or 설계자 → 관계 정의, 구조 변경 및 수정 
>
> **데이터 조작어(DML)** : 일반 사용자 → 실제 데이터를 검색, 수정, 삭제, 변경
>
> 데이터 제어어(DCL) : 관리자  → 데이터 관리를 위한 보안, 무결성, 복구, 병행 수행 제어



**데이터베이스 관리자(DBA)** : 전체 책임자(Administrator)



##### 데이터베이스 단위

> 행 : 투플, 레코드
>
> 열 : 필드, 애트리뷰트, 속성



##### cmd 창에서 mysql 접속 방법

> `mysql -u scott -p`
>
> 패스워드 : `tiger`

##### sql 소스파일 추가

> source `sql 파일`

##### 테이블 보기

> show tables;

##### 테이블 삭제

> drop table `sql파일 이름`;

##### 테이블 상세 보기

> desc emp;

**ID** : root / **Password** : manager

작업하기 전에는 어떤 DB를 쓸건지 선택하고 진행하기 (scott이면 scott 더블클릭 후 진하게 만듬)

![1554860361792](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1554860361792.png)

쿼리 실행 : `ctrl + Enter`

마우스 선택 후 그 부분만 실행 : `ctrl+Shift+Enter`



주석은 -- 두번으로 작성할 수 있음

##### Select

```
-- 사번, fname 검색
select empid, fname
from emp;
```



##### DISTINCT

> 중복되는 컬럼 값 중 하나씩만 추출

```
-- 중복값 제거
select distinct deptid
from emp;
```



##### order by

```
select empid, fname, salary
from emp
order by salary desc;

desc가 내림차순
asc가 올림차순
```



##### alias(컬럼 별칭 주기)

```
select empid as "사번 번호", fname 이름
from emp;
```



##### 연산자 활용

```
select empid 사번, fname 이름, salary 연봉, salary*1.1 새연봉
from emp;
---
select empid 사번, fname 이름, comm 인센티브, comm*1.3 "새 인센티브"
from emp
order by 4 desc;
```



##### where (조건달기)

```
select empid, fname, salary
from emp
where salary > 9000;

---

select empid, fname, salary, hdate
from emp
where hdate > "2005-01-01";
```



##### Practice

```
-- 연봉이 6500 이상인 레코드
select * 
from emp
where salary >= 6500;

-- jobid가 'FI_ACCOUNT'인 레코드
select *
from emp
where jobid = 'FI_ACCOUNT';

-- 150번 이후 사번 레코드
select *
from emp
where empid >= 150;

-- LOCID가 1300인 부서의 도시
select city
from loc
where locid = 1300;

-- 미국에 있는 부서 ID
select locid
from loc
where countryid = 'US';

-- JOBTITLE이 'President'인 사람의 최소/최대 연봉
select minsal, maxsal
from job
where jobtitle = 'President';

-- LOCID가 1700번 이상인 부서의 이름
select *
from loc
where locid >= 1700;
```



##### and와 or 사용

```
-- deptid가 30이거나 40이거나 50일 때
select fname, email, phone
from emp
where deptid in (30,40,50);

혹은

select fname, email, phone
from emp
where deptid = 30
or deptid = 40
or deptid = 50;

-- EMPID 150 이상, 연봉 6000 이상
select *
from emp
where empid >= 150
and salary >= 6000;

----
select empid, fname, salary, hdate
from emp
where salary between 6000 and 9000
and hdate >= '2005-06-30';
```



##### like를 사용한 유사검색

```
-- fname이 A로 시작하는 데이터만
select empid, fname
from emp
where fname like 'A%';

-- e가 포함된 모든 데이터
select empid, fname
from emp
where lname like '%e%';

-- au로 시작하고 뒤에 4글자가 더 있는 사람
select empid, lname
from emp
where lname like 'au____';


★시험 문제 많이 나오는 것

-- 인센티브를 갖고 있지 않은 사람들의 데이터 (null값은 부등호로 가져오면 안됨!!!!!!)
select empid, fname, comm
from emp
where comm is null;

-- 인센티브를 갖고 있는 사람들의 데이터 (is not null = null이 아닌 데이터)
select empid, fname, comm
from emp
where comm is not null;


-- deptid가 50번이 아닌 사람들의 데이터
select empid, fname, deptid
from emp
where deptid != 50;

혹은

select empid, fname, deptid
from emp
where deptid <> 50;
```



##### 제한을 둬서 데이터 얻기

```
-- 내림차순으로 상위 5명
select empid, fname, salary
from emp
order by salary desc
limit 5;
```



##### 집계 함수(function)

> count, sum, min, max, avg, concat ...

```
select count(empid) 인원수
from emp;

---

select min(salary), max(salary)
from emp;

---

select avg(salary) 연봉평균
from emp
where deptid = 60;

---

select concat(concat(fname, ' is a '), jobid)
from emp;

--- 연결해주는 역할
select empid, fname, lname, concat(fname, ' ', lname) name
from emp;

--- 10칸에서 왼쪽에 빈만큼 *로 채워줌 (rpad는 오른쪽)
select lpad(fname, 10, '*') 
from emp;

--- substring으로 하나씩 쪼개서 2번부터 3개 출력
select substr(fname, 2, 3)
from emp;

--- 올림, 반올림, 내림
select ceil(9.1), round(4.6), floor(3.9);

--- 소수점 첫재짜리까지만
select round(avg(salary),1) 연봉평균
from emp
where deptid = 50;

--- 날짜 포맷
select fname, date_format(hdate, '%Y/%M/%d')
from emp;

--- char형으로 변환
select fname, cast(salary as char) from emp;

-- FORMAT() : 숫자를 소수점 아래 자리까지 표시. 1000단위마다 , 붙여줌
select format(12345.12345, 4);

-- 2진수, 16진수, 8진수
select BIN(31), HEX(31), OCT(31);

-- 반복
select repeat('hello ', 5);

-- fname, e, xx
select replace(fname, 'e', 'xx') 이름
from emp;

-- 시간함수
select curdate(), curtime(), now(), sysdate();
-- 년도, 달, 월만 필요할 때
select year(curdate()), month(curdate()), dayofmonth(curdate());
```



##### Practice

```
-- emp테이블의 모든 레코드
select *
from emp;

-- 직원의 id가 158인 레코드의 fname,lname,phone 검색
select fname, lname, phone
from emp
where empid = 158;

-- fname이 'D'로 시작하는 직원의 id와 이름, 부서id 검색
select empid, fname, deptid
from emp
where fname like 'D%';

-- 부서번호가 30인 사원들의 사번과 fname, jobid, salary, deptid 출력
select empid, fname, jobid, salary, deptid
from emp
where deptid = 30;

-- comm이 0.2이상인 사원의 사번과 fname,comm 출력
select empid, fname, comm
from emp
where comm >= 0.2;

-- 입사일이 1999년 12월 31일 이후인 직원의 사원의 사번과 fname, 입사일 출력(입사일로 오름차순 정렬)
select empid, fname, hdate
from emp
where hdate = '1999-12-31'
order by hdate asc;

-- 부서번호가 20에서 50번 사이의 직원이름과 부서id를 검색 (부서id로 오름차순 정렬)
select fname, deptid
from emp
where deptid between 20 and 50
order by deptid asc;

-- 부서번호가 없는 직원의 id와 email, 이름 검색
select empid, email, fname
from emp
where deptid is null;

SELECT * FROM scott.emp;
SELECT * FROM scott.job;
-- jobid가 'ST_CLERK', 'SA_MAN', 'SA+REP'인 직원의 id와 이름, jobid
select empid, fname, jobid
from emp
where jobid = 'SA+REP'
or jobid = 'SA_MAN'
or jobid = 'SA+REP';

-- 전화번호가 650으로 시작하는 직원의 id와 이름, 부서id, 전화번호 검색
select empid, fname, deptid, phone
from emp
where phone like '650%';

-- comm이 null이 아닌 직원 중 그 값이 0,3 이상인 레코드(comm으로 정렬)
select *
from emp
where comm is not null
and comm between 0 and 3
order by comm;

-- 아래와 같은 형식으로 출력되도록 query 작성

-- 사번		설명
-- 101	Steven King IS A IT_PROG
select empid 사번, concat(fname, ' ', lname, ' IS A ', jobid) 설명
from emp;

-- salary가 높은 상위 5명
select *
from emp
order by salary desc
limit 5;

-- 입사일 순으로 사원 정보 정렬(오래된 순)
select *
from emp
order by hdate;

-- 부서 id가 40번이 아닌 부서에 속한 직원들 중 salary가 8000 이상인 레코드
select *
from emp
where deptid != 40
and salary >= 8000;

-- empid, fname, salary, 10% 증가된 salary(새연봉) 새연봉 순으로 정렬
select empid, fname, salary, salary*1.1 새연봉
from emp
order by 새연봉 desc;


-- hdate가 '2005-02-15'에서 '2006-12-31' 사이의 레코드 (사번,이름,전화번호)
select empid, fname, phone
from emp
where hdate between '2005-02-15' and '2006-12-31';
```





##### group화 시키기

```
select avg(salary), deptid
from emp
group by deptid;
```



##### group by 문제는 무조건 나옴★

### 데이터베이스(4.11)

---

##### switch 문 활용

```
select case 2
when 1 then 'class-1'
when 2 then 'class-2'
when 3 then 'class-3'
else 'other'
end result;

----

select deptid, case deptid
when 30 then 'seattle'
when 40 then 'Newyork'
when 50 then 'LA'
else 'Washington'
end address
from emp;


--- null 같은 경우에는 형태가 약간다름 (case 뒤에 값 안붙임)
select empid, 
case
	when comm is null then '없음'
	else comm
end comm
from emp;

--- ifnull 함수 활용
select empid, ifnull(comm, '없음') comm
from emp;


-- group by
-- 부서번호가 50이상인 데이터 대상으로 업무별로 구분해서 업무별 연봉 평균, 인원수
-- 연봉평균으로 내림차순 정렬, 별칭 '연봉평균', 소수점 2번째자리에서 반올림

select jobid 업무, round(avg(salary),1) '연봉평균', count(*) 인원수
from emp
where deptid >= 50
group by jobid
having count(jobid) >= 10
order by 연봉평균 desc;
```



##### Update

```
-- update
update emp
set salary = 12000
where empid = 300;

-- 여러개

update emp
set salary = 15000,
comm = 0.3,
deptid = 30
where empid = 300;
```



##### Delete

```
-- delete
delete from emp
where empid = 300;
```



##### 한번 더 체크할 내용

> insert는 into로 시작하고 values를 통해 값 넣음
>
> update는  set으로 설정
>
> delete는 from으로 sql문과 where로 특정 부분 지정



#### DDL(데이터 정의어)

|  데이터 타입  |                정의                |
| :-----------: | :--------------------------------: |
| VARCHAR(size) |  **가변 길이** 문자열 타입(1~255)  |
|  CHAR(size)   | **고정 길이** 문자열 타입(1~65535) |
|     DATE      |            날짜와 시간             |
| INT(INTEGER)  |            -21억 ~ 21억            |
|   LONGTEXT    |    최대 4GB의 문자 데이터 타입     |
|     FLOAT     |       소수점 7자리까지 표현        |
| REAL, DOUBLE  |       소수점 15자리까지 표현       |
|     JSON      |         JSON 형식의 데이터         |



##### 제약 조건

- PK(Primary Key)
- FK(Foreign Key)
- (NOT)NULL
- DEFAULT
- UNIQUE



##### 키(Key)

| 학번 | 이름 | 주소 | 이메일 | 주민번호 |
| :--: | :--: | :--: | :----: | :------: |
|      |      |      |        |          |

- 수퍼 키

  > 모든 튜플에 대해 **유일성(unique)는 만족하지만, 최소성은 만족하지 못함**
  >
  > ex. 학생 정보에서 학번, 주민번호와 같이 식별 가능한 것이 2개 이상일 수도 있음

- 후보 키

  > 최소한의 수퍼키, 유일성과 최소성을 모두 만족하는 것

- 대체 키

  > 후보키 중에 선정된 기본키를 제외한 나머지 후보키

- 기본 키(★)

  > 후보키 중에 특별히 선정된 키
  >
  > 중복된 값을 가질 수 없음
  >
  > 유일성과 최소성을 모두 가지며 식별을 위해 반드시 필요한 것
  >
  > NULL 값을 가질 수 없음
  >
  > 사용하는 그룹의 `대표성`을 띄어야 함

- 외래 키

  > 다른 릴레이션의 기본키를 참조하는 속성 혹은 집합
  >
  > 외래키는 참조 릴레이션의 기본키와 동일한 키 속성을 가짐



```
즉, 학생들을 식별 가능한 '학번'과 '주민번호'는 후보키다.
기본키로 학번을 선택했으면 주민번호는 대체키가 된다.
```



##### 테이블 생성(CREATE)

```
-- create table
create table test(id int(1) primary key,
name varchar(10) not null);

insert into test values(1, 'dada');
insert into test values(2, 'tommy');

select * from test;
```

id 값을 기본키로 주었기 때문에, 중복되는 id값을 insert 하려고하면 들어가지 않는다.



##### 테이블 수정(ALTER)

```
-- alter table
alter table test
add tel varchar(10); -- 새 컬럼 추가

-- modify column
alter table test
modify tel varchar(11); -- 컬럼 크기 수정

alter table test
drop tel; -- 컬럼 삭제

desc test;
```

##### 기본키 설정

```
-- pk 추가
alter table emp
add constraint pk_emp
primary key(empid);

(constraint는 보통 제약조건_테이블 이름으로 설정)
```



##### 외래키 설정 연습

```
-- member 테이블 생성
create table member(mid int(1) primary key,
name varchar(10) not null,
address varchar(20) not null);

insert into member values(1, "김규석", "서울특별시 강남구 역삼동");

-- orders 테이블 생성
create table orders(oid int(1) auto_increment primary key,
odate datetime,
mid int(1));

-- orders 테이블에 외래키 지정
alter table orders
add constraint fk_orders foreign key(mid)
references member(mid);
```



##### 외래키가 지정된 상태에서 값 넣어보기

```
insert into member values(111, 'jane', 'la'), (222, 'roy', 'seul');

member에 두가지 데이터를 넣었음
외래키로 참조하는 orders에 데이터 넣어보기

insert into orders values(null, now(), 111); // member에 mid 값 111이 있으므로 성공
insert into orders values(null, now(), 333); // 333은 없어서 실패. 추가할때는 부모 먼저

delete from member
where mid = 111; -- error. 삭제할때는 자식 먼저
```



##### Practice

```
create table east(
eid decimal(3) primary key,
name varchar(20));

create table west(
wid decimal(3) primary key,
wdate datetime not null,
eid decimal(3));

-- fk 지정
alter table west
add constraint fk_west foreign key(eid)
references east(eid)
on delete cascade;


-- pk, fk, not null, unique, default
create table south(
sid decimal(3) primary key,
code varchar(10) unique,
email varchar(20) unique,
points int(1) default 0,
grade varchar(20) default 'silver');

insert into south(sid, code, email) values(1, 111, 'abc'); -- ok
insert into south(sid, code, email) values(2, 111, 'abc'); -- duplicate
```

default로 제약조건을 걸어두면, insert시 값을 넣지 않아도 자동으로 지정된 값으로 들어간다.



```
-- 제약 조건 삭제 시
alter table west drop primary key;
alter table west drop foreign key fk_name;
```



#### join

> 기본 키와 왜래 키의 관계를 가진 컬럼을 소유하고 있는 테이블을 통한 검색시 사용

- CROSS JOIN
- INNER JOIN
- SELF JOIN
- OUTER JOIN

시험때 INNER JOIN인지  OUTER JOIN인지 잘 구별할줄 알아야함



##### inner join

```
-- inner join
-- 사번, 이름, 부서id, 부서명 --> emp, dept
select e.empid, e.fname, e.deptid, d.deptname
from emp e, dept d
where e.deptid = d.deptid
order by empid;

-- ansi 표준
select e.EMPID, e.FNAME, e.DEPTID, d.DEPTNAME
from emp e inner join dept d
on e.deptid = d.deptid
order by empid;


-- 사번, 이름, jobtitle
select e.EMPID, e.FNAME, e.JOBID, j.JOBTITLE
from emp e, job j
where e.jobid = j.jobid;

-- fname이 'Alexander'인 사람의 부서이름
select e.EMPID, d.DEPTNAME
from emp e, dept d
where fname = 'Alexander'
and e.deptid = d.deptid;


-- 부서 id, 부서이름, city
select d.deptid, d.deptname, l.CITY
from dept d, loc l
where d.locid = l.locid;

-- 부서 id와 부서명, 관리직원 이름
select e.DEPTID, d.DEPTNAME, e.fNAME
from emp e, dept d
where e.mgrid = d.mgrid;

-- 사번, 이름, 부서명, jobtitle
select e.empid, e.FNAME, d.DEPTNAME, j.JOBTITLE
from emp e, dept d, job j
where e.jobid = j.jobid
and e.deptid = d.deptid;



-- empid, fname, deptname, city, country
select e.empid, e.fname, d.deptname, l.city, l.countryid
from emp e, dept d, loc l
where e.deptid = d.deptid
and d.locid = l.locid;

-- ansi로 변경
select e.empid, e.fname, d.deptname, l.city, l.countryid
from emp e inner join dept d inner join loc l
on e.deptid = d.deptid
and d.locid = l.locid;


-- 매니저가 david인 emp 찾기
select e.fname, m.FNAME
from emp e, emp m
where e.mgrid = m.empid
and e.fname = 'David';
```



##### outer join

> 2개 이상의 테이블이 조인될 때 어느 한쪽의 테이블에는 해당하는 데이터가 존재하는데 다른 쪽의 테이블에는 데이터가 존재하지 않을 때 그 데이터는 출력되지 않는 문제를 해결하기 위해 사용되는 기법

```
-- outer join 
select e.empid, e.fname, e.deptid, d.deptname
from emp e left outer join dept d -- left에 있는 데이터가 null이라고 하더라도 다 나와야함
on e.deptid = d.deptid;
```

`left outer join` or `left join`



#### sub query

> sub 쿼리가 main 쿼리보다 먼저 실행
>
> sub 쿼리는 main 쿼리의 조건으로 사용
>
> ```
> select ...
> from ...
> where ( select ...
> 		from ...
> 		where ...)
> ```



##### 구분

- 서브 쿼리의 위치에 따라

  > 일반 서브쿼리 : select 리스트
  >
  > inline view : from 절
  >
  > nested 쿼리 : where 절

- 메인 쿼리와의 연관성에 따라

  > 연관성 없는 쿼리
  >
  > 연관성 있는 쿼리(join)

```
-- 사번이 120번인 사원과 같은 일을 하는 사원의 정보
select *
from emp
where jobid = (select jobid
			from emp
			where empid = 120);
			
-- 최소 연봉을 받는 사람의 이름
select fname
from emp
where salary = (select min(salary)
			from emp);
			
-- 사원번호가 116인 사람과 같은 jobid를 가진 사람들
select *
from emp
where jobid = (select jobid
				from emp
                where empid=116);

-- 평균 연봉보다 많은 연봉을 받는 사람들의 정보 (많이 받는 순으로 정렬)
select *
from emp
where salary > (select avg(salary)
			from emp)
order by salary desc;

-- 시애틀에 있는 부서id와 이름을 출력
select dept.DEPTID, dept.DEPTNAME
from dept
where dept.locid = (select loc.locid 
			from loc
			where loc.city = 'Seattle');

-- state 값이 null인 부서정보
select *
from dept
where dept.locid in (select loc.locid
				from loc
                where state is null);
```


