#할 수 있다
num = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
a = list(map(str, input().split()))

for i in range(len(a[0])):
    for j in range(10):
        if a[0][i] == num[j]: 
            a = a[0][:len(a[0]-1)-i] + (a[0][i]) + a[0][i:]
    print(a)

for i in range(len(a[0])):
    if(a[0][0] or a[0][len(a[0] -1)] == "+" or "-" or "*" or "/"):
        print(a[0][0], a[0][len(a[0] -1)])
        print("ROCK")
        break
    else: print("possible")