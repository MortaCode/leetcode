package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidBrackets {
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0){return false;}
        // 哈希初始化  +  不支持基本类型
        Map<Character, Character> map = Map.ofEntries(
                Map.entry(')', '('),
                Map.entry(']', '['),
                Map.entry('}', '{')
        );
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                if (deque.isEmpty() || !deque.peek().equals(map.get(c))){
                    return false;
                }
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "{[()]}";
        String str2 = "{[(]}";
        System.out.println("测试案例:" + isValid(str1));
        System.out.println("测试案例:" + isValid(str2));
    }
}
