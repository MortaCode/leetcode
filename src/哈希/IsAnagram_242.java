package 哈希;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagram_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){return false;}
        //第一轮
        int[] arr = new int[26];                //BUG：当时写成char类型了
        for (int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        //第二轮
        for (int i=0; i<t.length(); i++){
            int value = arr[t.charAt(i)-'a']--;
            if (value < 0){return false;}
        }
        return true;
    }

    public boolean isAnagramBySort(String s, String t) {
        if (s.length() != t.length()){return false;}
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
//        if (!Objects.equals(str1, str2)){
//            return false;
//        }
        return Arrays.equals(str1, str2);   //代码可读性。   数组比较：Arrays.equals()
    }


}
