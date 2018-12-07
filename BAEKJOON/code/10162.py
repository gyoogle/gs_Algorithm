#전자레인지
a = 300
b = 60
c = 10
t = int(input())
if(t%10 != 0): print(-1)
else:print("{0} {1} {2}".format(int(t/a), int((t%a)/b), int(((t%a)%b)/c)))