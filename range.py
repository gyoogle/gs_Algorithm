a = list(range(10))
print(a)

b = list(range(5,10))
print(b)

c = list(range(10,20,2))
print(c)

L = [1,2,3,4,5]
print([i**2 for i in L])


print("----filter----")
def getBiggerThan20(i):
    return i > 20

K = [10, 25, 30]
IterK = filter(getBiggerThan20, K)
for i in IterK:
    print("Item:{0}".format(i))