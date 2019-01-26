class NegativeDivisionError(Exception):
    def __init__(self, value):
        self.value = value
def positiveDivide(a,b):
    if(b < 0):
        raise NegativeDivisionError(b)
    return a/ b

try:
    ret = positiveDivide(10, -3)
    print('10/ 3 = {0}'.format(ret))
except NegativeDivisionError as e:
    print('Error - Second argument of PositiveDivide is', e.value)
except ZeroDivisionError as e:
    print('Error -', e.args[0])