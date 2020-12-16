def wordPattern(self, pattern: str, s: str) -> bool:
    sl = s.split()
    m = {}
    if len(sl) != len(pattern) or len(set(sl)) != len(set(list(pattern))):
        return False
    for i, c in enumerate(pattern):
        if m.get(c) is None:
            m[c] = sl[i]
        elif m[c] != sl[i]:
            return False
    return True