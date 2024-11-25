package com.inflearn;

/**
 * 전위순회 : 부모 - 왼쪽자식 - 오른쪽자식
 * 중위순회 : 왼쪽자식 - 부모 - 오른쪽자식
 * 후위순회 : 왼쪽자식 - 오른쪽자식 - 부모
 */
public class BinaryTreeDFS {
    DFSNode root;
    public static void main(String[] args) {
        BinaryTreeDFS binaryTree = new BinaryTreeDFS();

        binaryTree.root = new DFSNode(1);
        binaryTree.root.lt = new DFSNode(2);
        binaryTree.root.rt = new DFSNode(3);
        binaryTree.root.lt.lt = new DFSNode(4);
        binaryTree.root.lt.rt = new DFSNode(5);
        binaryTree.root.rt.lt = new DFSNode(6);
        binaryTree.root.rt.rt = new DFSNode(7);

        binaryTree.prefix(binaryTree.root);
        System.out.println();
        binaryTree.inorder(binaryTree.root);
        System.out.println();
        binaryTree.postfix(binaryTree.root);
    }

    private void prefix(DFSNode root) {
        if (root == null) return;
        else {
            // 전위순회
            System.out.print(root.data);
            prefix(root.lt);
            prefix(root.rt);
        }
    }
    // 1 출력 -> 2 출력 -> 4 출력 -> return -> 5 출력 -> return -> 3 출력 -> 6 출력 -> return -> 7 출력 -> return

    private void inorder(DFSNode root) {
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

    private void postfix(DFSNode root) {
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