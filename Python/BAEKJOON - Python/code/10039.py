#평균 점수
sum = 0
for i in range(5):
    a = int(input())
    if a <  40: a=40
    sum += a
print(int(sum/5))