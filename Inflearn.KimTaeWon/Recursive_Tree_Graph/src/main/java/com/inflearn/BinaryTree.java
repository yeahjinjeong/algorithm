package com.inflearn;

/**
 * 전위순회 : 부모 - 왼쪽자식 - 오른쪽자식
 * 중위순회 : 왼쪽자식 - 부모 - 오른쪽자식
 * 후위순회 : 왼쪽자식 - 오른쪽자식 - 부모
 */
public class BinaryTree {
    Node root;
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(1);
        binaryTree.root.lt = new Node(2);
        binaryTree.root.rt = new Node(3);
        binaryTree.root.lt.lt = new Node(4);
        binaryTree.root.lt.rt = new Node(5);
        binaryTree.root.rt.lt = new Node(6);
        binaryTree.root.rt.rt = new Node(7);

        binaryTree.prefix(binaryTree.root);
        System.out.println();
        binaryTree.inorder(binaryTree.root);
        System.out.println();
        binaryTree.postfix(binaryTree.root);
    }

    private void prefix(Node root) {
        if (root == null) return;
        else {
            // 전위순회
            System.out.print(root.data);
            prefix(root.lt);
            prefix(root.rt);
        }
    }
    // 1 출력 -> 2 출력 -> 4 출력 -> return -> 5 출력 -> return -> 3 출력 -> 6 출력 -> return -> 7 출력 -> return

    private void inorder(Node root) {
        if (root == null) return;
        else {
            // 중위순회
            inorder(root.lt);
            System.out.print(root.data);
            inorder(root.rt);
        }
    }
    // inorder(1) -> inorder(2) -> inorder(4) -> return -> 4 출력 -> return -> 2 출력 -> inorder(5) -> return -> 5 출력 -> return -> 1 출력
    // -> inorder(3) -> inorder(6) -> return -> 6 출력 -> return -> 3 출력 -> inorder(7) -> return -> 7 출력 -> return -> }

    private void postfix(Node root) {
        if (root == null) return;
        else {
            // 후위순회
            postfix(root.lt);
            postfix(root.rt);
            System.out.print(root.data);
        }
    }
    // postfix(1) -> postfix(2) -> postfix(4) -> null return -> null return -> 4 출력 } -> postfix(5) -> null return -> null return -> 5 출력 } -> 2 출력 }
    // -> postfix(3) -> postfix(6) -> null return -> null return -> 6 출력 -> postfix(7) -> null return -> null return -> 7 출력 } -> 3 출력 } -> 1 출력 }
}

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}