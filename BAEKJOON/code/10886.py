#cute
l = []
one = 0
zero = 0
for i in range(int(input())):
    a = input()
    l.append(a)

for i in range(len(l)):
    if l[i]=='1': one+=1
    elif l[i]=='0': zero+=1

if(one > zero): print("Junhee is cute!")
else: print("Junhee is not cute!")