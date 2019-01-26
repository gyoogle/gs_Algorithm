# 소음
a = int(input())
b = input()
c = int(input())

if b=='+': 
    if len(str(a+c)) <= 100:
        print(a+c)
if b=='*': 
    if len(str(a*c)) <= 100:
        print(a*c)


# len은 int형에서 사용할 수 없다. (str로 바꿔서 사용)