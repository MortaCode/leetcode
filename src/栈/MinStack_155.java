package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * 示例 1:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack_155 {
    //思路：全局变量[数据结构] 实现若干方法[push、pop、top、getMin]
    //栈的特性：先进后出
    Deque<Integer> minStack;  //辅助栈[最小值]
    Deque<Integer> xStack;
    public MinStack_155() {
        minStack = new LinkedList<>();
        xStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        // 测试用例1：示例中的测试
        System.out.println("测试用例1：基本操作测试");
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin() = " + minStack.getMin() + "，期望值：-3");  // 返回 -3
        minStack.pop();
        System.out.println("top() = " + minStack.top() + "，期望值：0");         // 返回 0
        System.out.println("getMin() = " + minStack.getMin() + "，期望值：-2");  // 返回 -2
        System.out.println();

        // 测试用例2：边界情况测试
        System.out.println("测试用例2：边界情况测试");
        MinStack_155 minStack2 = new MinStack_155();
        minStack2.push(5);
        System.out.println("top() = " + minStack2.top() + "，期望值：5");
        System.out.println("getMin() = " + minStack2.getMin() + "，期望值：5");
        minStack2.pop();
        // 注意：如果栈为空，调用 top() 或 getMin() 会抛出异常
        System.out.println();

        // 测试用例3：多个相同最小值测试
        System.out.println("测试用例3：多个相同最小值测试");
        MinStack_155 minStack3 = new MinStack_155();
        minStack3.push(1);
        minStack3.push(2);
        minStack3.push(1);
        minStack3.push(3);
        System.out.println("getMin() = " + minStack3.getMin() + "，期望值：1");
        minStack3.pop();
        System.out.println("getMin() = " + minStack3.getMin() + "，期望值：1");
        minStack3.pop();
        System.out.println("getMin() = " + minStack3.getMin() + "，期望值：1");
        minStack3.pop();
        System.out.println("getMin() = " + minStack3.getMin() + "，期望值：1");
        System.out.println();

        // 测试用例4：递减序列测试
        System.out.println("测试用例4：递减序列测试");
        MinStack_155 minStack4 = new MinStack_155();
        minStack4.push(5);
        minStack4.push(4);
        minStack4.push(3);
        minStack4.push(2);
        minStack4.push(1);
        System.out.println("getMin() = " + minStack4.getMin() + "，期望值：1");
        minStack4.pop();
        System.out.println("getMin() = " + minStack4.getMin() + "，期望值：2");
        minStack4.pop();
        System.out.println("getMin() = " + minStack4.getMin() + "，期望值：3");
    }
}
