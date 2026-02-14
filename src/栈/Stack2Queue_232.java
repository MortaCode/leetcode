package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */

public class Stack2Queue_232 {

    //思路：栈[先进后出==最新数据没出，前面不能出]、队列[先进先出，和栈相反]
    static Deque<Integer> inputStack;
    static Deque<Integer> outStack;

    public Stack2Queue_232() {
        inputStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            stack3Dueue();
        }
        return outStack.pop();
    }

    public static int peek() {
        if (outStack.isEmpty()){
            stack3Dueue();
        }
        return outStack.peek();
    }

    public static boolean empty() {
        if (inputStack.isEmpty() && outStack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void stack3Dueue(){
        while (!inputStack.isEmpty()){
            outStack.push(inputStack.pop());
        }
    }

    public static void printDueue(){
        while (!inputStack.isEmpty()){
            outStack.push(inputStack.pop());
        }

        Deque<Integer> tempStack = new LinkedList();//临时栈
        while (!outStack.isEmpty()){
            int value = outStack.pop();
            System.out.println(value);
            tempStack.push(value);
        }

        //还原栈的顺序
        while (!tempStack.isEmpty()){
            outStack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack2Queue_232 myQueue = new Stack2Queue_232();
        myQueue.push(1);
        printDueue();
        myQueue.push(2);
        printDueue();
        myQueue.peek();
        myQueue.pop();
        printDueue();
        myQueue.empty();
        System.out.println("目标值：" + myQueue.empty() + "," + "期望值：false");
        myQueue.pop();
        printDueue();
        System.out.println("目标值：" + myQueue.empty() + "," + "期望值：true");

    }
}
