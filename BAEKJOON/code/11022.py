# 덧셈 여러개 출력
case = int(input())
value = []
for i in range(case):
    a, b = map(int, input().split())
    print("Case #{0}: {1} + {2} = {3}".format(i+1, a, b, a+b))