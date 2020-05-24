# dp ......

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic = {}
        if not s:
            return 0
        lis = [0 for r in range(len(s))]
        lis[0] = 1
        headIdx = 0
        tailIdx = 0
        maxSub = 1
        
        for i, c in enumerate(s):
            if i == 0:
                dic[c] = i
                headIdx += 1
                continue
            if dic.get(c) == None or dic.get(c) < tailIdx:
                pass
            else:
                tailIdx = dic.get(c) + 1
            headIdx += 1
            dic[c] = i
            maxSub = max((headIdx - tailIdx), maxSub)
        return maxSub

def main():
    sol = Solution()
    nums = "bbbbb"
    strs = "abcabcbb"
    print(sol.lengthOfLongestSubstring(nums))

main()