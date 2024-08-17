package LinkedListProblems;

import java.util.Scanner;

public class LLOperations {
    public static ListNode getLL() {

        Scanner scanner = new Scanner(System.in);

        // Initialize the head of the linked list
        ListNode head = null;
        ListNode tail = null;

        System.out.println("Enter -1 to end ");

        // Continuously take input from the user
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;

            // Create a new node
            ListNode newNode = new ListNode(num);

            // If the list is empty, set head and tail to the new node
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Add the new node to the end of the list
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Close the scanner
        scanner.close();

        return head;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
