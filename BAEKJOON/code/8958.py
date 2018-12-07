#OX퀴즈
for i in range(int(input())):
    a = list(input())
    cnt = sum = 0

    for i in range(len(a)):
        if(a[i]=="O"): sum+=1
        if(i>0):
            if(a[i-1] == a[i] == "O"): 
                cnt+=1
                sum += cnt
            else: cnt = 0

    print(sum)