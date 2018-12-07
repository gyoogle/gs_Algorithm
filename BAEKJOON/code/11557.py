#올해의 양조장
uni = ""
al = 0
for i in range(int(input())):
    for j in range(int(input())):
        a, b = input().split()
        b = int(b)
        if al < b: 
            uni = a
            al = b
    print(uni)    