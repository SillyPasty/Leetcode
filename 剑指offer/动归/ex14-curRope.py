# dp and 贪婪
class Solution:
    def cuttingRope(self, n):
        res = [0, 0, 1, 2]
        if n <= 3:
            return res[n]
        res = [0, 1, 2, 3]
        for i in range(4, n+1):
            maxi = 0
            for j in range (1, i // 2 + 1):
                maxi = res[j] * res[i - j] if res[j] * res[i - j] > maxi else maxi
            res.append(maxi)
        return res[n]
    
    def cuttingRope1(self, n):
        res = [0, 0, 1, 2, 4]
        if n < 5:
            return res[n]
        x = n // 3
        y = n % 3
        if y == 1:
            x -= 1
            y += 3
        if y == 0:
            y = 1
        ans =(((3 ** x) * y) % int(1e9+7))
        return ans



def main():
    x = 2.0
    e = -2
    print(x**e)
    # n = 10
    # sol = Solution()
    # print(sol.cuttingRope1(120))

main()