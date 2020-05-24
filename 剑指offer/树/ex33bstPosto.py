# 递归加self!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
class Solution:
    def verifyPostorder(self, postorder):
        if not postorder:
            return True
        rootIdx = len(postorder) - 1
        rootVal = postorder[-1]
        rightTreeStart = 0
        for s in range(1, rootIdx + 1):
            if postorder[rootIdx - s] < rootVal:
                rightTreeStart = rootIdx - s + 1
                break
        
        for s in range(0, rightTreeStart):
            if postorder[s] > rootVal:
                return False
        
        return self.verifyPostorder(postorder[0:rightTreeStart]) and self.verifyPostorder(postorder[rightTreeStart:-1])

def main():
    lis = [1, 2, 3, 4]
    print(lis[1:-1])

main()