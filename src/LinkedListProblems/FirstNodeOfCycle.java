package LinkedListProblems;

public class FirstNodeOfCycle {
    public static void main(String[] args) {
        // Test case 1: Linked list with a cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next.next; // Creates a cycle

        ListNode node = firstNodeOfCycle(head1);
        if(node != null){
            System.out.println(node.val);
        }else{
            System.out.println("No Cycle");
        }

        // Test case 2: Linked list without a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        ListNode node2 = firstNodeOfCycle(head2);
        if(node2 != null){
            System.out.println(node2.val);
        }else{
            System.out.println("No Cycle");
        }

    }

    static ListNode firstNodeOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
