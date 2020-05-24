# 化繁为简，通过人工选择减少干扰
def twoDimSearch(nums, target):
    maxR = len(nums)
    maxC = len(nums[0])
    r = 0
    c = maxC - 1
    while (0 <= c and r <= maxR - 1):
        cur = nums[r][c]
        if cur == target:
            return True
        if cur > target:
            c -= 1
        else:
            r += 1
    return False

def main():
    nums = [[1, 2, 8, 9],
            [2, 4, 9, 12],
            [4, 7, 10, 13],
            [6, 8, 11, 15]]
    target = 200
    result = twoDimSearch(nums, target)
    print(result)

main()