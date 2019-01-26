#알람 시계
h,m = map(int, input().split())

total = h*60 + m - 45

if(total < 0):
    h=23
    total += 60
    print("{0} {1}".format(h, total))
else: print("{0} {1}".format(int(total/60), total%60))