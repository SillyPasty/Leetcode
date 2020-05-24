class Solution:
    def strToInt(self, str: str) -> int:
        s = str.strip()
        sign = 1
        if not s:
            return 0
        if not (s[0] == "+" or s[0] == "-" or ("0" <= s[0] and s[0] <= "9")):
            return 0
        if s[0] == "-":
            sign = -1
            s = s[1:]
        elif s[0] == "+":
            s = s[1:]
        result = 0
        for i, c in enumerate(s):
            if i == 0 and not ("0" <= c and c <= "9"):
                return 0
            if not ("0" <= c and c <= "9"):
                break
            result = result * 10 + (int(c) - int("0"))
        maxInt = 1 << 31
        if sign == -1 and result > maxInt:
            return maxInt * -1
        if sign == 1 and result > maxInt - 1:
            return maxInt - 1
        return result * sign

def main():
    s = "-91283472332"
    sol = Solution()
    print(sol.strToInt(s))

main()