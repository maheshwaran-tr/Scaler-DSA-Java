package LinkedListProblems;

public class MiddleOfLL {
    public static void main(String[] args) {

        ListNode head = LLOperations.getLL();
        System.out.println("Middle is: " + middleLL(head));
    }

    private static int middleLL(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
