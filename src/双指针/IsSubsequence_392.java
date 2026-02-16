package 双指针;

import java.util.Objects;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence_392 {

    //可以删除某一些字符，但需要保证顺序
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {   //双校验。避免null情况
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

//    public boolean isSubsequence(String s, String t) {
//        int slow = 0, fast = 0;
//        int m = s.length(), n = t.length();
//        for (int i=0; i<n; i++){
//            //if (fast - slow == m){return true;}错误版本
//            if (slow + 1 == m){return true;}
//            //if (Objects.equals(s.charAt(slow), t.charAt(fast))){slow++;} 错误版本Objects.equals(arg1, arg2)。其中arg1和arg2可能为空
//            if (s.charAt(slow) == t.charAt(fast)){
//                slow++;
//            }
//            fast++;
//        }
//        return false;
//    }

//    public boolean isSubsequence(String s, String t) {
//        int x = 0, y = 0;
//        int m = s.length(), n = t.length();
//        while (y < n){
//            if (x == m-1){return true;}
//            x = Objects.equals(s.charAt(x), t.charAt(y)) ? x+1 : 0;
//            y++;
//        }
//        return false;
//    }
}
