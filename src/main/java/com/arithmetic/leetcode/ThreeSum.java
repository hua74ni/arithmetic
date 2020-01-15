package com.arithmetic.leetcode;

import java.util.*;

/**
 * @Author huangdh
 * @Description 15. 三数之和
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> listList = new ArrayList<>();
        Set<TreeNum> set = new HashSet();

        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int target = 0 - nums[i];
                if (nums[l] + nums[r] == target) {
                    set.add(new TreeNum(nums[i], nums[l], nums[r]));
                    while (l + 1 <= nums.length - 1 && nums[l + 1] + nums[r] == target) l++;
                    while (r - 1 >= 0 && nums[r - 1] + nums[r] == target) r--;
                }
                if (nums[l] + nums[r] >= target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        for (Iterator<TreeNum> iterator = set.iterator(); iterator.hasNext(); ) {

            TreeNum treeNum = iterator.next();
            List<Integer> list = new ArrayList();
            list.add(treeNum.n1);
            list.add(treeNum.n2);
            list.add(treeNum.n3);

            listList.add(list);
        }

        return listList;
    }

    class TreeNum {
        int n1;
        int n2;
        int n3;

        public TreeNum(int n1, int n2, int n3) {
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNum treeNum = (TreeNum) o;
            return n1 == treeNum.n1 &&
                    n2 == treeNum.n2 &&
                    n3 == treeNum.n3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n1, n2, n3);
        }
    }

    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> listList = threeSum.threeSum(nums);

        for (List<Integer> list : listList) {

            for (Integer i : list) {
                System.out.print(" " + i + " ");
            }
            System.out.println();
        }
    }

}
