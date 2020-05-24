
def isMatch(s, p):
    if not p: return not s
    first_match = bool(s) and p[0] in (".", s[0])
    if len(p) >= 2 and p[1] == '*':
        if first_match:
            return isMatch(s, p[2:]) or isMatch(s[1:], p)
        return isMatch(s, p[2:])
    return first_match and isMatch(s[1:], p[1:])

        
def main():
    s = "aaaaaaaaaaaaab"
    p = "a*a*a*a*a*a*a*a*a*a*c"
    print(isMatch(s, p))

main()
