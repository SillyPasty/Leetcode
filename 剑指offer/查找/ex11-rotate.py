# binary search: 将整个情况划分为两种！！
# 边界判断：相等情况！
def minArray(numbers):
    l = 0
    r = len(numbers) - 1
    if numbers[l] == numbers[r]:
        minimum = numbers[0]
        for i in numbers:
            minimum = minimum if minimum < i else i
        return minimum
    if numbers[l] < numbers[r]:
        return numbers[l]
    mid = (l + r) // 2
    while l < r:
        if r - l == 1:
            return min(numbers[l], numbers[r])
        if numbers[l] > numbers[mid]:
            r = mid
        else:
            l = mid
        mid = (l + r) // 2
    return numbers[l]

def main():
    a = [1, 2, 3, 4, 5]
    b = [2,0,1,1,1]
    print(minArray(a))
    print(minArray(b))

main()
