package 哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1：
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 解释：
 * 字符串 s 和 t 可以通过以下方式变得相同：
 * 将 'e' 映射为 'a'。
 * 将 'g' 映射为 'd'。
 *
 * 示例 2：
 * 输入：s = "f11", t = "b23"
 * 输出：false
 * 解释：
 * 字符串 s 和 t 无法变得相同，因为 '1' 需要同时映射到 '2' 和 '3'。
 */
public class IsIsomorphic_205 {
    //同位置的内容映射
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char x = s.charAt(i), y = t.charAt(i);                            //变量命名[第一、第二]
            boolean first = s2t.containsKey(x) && !s2t.get(x).equals(y);
            boolean second = t2s.containsKey(y) && !t2s.get(y).equals(x);
            if (first || second){return false;}
            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }
}
