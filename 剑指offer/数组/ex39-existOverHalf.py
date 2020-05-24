class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if not nums:
            return None
        res = nums[0]
        flg = 0
        for i in range(len(nums)):
            if flg == 0:
                flg = 1
                res = nums[i]
            elif nums[i] == res:
                flg += 1
            else:
                flg -= 1
        
        return res