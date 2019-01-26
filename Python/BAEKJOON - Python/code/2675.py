#문자열 반복
for i in range(int(input())):
    a = input().split()
    for j in range(len(a[1])):
        print(a[1][j] * int(a[0]), end='')
    print()