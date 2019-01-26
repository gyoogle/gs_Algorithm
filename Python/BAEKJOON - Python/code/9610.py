#사분면
q1 = 0
q2 = 0
q3 = 0
q4 = 0
axis = 0
for i in range(int(input())):
    a, b = map(int, input().split())
    if(a == 0 or b == 0) : axis+=1
    elif(a > 0 and b > 0) : q1+=1
    elif(a < 0 and b > 0) : q2+=1
    elif(a < 0 and b < 0) : q3+=1
    elif(a > 0 and b < 0) : q4+=1

print("Q1: {0}\nQ2: {1}\nQ3: {2}\nQ4: {3}\nAXIS: {4}".format(q1, q2, q3, q4, axis))