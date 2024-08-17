package LinkedListProblems;


public class PalindromeLL {
    public static void main(String[] args) {
        ListNode head = LLOperations.getLL();

        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Find middle of LL
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = reverseLL(slow.next);
        ListNode firstHalf = head;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
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
