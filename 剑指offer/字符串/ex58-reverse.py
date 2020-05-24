class Solution:
    def reverseWords(self, s: str) -> str:
        slist = s.split(" ")
        slist.reverse()
        res = ""
        print(slist)
        for s in slist:
            if s != " ":
                res += s
                res += " "
        res = res.strip()
        return res
def main():
    sol = Solution()
    s = "the sky  is blue"
    print(s.split(" ").reverse())
    print(sol.reverseWords(s))

main()