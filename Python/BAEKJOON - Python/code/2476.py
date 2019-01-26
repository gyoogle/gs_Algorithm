#주사위 게임
value = 0
total = 0
for i in range(int(input())):
    a = list(input().split())
    a.sort()
    if(a[0] == a[1] == a[2]): value = 10000+int(a[0])*1000
    elif(a[0]==a[1] or a[1]==a[2]): value = 1000+int(a[1])*100
    else: value = int(a[2])*100
    
    if(total < value) : total = value

print(total)