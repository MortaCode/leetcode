package 查找;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 */
public class PivotIndex_724 {
    //题干：整数数组   无序+不算自己

    //乘法
    public static int pivotIndex(int[] nums) {
        if (nums == null){return -1;}
        int sum = Arrays.stream(nums).sum();
        int pSum = 0;
        for (int i=0; i<nums.length; i++){
            if (pSum * 2 + nums[i] == sum){return i;}
            pSum += nums[i];
        }
        return -1;
    }

    //除法[存在问题]
//    public static int pivotIndex(int[] nums) {
//        if (nums == null){return -1;}
//        int sum = Arrays.stream(nums).sum();
//        int pSum = 0;
//        for (int i=0; i<nums.length; i++){
//            int mid = (sum - nums[i]) / 2;
//            if (pSum == mid){return i;}
//            pSum += nums[i];
//        }
//        return -1;
//    }

    //不算自己的
//    public static int pivotIndex(int[] nums) {
//        if (nums == null){return -1;}
//        int sum = Arrays.stream(nums).sum();
//        if (sum % 2 != 0){return -1;}
//        int mid = sum / 2;
//        int pSum = 0;
//        for (int i=0; i<nums.length; i++){
//            if (pSum == mid){return i;}
//            pSum += nums[i];
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.print(pivotIndex(nums));

    }
}
