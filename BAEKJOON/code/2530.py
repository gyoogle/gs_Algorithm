#인공지능 시계
h, m, s = map(int, input().split())
a = int(input())

total = h*3600 + m*60 + s
total += a

h1 = int(total/3600)
m1 = int((total%3600)/60)
s1 = (total%3600)%60

if(h1 >= 24):
    h1 = h1%24
 
print("{0} {1} {2}".format(h1, m1, s1))