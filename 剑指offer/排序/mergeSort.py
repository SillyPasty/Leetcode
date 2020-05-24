# def part(lis):
#     if not len(lis):
#         return
#     if len(lis) == 1:
#         return lis
#     mid = len(lis) // 2
#     lis = part(lis[:mid]) + part(lis[mid:])
#     return join(lis[:mid], lis[mid:])

# def join(lisl, lisr):
#     lis = []
#     idxl, idxr = 0, 0
#     while idxl < len(lisl) and idxr < len(lisr):
#         if lisl[idxl] < lisr[idxr]:
#             lis.append(lisl[idxl])
#             idxl += 1
#         else:
#             lis.append(lisr[idxr])
#             idxr += 1

#     if idxl < len(lisl):
#         lis += lisl[idxl:]
#     if idxr < len(lisr):
#         lis += lisr[idxr:]
    
#     return lis





def merge(lisl, lisr):
    maxL = len(lisl)
    maxR = len(lisr)
    l, r = 0, 0
    lis = []
    while l < maxL and r < maxR:
        if lisl[l] < lisr[r]:
            lis.append(lisl[l])
            l += 1
        else:
            lis.append(lisr[r])
            r += 1
    if l < maxL:
        lis += lisl[l:]
    if r < maxR:
        lis += lisr[r:]
    return lis

def part(lis):
    if len(lis) is None:
        return
    if len(lis) == 1:
        return lis
    mid = len(lis) // 2
    lis = part(lis[:mid]) + part(lis[mid:])
    res = merge(lis[:mid], lis[mid:])
    return res

def main():
    lis = [7, 5, 6, 4]
    print(part(lis))

main()