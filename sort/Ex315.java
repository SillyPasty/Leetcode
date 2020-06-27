package sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Ex315 {
    public static void main (String[] args) {
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        int[] nums1 = {5, 2, 6, 1};
        System.out.println(new Ex315().countSmaller(nums));
    }

    public List<Integer> countSmaller(int[] nums) {
        final int len = nums.length;
        int[] result = new int[nums.length];
        if (nums.length == 0)
            return Arrays.stream(nums).boxed().collect(Collectors.toList());
        BSTNode root = new BSTNode(nums[len-1]);
        for (int i = len-2; i >= 0; i--) {
            BSTNode newNode = new BSTNode(nums[i]);
            BSTNode curNode = root;
            while (true) {
                if (newNode.val == curNode.val) {
                    curNode.dup++;
                    result[i] += curNode.cnt;
                    break;
                } else if(newNode.val < curNode.val) {
                    curNode.cnt++;
                    if (curNode.lc == null) {
                        curNode.addLC(newNode);
                        break;
                    }
                    else
                        curNode = curNode.lc;
                } else {
                    result[i] += curNode.dup;
                    result[i] += curNode.cnt;
                    if (curNode.rc == null) {
                        curNode.addRC(newNode);
                        break;
                    }
                    else
                        curNode = curNode.rc;
                } 
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    class BSTNode {
        int val, cnt, dup = 1;
        BSTNode lc, rc;
        BSTNode(int val) {
            this.val = val;
        }
        public void addLC(BSTNode lc) {
            this.lc = lc;
        }

        public void addRC(BSTNode rc) {
            this.rc = rc;
        }
    }
}