def isNumber(self, s: str) -> bool:
    # remove space
    s = s.strip()
    flag = False
    idx = 0
    if not idx < len(s):
        return False
    # Scan sign
    if s[idx] == '-' or s[idx] == '+':
        idx += 1
    if not idx < len(s):
        return False
    # Scan int
    while idx < len(s) and ('0' <= s[idx] and s[idx] <= '9'):
        flag = True
        idx += 1
    # Scan after .
    if idx < len(s) and s[idx] == '.':
        idx += 1
        # 3.
        if not idx < len(s):
            return flag
        
        while idx < len(s) and ('0' <= s[idx] and s[idx] <= '9'):
            idx += 1
            flag = True
    # Scan e
    if idx < len(s) and (s[idx] == 'E' or s[idx] == 'e'):
        idx += 1
        if not idx < len(s):
            return False
        if s[idx] == '-' or s[idx] == '+':
            idx += 1
        if not idx < len(s):
            return False
        while idx < len(s) and ('0' <= s[idx] and s[idx] <= '9'):
            idx += 1
    if idx != len(s):
        return False
    return flag
        


def main():
    s = " "
    print(isNumber(s))

main()