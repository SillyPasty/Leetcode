x = 30
y = 20
def foo1(x):
    res = 225 * (x ** 2) - 10 * (x ** 3) + 1/8*(x**4)
    return res

def foo2(x):
    res = 125 * (x**2) - (10 / 3) * (x**3)
    return res

def octal_int(s):
    if len(s) == 1:
        return int(s[0])
    else:
        return 8 * octal_int(s[:-1]) + int(s[-1])


print(octal_int('3'))
