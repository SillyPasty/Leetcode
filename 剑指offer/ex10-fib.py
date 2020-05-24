def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    res = [1, 1]
    for i in range(2, n+1):
        res.append(res[i - 1] + res[i - 2])
    return res[n]

print(fib(2))
print(fib(7))