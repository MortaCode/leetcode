package 哈希;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstUniqChar_387 {
    public int firstUniqChar(String s) {
        //char[] arr = s.toCharArray();  char[]数组无法用于stream流
        Map<Character, Integer> map =  s.chars().mapToObj(c -> (char)c)
                .collect(Collectors.toMap(Function.identity(), value->1, Integer::sum, LinkedHashMap::new)); //知识点：toMap的参数

        AtomicInteger result = new AtomicInteger(-1);
        IntStream.range(0, s.length())
                .filter(i -> map.get(s.charAt(i)) == 1)
                .findFirst()
                .ifPresent(result::set);

        //break、continue只能用于循环结构中。而lambda仅仅是代码块
        //lambda表达式中，变量需要是final类型。只能使用原子类型
//        AtomicInteger index = new AtomicInteger(-1); //知识点：原子、break、continue
//        //lanmda表达式中，变量应为final
//        AtomicInteger result = new AtomicInteger(-1);
//        map.forEach((key, value) -> {
//            if (value == 1 && index.get() >= 0){
//                result = index;
//            }
//            index.getAndIncrement();
//        });
        return result.get();
    }
}
