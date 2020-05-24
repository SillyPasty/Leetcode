# 回溯法
class Solution:
    def exist(self, board, word):
        maxR = len(board)
        maxC = len(board[0])
        isVisited = [[0 for col in range(maxC)] for row in range(maxR)]

        for r in range(maxR):
            for c in range(maxC):
                if self.find(board, word, r, c, isVisited, 0):
                    return True
        return False

    def find(self, board, word, idxR, idxC, isVisited, pathLen):
        if pathLen == len(word):
            return True
        maxR = len(board)
        maxC = len(board[0])
        res = False
        if idxC >= 0 and idxR >= 0 and idxR < maxR and idxC < maxC \
            and board[idxR][idxC] == word[pathLen] and isVisited[idxR][idxC] == 0:
            pathLen += 1
            isVisited[idxR][idxC] = 1

            res = self.find(board, word, idxR + 1, idxC, isVisited, pathLen) or \
                    self.find(board, word, idxR - 1, idxC, isVisited, pathLen) or \
                    self.find(board, word, idxR, idxC + 1, isVisited, pathLen) or \
                    self.find(board, word, idxR, idxC - 1, isVisited, pathLen)
            if res == False:
                pathLen -= 1
                isVisited[idxR][idxC] = 0
        return res

def main():
    sol = Solution()
    borad = [["a","b"],["c","d"]]
    word = "abcd"
    print(sol.exist(borad, word))

main()