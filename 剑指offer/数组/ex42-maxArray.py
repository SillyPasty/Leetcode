def maxSubArray(nums):
        maxSum = nums[0]
        curSum = 0
        for i in nums:
            if curSum < 0:
                curSum = i
            else:
                curSum += i
            maxSum = curSum if curSum > maxSum else maxSum
            
        return maxSum

arrs = [-1, 0, 1, -2, 5, -5]
print(maxSubArray(arrs))