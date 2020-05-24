class Solution:
    def findNthDigit(self, n: int) -> int:
        if n == 0:
            return n
        dig = 1
        sums = 10
        while sums <= n:
            dig += 1
            sums += 9 * dig * (10 ** (dig - 1))
        n = n + 9 * dig * (10 ** (dig - 1)) - sums
        # if dig == 1:
        #     n += 1
        times = n % dig
        n = n // dig
        
        result = ((n + (10 ** (dig - 1))) // (10 **(dig - times - 1))) % 10
        return int(result)

def main():
    n = 1001
    sol = Solution()
    print(sol.findNthDigit(n))

main()