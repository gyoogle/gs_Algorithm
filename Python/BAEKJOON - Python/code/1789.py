num = int(input())

def sumNum(num):
    n = 1
    while 1:
        if ((n*(n+1))/2 > num):
            return print(n-1)
            break
        else:
            n += 1

sumNum(num)