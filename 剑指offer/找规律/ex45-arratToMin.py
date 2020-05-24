import functools
def minNumber(nums):
    def sortFunc(a, b):
        if a + b < b + a:
            return -1
        elif a + b == b + a:
            return 0
        return 1

    strList = []
    for i in nums:
        strList.append(str(i))
    strList = sorted(strList, key = functools.cmp_to_key(sortFunc))
    result = ""
    for s in strList:
        result += s
    return result

def main():
    # sol = Solution()
    nums = [3,30]
    print(minNumber(nums))

main()