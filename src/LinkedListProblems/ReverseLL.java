package LinkedListProblems;

public class ReverseLL {
    public static void main(String[] args) {
        ListNode head = LLOperations.getLL();

        System.out.print("Original LL: ");
        LLOperations.printLL(head);
        System.out.print("Reversed LL: ");
        LLOperations.printLL(reverseLL(head));
    }

    static ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


}
