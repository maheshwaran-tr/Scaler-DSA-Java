package LinkedListProblems;

public class DeleteMiddle {
    public static void main(String[] args) {
        LLOperations.printLL(solve(LLOperations.getLL()));
    }

    private static ListNode solve(ListNode head) {
        // Edge case: If the list contains only one node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // Move 'fast' by two steps and 'slow' by one step to find the middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
}
