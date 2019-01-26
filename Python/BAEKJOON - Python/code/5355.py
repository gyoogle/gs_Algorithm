#화성 수학
for i in range(int(input())):
    x = input().split()
    num = float(x[0])
    for i in x[1:]:
        if i=='@': num *= 3
        if i=='%': num += 5
        if i=='#': num -= 7
    print("{0:.2f}".format(num))