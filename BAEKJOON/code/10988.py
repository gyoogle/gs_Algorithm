#팰린드롬
def pal(k):
    for i in range(int(len(k)/2)):
        if k[i]!=k[len(k)-(i+1)]: 
            print(0) 
            exit()
    print(1)

a = input()
pal(a)