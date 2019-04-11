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
