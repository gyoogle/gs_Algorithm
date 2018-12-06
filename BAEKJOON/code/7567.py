#그릇
a = input();
a = list(a)
sum = 0
for i in range(len(a) -1):
    if(i==0):sum+=10
    if(a[i]==a[i+1]):
        sum+=5
    else: sum+=10
print(sum)