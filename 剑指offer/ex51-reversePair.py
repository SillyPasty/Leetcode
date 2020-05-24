class Solution:
    def reversePairs(self, nums) -> int:
        self.result = 0

        def merge(lisl, lisr):
            lis = []
            idxl, idxr = 0, 0
            while idxl < len(lisl) and idxr < len(lisr):
                if lisl[idxl] <= lisr[idxr]:
                    lis.append(lisl[idxl])
                    idxl += 1
                    self.result += idxr
                else:
                    lis.append(lisr[idxr])
                    idxr += 1
            while idxl < len(lisl):
                lis.append(lisl[idxl])
                idxl += 1
                self.result += idxr
            while idxr < len(lisr):
                lis.append(lisr[idxr])
                idxr += 1
            return lis

        def part(lis):
            if not len(lis):
                return
            if len(lis) == 1:
                return lis
            mid = len(lis) // 2
            lis = part(lis[:mid]) + part(lis[mid:])
            return merge(lis[:mid], lis[mid:])
        
        part(nums)
        return self.result
    
def main():
    sol = Solution()
    n = [5, 6, 4]
    print(sol.reversePairs(n))

main()