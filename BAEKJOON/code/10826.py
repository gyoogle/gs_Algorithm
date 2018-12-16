#피보나치 수 4
'''
def fibonacci(n):
    if n < 2:
        return n
    return fibonacci(n-1) + fibonacci(n-2)
'''

def fibonacci(n):
    a, b = 1, 0
    for i in range(n):
        a, b = b, a + b
        print("a = {0}, b= {1}".format(a, b))
    return b
    
num = int(input())
print(fibonacci(num))