import sys
class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        if n == 1:
            return 0
        cir = [x for x in range(n)]
        curIdx = -1
        for i in range(n - 1):
            for step in range(m):
                curIdx += 1
                curIdx %= n
                # 跳过删除
                while cir[curIdx] == -1:
                    curIdx += 1
                    curIdx %= n

            cir[curIdx] = -1
        for i in cir:
            if i != -1:
                return i

def main():
    n = 2
    m = 17
    sol = Solution()
    print(sol.lastRemaining(n, m))

# main()
print((1 << 31) - 1)
