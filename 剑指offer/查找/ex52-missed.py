class Solution:
    def missingNumber(self, nums):
        if nums[0] == 0 and len(nums) == 1:
            return 1
        if nums[0] == 1:
            return 0
        

        def getMissed(nums, left, right):
            if left == right:
                if left == 0:
                    return 0
            if (right - left == 1) and (nums[right] - nums[left] != 1):
                return nums[left] + 1
            if (right - left == 1) and (nums[right] - nums[left] == 1):
                return nums[right] + 1
            mid = (left + right) // 2
            if mid == nums[mid]:
                return getMissed(nums, mid, right)
            else:
                return getMissed(nums, left, mid)
        
        x = getMissed(nums, 0, len(nums) - 1)
        return x

def main():
    nums = [1]
    sol = Solution()
    print(sol.missingNumber(nums))

main()