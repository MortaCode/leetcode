package 查找;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 *
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 */
public class BinSearch_704 {

    //题干： 个元素有序的（升序）整型数组
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r){        //小于等于   案例:[5] l = r =0
            int mid = (r - l)/2 + l;
            if (nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
