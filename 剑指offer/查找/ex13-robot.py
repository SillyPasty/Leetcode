# 回溯法
class Solution:
    def movingCount(self, m, n, k):
        isVisited = [[0 for col in range(n)] for row in range(m)]
        res = self.find(0, 0, k, isVisited, m, n)
        return res

    def find(self, idxR, idxC, thersh, isVisited, m, n):
        sums = 0
        r = idxR
        c = idxC
        while r > 0:
            sums += r % 10
            r = r // 10
        
        while c > 0:
            sums += c % 10
            c = c // 10
        res = 0
        if idxR >= 0 and idxC >= 0 and idxR < m and idxC < n and \
            sums <= thersh and isVisited[idxR][idxC] == 0:
            isVisited[idxR][idxC] = 1
            res += 1
            res = res + self.find(idxR + 1, idxC, thersh, isVisited, m, n) + \
                        self.find(idxR - 1, idxC, thersh, isVisited, m, n) + \
                        self.find(idxR, idxC + 1, thersh, isVisited, m, n) + \
                        self.find(idxR, idxC - 1, thersh, isVisited, m, n)
        return res


def main():
    m, n, k = (3, 1, 0)
    sol = Solution()
    print(sol.movingCount(m, n, k))

main()