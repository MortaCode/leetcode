package 双指针;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */
public class TwoSum_167 {
    //题干：1、数组已按非递减顺序排列  -->多个答案？    2、标从1开始的整数数组
    //思路：左右往中间移动
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null){return new int[]{-1, -1};}
        int l = 0, r = numbers.length-1;
        while (l < r){
            int sum = numbers[l] + numbers[r];
            if (sum == target){
                return new int[]{l+1, r+1};
            }
            if (sum < target){
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        int[] indexs = twoSum(numbers, target);
        for (int i=0; i<indexs.length; i++){
            int index = i+1;
            System.out.println("下标" + index + ":" + indexs[i]);
            //System.out.println("下标" + i+1 + ":" + indexs[i]);   //字符拼接不能  涉及运算了
        }
    }
}
