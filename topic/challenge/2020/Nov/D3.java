class Solution {
    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if (A.length < 3)
            return false;
        boolean stat = true;
        int prev = A[0];
        for (int i = 1; i < length; i++) {
            if (A[i] == prev)
                return false;
            else if (A[i] > prev && stat == false)
                return false;
            else if (A[i] < prev && stat == true && i == 1)
                return false;
            else if (A[i] < prev && stat == true)
                stat = false;
            prev = A[i];
        }
        if (stat)
            return false;
        return true;
    }
}