package 查找;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicate_287 {
    public static int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums).mapToObj(c -> (Integer)c)
                .collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum, LinkedHashMap::new));//一定需要有序
        AtomicInteger result = new AtomicInteger(-1);
        IntStream.range(0, nums.length)
                .boxed()
                .filter(i -> map.get(nums[i]) != 1)   //过滤条件：不等于1的
                .findFirst()
                .ifPresent(result::set);
        return result.get() == -1 ? -1 : nums[result.get()];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        findDuplicate(nums);


    }
}
