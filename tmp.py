x = 30
y = 20
def foo1(x):
    res = 225 * (x ** 2) - 10 * (x ** 3) + 1/8*(x**4)
    return res

def foo2(x):
    res = 125 * (x**2) - (10 / 3) * (x**3)
    return res

print(foo1(x) - foo1(y))
print(foo2(20))