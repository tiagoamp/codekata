package hackerrank;

// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeLevelOrderTraversal {

    class Node {
        TreeLevelOrderTraversal.Node left;
        TreeLevelOrderTraversal.Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static List<Integer> levelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            result.add(curr.data);
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
        //result.forEach(n -> System.out.print(n + " "));
        return result;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        var root = new TreeLevelOrderTraversal.Node(1);
        root.right = new TreeLevelOrderTraversal.Node(2);
        root.right.right = new TreeLevelOrderTraversal.Node(5);
        root.right.right.left = new TreeLevelOrderTraversal.Node(3); root.right.right.right = new TreeLevelOrderTraversal.Node(6);
        root.right.right.left.right = new TreeLevelOrderTraversal.Node(4);
        var expected = List.of(1,2,5,3,6,4);
        var result = levelOrder(root);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

}
