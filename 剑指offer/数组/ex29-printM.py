# 分析所有可能性
# 异常情况分析，注意变量值

def spiralOrder(matrix):
        if not (matrix and matrix[0]):
            return []
        maxR = len(matrix)
        maxC = len(matrix[0])
        if not (maxR and maxC):
            return []
        rStride = maxC
        cStride = maxR - 1
        res = []
        ori = 0
        x, y = (0, -1)
        while (rStride != 0 and ori % 2 == 0) or (cStride != 0 and ori % 2 == 1):
            if ori % 4 == 0:
                for s in range(0, rStride):
                    y += 1
                    res += [matrix[x][y]]  
                rStride -= 1
            elif ori % 4 == 1:
                for s in range(0, cStride):
                    x += 1
                    res += [matrix[x][y]]
                cStride -= 1
            elif ori % 4 == 2:
                for s in range(0, rStride):
                    y -= 1
                    res += [matrix[x][y]]
                rStride -= 1
            else:
                for s in range(0, cStride):
                    x -= 1
                    res += [matrix[x][y]]
                cStride -= 1
            ori += 1
        return res

def main():
    inputs = [[1,2,3],[4,5,6],[7,8,9]]
    print(spiralOrder(inputs))

main()