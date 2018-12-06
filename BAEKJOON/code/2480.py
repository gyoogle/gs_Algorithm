#주사위 세개
a = list(input().split())
a.sort()
if(a[0] == a[1] == a[2]): print(10000+int(a[0])*1000)
elif(a[0]==a[1] or a[1]==a[2]): print(1000+int(a[1])*100)
else: print(int(a[2])*100)