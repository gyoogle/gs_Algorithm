#소인수분해
a = int(input())
while a > 1:
    cnt = 2
    if a%cnt != 0 :
        while a%cnt != 0: cnt += 1
        a /= cnt
        print(cnt)
    else:
        a /= cnt
        print(cnt)