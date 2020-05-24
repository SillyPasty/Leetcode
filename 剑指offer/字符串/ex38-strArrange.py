# 考虑特殊情况!
# 画图 dfs

class Solution:
    def permutation(self, s):
        self.result = []
        lis = []
        for c in s:
            lis.append(c)
        
        def proc(lis, idx):
            if idx == len(lis):
                res = ""
                for c in lis:
                    res += c
                self.result.append(res)
                return
            for i in range(idx, len(lis)):
                tmp = lis[idx]
                lis[idx] = lis[i]
                lis[i] = tmp
                proc(lis[:], idx + 1)
        
        proc(lis[:], 0)
        return list(set(self.result))

def main():
    sol = Solution()
    string = "abc"
    print(sol.permutation(string))

main()
