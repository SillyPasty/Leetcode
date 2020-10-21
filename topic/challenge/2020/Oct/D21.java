
public class D21 {
    public boolean isLongPressedName(String name, String typed) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < name.length() && idx2 < typed.length()) {
            if (name.charAt(idx1) == typed.charAt(idx2)) {
                idx1++;
                idx2++;
            } else if (idx1 > 0 && (name.charAt(idx1 - 1) == typed.charAt(idx2)))
                idx2++;
            else
                return false;
        }
        if (idx1 != name.length())
            return false;
        while (idx2 != typed.length())
            if (name.charAt(idx1-1) != typed.charAt(idx2))
                return false;
            else
                idx2++;
        return true;
    }
}
