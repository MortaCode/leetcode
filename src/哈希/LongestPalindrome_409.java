package 哈希;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输出:1
 * 解释：可以构造的最长回文串是"a"，它的长度是 1。
 */

public class LongestPalindrome_409 {

    //构建回文串
    public int longestPalindrome(String s) {
        //先计数
        Map<Character, Integer> count = s.chars().mapToObj(c -> (char)c)
                .collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));
        //在统计
        int ans = 0, odd = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()){
            Integer value = entry.getValue();
            int rem = value % 2;
            ans += value - rem;//奇数[少加一个]。偶数[全加]
            if (rem == 1){odd = 1;}//只保留一个奇数字符
        }
        return ans + odd;
    }
}
