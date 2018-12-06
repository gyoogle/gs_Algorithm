#최소공배수
for i in range(int(input())):
    a, b = map(int, input().split())
    if(a>b): a, b = b, a #swap
    if(a == 1): print(b)
    elif(b%a == 0): print(b)
    n = 1
    k = b
    while(b%a != 0):
        n += 1
        b *=n
        if(b%a == 0):
            print(b)
            break
        b = k