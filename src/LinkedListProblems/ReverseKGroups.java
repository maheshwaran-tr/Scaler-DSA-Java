package LinkedListProblems;

public class ReverseKGroups {
    public static void main(String[] args) {
        ListNode head = LLOperations.getLL();
        LLOperations.printLL(reverseKGroup(head,3));
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;


        while (pointer != null) {

            // Check if there are K nodes available or not
            ListNode track = pointer;
            for (int i = 1; i <= k && track != null; i++) {
                track = track.next;
            }
            if (track == null) {
                break;
            }

            // Reverse each groups
            ListNode prev = null;
            ListNode curr = pointer.next;
            for (int i = 1; i <= k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode tail = pointer.next;
            pointer.next = prev;
            tail.next = curr;
            pointer = tail;
        }
        return dummy.next;
    }
}
