L = [1,2,3,4,5,6,7,8,9]
print("---break---")
for i in L:
    if i > 5:
        break
    print("Item:{0}".format(i))

print("---continue---")
for i in L:
    if i%2 == 0:
        continue
    print("Item:{0}".format(i))