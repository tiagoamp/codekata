package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertAnodeAtTheHeadOfAlinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        if (llist == null)
            return new SinglyLinkedListNode(data);
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
        newHead.next = llist;
        return newHead;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        List<Integer> input = List.of(383, 484, 392, 975, 321);
        List<Integer> expected = List.of(321, 975, 392, 484, 383);
        List<Integer> result = new ArrayList<>();
        SinglyLinkedListNode head = null;
        for (int i = 0; i < expected.size(); i++) {
            head = insertNodeAtHead(head, input.get(i));
        }
        SinglyLinkedListNode node = head;
        do {
            result.add(node.data);
            node = node.next;
        } while (node != null);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

}
