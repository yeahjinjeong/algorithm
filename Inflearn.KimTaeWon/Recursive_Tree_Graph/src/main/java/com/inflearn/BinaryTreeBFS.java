package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS {
    BFSNode root;
    public static void main(String[] args) {
        BinaryTreeBFS binaryTree = new BinaryTreeBFS();

        binaryTree.root = new BFSNode(1);
        binaryTree.root.lt = new BFSNode(2);
        binaryTree.root.rt = new BFSNode(3);
        binaryTree.root.lt.lt = new BFSNode(4);
        binaryTree.root.lt.rt = new BFSNode(5);
        binaryTree.root.rt.lt = new BFSNode(6);
        binaryTree.root.rt.rt = new BFSNode(7);

        binaryTree.BFS(binaryTree.root);
    }

    private void BFS(BFSNode root) {
        Queue<BFSNode> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                BFSNode cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }
}