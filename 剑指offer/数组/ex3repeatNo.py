# 时间换空间？ 空间换时间？ hashmap O(1)
def findRepeatNum(num):
    for i, j in enumerate(num):
        if j == num[j] and i != j:
            return j
        num[i] = num[j]
        num[j] = j


def main():
    ex1 = [2, 3, 1, 2, 5, 3]
    result = findRepeatNum(ex1)
    print(result)

main()