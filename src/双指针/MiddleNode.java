package 双指针;

import common.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */

public class MiddleNode {

    //有两个中间结点，则返回第二个中间结点
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;          //不能连=
        while (fast != null && fast.next != null){       //走双倍。做好*NULL*控制
            slow = slow.next;                            //区分好。字段orget字段()
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4,5};
        ListNode head = common.ListNode.buildNode(values);
        ListNode middleNode = middleNode(head);
        common.ListNode.printNode(middleNode);
    }
}
