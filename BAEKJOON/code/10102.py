#개표
num = int(input())
vote = list(input())
a = 0
b = 0
for i in range(len(vote)):
    if vote[i] == 'A': a+=1
    elif vote[i] == 'B': b+=1

if a > b: print("A")
elif a == b: print("Tie")
else: print("B")