package com.inflearn;

public class ShortestDFS {
    DFSNode root;

    public static void main(String[] args) {
        ShortestDFS shortestDFS = new ShortestDFS();

        shortestDFS.root = new DFSNode(1);
        shortestDFS.root.lt = new DFSNode(2);
        shortestDFS.root.rt = new DFSNode(3);
        shortestDFS.root.lt.lt = new DFSNode(4);
        shortestDFS.root.lt.rt = new DFSNode(5);

        shortestDFS.DFS(0, shortestDFS.root);
    }

    private int DFS(int L, DFSNode root) {
        if (root.lt == null && root.rt == null) { // 말단노드라면!
            return L;
        } else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt)); // 말단까지 내려가서 L을 구함 (내려갈 때마다 레벨 수 증가, 이는 즉 간선의 수를 리턴)
    }
}
