#TGN
for i in range(int(input())):
    a,b,c = map(int, input().split())
    
    if (b-c) == a: print("does not matter")
    elif b-c > a: print("advertise")
    else: print("do not advertise")