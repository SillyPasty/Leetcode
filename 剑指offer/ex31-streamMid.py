class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.leftBigHeap = []
        self.rightSmallHeap = []
        self.curMid = []
    
    def checkOver(self):
        if len(self.curMid) == 3:
            self.curMid.sort()
            heapq.heappush(self.leftBigHeap, self.curMid[0] * -1)
            heapq.heappush(self.rightSmallHeap, self.curMid[-1])
            self.curMid.pop()
            self.curMid.pop(0)

    def addNum(self, num: int) -> None:
        if not(self.leftBigHeap):
            self.curMid.append(num)
        else:
            val = num
            if num < (self.leftBigHeap[0] * -1):
                val = self.leftBigHeap[0] * -1
                heapq.heappop(self.leftBigHeap)
                heapq.heappush(self.leftBigHeap, num * -1)
            elif num > (self.rightSmallHeap[0]):
                val = self.rightSmallHeap[0]
                heapq.heappop(self.rightSmallHeap)
                heapq.heappush(self.rightSmallHeap, num)
            self.curMid.append(val)
        self.checkOver()



    def findMedian(self) -> float:
        if not self.curMid:
            return None
        return sum(self.curMid) / len(self.curMid)



# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()