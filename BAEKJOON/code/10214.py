#baseball
yonsei = 0
korea = 0
for i in range(int(input())):
    for i in range(9):
        a,b = map(int, input().split())
        yonsei += a
        korea += b

    if yonsei > korea : print("Yonsei")
    elif yonsei == korea : print("Draw")
    else : print("Korea")