# 大顶堆用法！
import heapq
class Solution:
    def getLeastNumbers(self, arr, k):
        if not arr:
            return arr
        if k == 0:
            return []
        minHeap = []
        for i in arr:
            print(len(minHeap))
            if len(minHeap) < k:
                heapq.heappush(minHeap, (-1 * i))
            elif minHeap[0] < (- 1 * i):
                heapq.heapreplace(minHeap, (-1*i))
        return [i * -1 for i in minHeap]

def main():
    # arr = [3, 2, 1]
    # k = 2
    # sol = Solution()
    # print(sol.getLeastNumbers(arr, k))
    string = "asdasd"
    print(string[0])
    lis = [1, 2, 3, 4, 5]
    lis.insert(1, 123)
    print(lis)

main()