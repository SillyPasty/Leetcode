def swap(lis, l, r):
    tmp = lis[l]
    lis[l] = lis[r]
    lis[r] = tmp

def part(lis, start, end):
    mid = (end + start) // 2
    flg = lis[mid]

    swap(lis, mid, end)

    l = start
    r = end - 1
    while 1:
        while l < end and lis[l] <= flg:
            l += 1
        while lis[r] > flg:
            r -= 1
        if r <= l:
            break
        swap(lis, l, r)

    swap(lis, l, end)
    return l

# def qSort(lis, start, end):
#     if end - start <= 0:
#         return
#     mid = part(lis, start, end)
#     qSort(lis, start, mid - 1)
#     qSort(lis, mid + 1, end)

def partition(lis, start, end):
    mid = (end + start) // 2
    flg = lis[mid]
    swap(lis, mid, end)
    l = start
    r = end - 1
    while l < r:
        while l < end and lis[l] <= flg:
            l += 1
        while lis[r] > flg:
            r -= 1
        if r <= l:
            break
        swap(lis, l, r)
    
    swap(lis, l, end)
    return l

def qSort(lis, start, end):
    if start >= end:
        return
    idx = partition(lis, start, end)
    qSort(lis, start, idx - 1)
    qSort(lis, idx + 1, end)
    

def main():
    zeroont = [1, 0]
    lis = [0,0,2,3,3,5,6,0,3,4,4,4,3,0,9,14,4,17,6,4,10,18,21,13,8,4,12,6,19,11,8,12,14,7,16,34,19,18,15,14,22,41,32,23,27,37,2,30,14,12,23,41,39,2,21,32,22,1,12,25,6,46,7,61,13,64,54,56,29,41,51,2,9,65,17,28,34,41,1,62,23,14,60,14,22,17,67,86,81,45,78,9,27,17,30,54,35,42,72,94]
    qSort(lis, 0, len(lis) - 1)
    print(lis)

main()
