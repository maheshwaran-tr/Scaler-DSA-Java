package LinkedListProblems;

public class DetectCycle {
    public static void main(String[] args) {
        // Test case 1: Linked list with a cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next; // Creates a cycle

        System.out.println(detectCycle(head1)); // Should return true

        // Test case 2: Linked list without a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        System.out.println(detectCycle(head2)); // Should return false
    }

    private static boolean detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
