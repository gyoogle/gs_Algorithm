# 최대공약수 - 최소공배수

#최대 공약수
def gcd(a, b):
    while(b != 0):
        temp = a%b
        a = b
        b = temp
    return abs(a)

#최소 공배수
def lcm(a,b):
    gcd_value = gcd(a,b)
    if (gcd_value == 0): return 0
    return abs( (a*b) / gcd_value)

#test
print(lcm(4, 6))
print(lcm(21,6))
print(lcm(-5,-4))

#숫자 3개 최소 공배수
result = lcm(45, lcm(120, 75))
print(result)