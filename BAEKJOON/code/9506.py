#약수들의 합
def testing(num):
    a = []
    cnt = 1
    sum = 0
    while int(num/cnt) != 0:
        if(num%cnt ==0):
            a.append(cnt)
            cnt +=1
        else:
            cnt += 1 
    for i in range(len(a)-1):
        sum += a[i]
    if(a[len(a)-1] == sum):
        x = []
        z = 0
        x.append(a[len(a)-1])
        x.append(" = ")
        while(z != len(a)-1):
            x.append(a[z])
            z += 1
            if(z != len(a)-1):
                x.append(" + ")
        x = list(map(str, x))
        total = ""
        for i in range(len(x)):
            total += x[i]
        return print(total)
    else: return print("{0} is NOT perfect.".format(num))

while 1:
    k = int(input())
    if(k== -1):break
    testing(k)