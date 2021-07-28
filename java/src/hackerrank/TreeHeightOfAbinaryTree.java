package hackerrank;

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeHeightOfAbinaryTree {

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int height(Node root) {
        int leftHeight = 0, rightHeight = 0;
        if (root.left != null)
            leftHeight = 1 + height(root.left);
        if (root.right != null)
            rightHeight = 1 + height(root.right);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        var root = new Node(3);
        root.left = new Node(2); root.right = new Node(5);
        root.left.left = new Node(1); root.right.left = new Node(4); root.right.right = new Node(6);
        root.right.right.right = new Node(7);
        var expected = 3;
        var result = height(root);
        assertEquals(expected, result);
    }

}
