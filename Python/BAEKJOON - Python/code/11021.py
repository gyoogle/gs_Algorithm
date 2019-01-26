# 덧셈 여러개 출력
case = int(input())
value = []
for i in range(case):
    a, b = map(int, input().split())
    value.append(a+b)

for i in range(case):
    print("Case #{0}: {1}".format(i+1, value[i]))