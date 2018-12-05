def divide(a,b):
    return a / b

try:
    c = divide(5, 'string')
except ZeroDivisionError:
    print('분모가 0이면 안됩니다')
except TypeError:
    print('인자는 숫자여야 합니다')
except:
    print('또다른 이유로 발생한 에러')
else:
    print('Result: {0}'.format(c))
finally:
    print('무조건 실행')