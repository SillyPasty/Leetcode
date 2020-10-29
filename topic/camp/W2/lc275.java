public class lc275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = citations.length - 1;
        if (len == 0)
            return 0;
        while (left < right) {
            int mid = (left + right) / 2;
            int cur = citations[mid];
            if (len - mid == cur)
                return len - mid;
            if (len - mid > cur)
                left = mid + 1;
            else if (len - mid < cur && mid != 0) {
                if (len - mid + 1 < citations[mid - 1]) {
                    right = mid - 1;
                } else {
                    return len - mid;
                }
            } else if (len - mid < cur && mid == 0)
                return len - mid;
        }
    }
}
