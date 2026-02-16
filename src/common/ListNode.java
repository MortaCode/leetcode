package common;

public class ListNode {
    public int value;

    public ListNode next;
    public ListNode(int value){
        this.value = value;
    }

    public ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }

    public static ListNode buildNode(int[] values){
        if (values == null || values.length == 0){
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode cur = head;
        for (int i=1; i<values.length; i++){
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public static void printNode(ListNode head){
        if (head == null){return;}
        while (head.next != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.print(head.value);
    }

    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4};
        ListNode head = buildNode(values);
        printNode(head);
    }


}
