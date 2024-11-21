package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS {
    Node root;
    public static void main(String[] args) {
        BinaryTreeBFS binaryTree = new BinaryTreeBFS();

        binaryTree.root = new Node(1);
        binaryTree.root.lt = new Node(2);
        binaryTree.root.rt = new Node(3);
        binaryTree.root.lt.lt = new Node(4);
        binaryTree.root.lt.rt = new Node(5);
        binaryTree.root.rt.lt = new Node(6);
        binaryTree.root.rt.rt = new Node(7);

        binaryTree.BFS(binaryTree.root);
    }

    private void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }
}