#오븐 시계
h, m1 = map(int, input().split())
m2 = int(input())

m = m1+m2

if (m >= 60):
    z = int(m/60)
    h += z
    if(h >= 24):
        h -= 24
    m -= 60*z
    print("{0} {1}".format(h, m))
else:
    print("{0} {1}".format(h, m))