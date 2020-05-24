import time
x = 50000000
startTime = time.time()
lis = []
for i in range(x):
    lis += [i]
times1 = time.time()
print("+= time" + str(times1 - startTime))

lis = []
for i in range(x):
    lis.append(i)
times2 = time.time()
print("+= time" + str(times2 - times1))

lis = []
for i in range(x):
    lis.insert(-1, i)
times3 = time.time()

print("+= time" + str(times3 - times2))
