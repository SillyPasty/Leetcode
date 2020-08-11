#coding=utf-8
# 本题为考试多行输入输出规范示例，无需提交，不计分。
import sys
if __name__ == "__main__":
    # 读取第一行的n
    n = int(sys.stdin.readline().strip())
    ans = 0
    fib_dic = {}
    x1 = 1
    x2 = 1
    for i in range(100):
        fib_dic[x1] = 1
        tmp = x2
        x2 = x1 + x2
        x1 = tmp
    for i in range(n):
        # 读取每一行
        line = sys.stdin.readline().strip()
        value = int(line)
        if fib_dic.get(value) == None:
            ans += 1
    print(ans)