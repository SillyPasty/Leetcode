public class D19 {
    public boolean backspaceCompare(String S, String T) {
        char[] c1 = new char[201];
        char[] c2 = new char[201];
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#')
                c1[idx1++] = S.charAt(i);
            else if (idx1 != 0)
                idx1--;
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#')
                c2[idx2++] = T.charAt(i);
            else if (idx2 != 0)
                idx2--;
        }
        if (idx1 != idx2)
            return false;
        for (int i = 0; i < idx1; i++)
            if(c1[i] != c2[i])
                return false;
        return true;
    }
}
// 倒序遍历 O(1) Space
