def nthUglyNumber(n: int) -> int:
        if not n:
            return n
        ugly = [0 for i in range(n)]
        ugly[0] = 1
        m2, m3, m5 = 0, 0, 0
        for i in range(1, n):
            cur = min(ugly[m2] * 2, ugly[m3] * 3, ugly[m5] * 5)
            ugly[i] = cur
            if ugly[m2] * 2 <= cur:
                m2 += 1
            if ugly[m3] * 3 <= cur:
                m3 += 1
            if ugly[m5] * 5 <= cur:
                m5 += 1
        return ugly[n - 1]

print(nthUglyNumber(10))