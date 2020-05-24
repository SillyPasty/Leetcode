class Solution:
    def firstUniqChar(self, s: str) -> str:
        dic = {}
        for idx, c in enumerate(s):
            if dic.get(c) == None:
                dic[c] = idx
            else:
                dic[c] = -1
        ch = " "
        minIdx = len(s)
        for k, v in dic.items():
            if v != -1 and v < minIdx:
                ch = k
                minIdx = v
        return ch

def main():
    sol = Solution()
    s = "aa"
    print(sol.firstUniqChar(s))

main()