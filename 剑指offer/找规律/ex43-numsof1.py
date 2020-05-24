class Solution:
    def countDigitOne(self, n: int) -> int:
        def getCurDig(val, dig):
            val //= 10 ** (dig - 1)
            return val % 10
        
        def getDowner(val, dig):
            if dig == 1:
                return 0
            return val % 10 ** (dig - 1)
        
        def getUpper(val, dig):
            return val // 10 ** dig
        res = 0
        idx = 1
        while (n // (10 ** (idx - 1))) > 0:
            curDig = getCurDig(n, idx)
            downer = getDowner(n, idx)
            upper = getUpper(n, idx)
            if curDig == 1:
                res += (upper * (10 ** (idx - 1)) + downer + 1)
            elif curDig == 0:
                res += ((upper) * (10 ** (idx - 1)))
            else:
                res += ((upper + 1) * (10 ** (idx - 1)))
            idx += 1
            
        return res

def main():
    n = 11
    sol = Solution()
    print(sol.countDigitOne(n))

main()