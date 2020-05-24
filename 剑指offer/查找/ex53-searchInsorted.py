class Solution:    
    def search(self, nums, target):

        def getMinK(nums, left, right, k):
            if left == right and nums[left] != k:
                return -1
            mid = (left + right) // 2
            if nums[mid] == k and (mid == 0 or nums[mid - 1] < k):
                return mid
            elif nums[mid] >= k :
                return getMinK(nums, left, mid, k)
            else:
                return getMinK(nums, mid + 1, right, k)
        
        def getMaxK(nums, left, right, k):
            if left == right and nums[left] != k:
                return -1
            mid = (left + right) // 2
            if nums[mid] == k and (mid == (len(nums) - 1) or nums[mid + 1] > k):
                return mid
            elif nums[mid] > k :
                return getMaxK(nums, left, mid, k)
            else:
                return getMaxK(nums, mid + 1, right, k)
        
        leftMin = getMinK(nums, 0, len(nums) - 1, target)
        rightMax = getMaxK(nums, 0, len(nums) - 1, target)
        if leftMin == -1:
            return 0
        else:
            return rightMax - leftMin + 1

def main():
    nums = [5,5, 5]
    target = 5
    sol = Solution()
    print(sol.search(nums, target))

main()