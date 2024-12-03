package com.inflearn;

public class ShortestTreeDFS {
    DFSNode root;

    public static void main(String[] args) {
        ShortestTreeDFS shortestTreeDFS = new ShortestTreeDFS();

        shortestTreeDFS.root = new DFSNode(1);
        shortestTreeDFS.root.lt = new DFSNode(2);
        shortestTreeDFS.root.rt = new DFSNode(3);
        shortestTreeDFS.root.lt.lt = new DFSNode(4);
        shortestTreeDFS.root.lt.rt = new DFSNode(5);

        shortestTreeDFS.DFS(0, shortestTreeDFS.root);
    }

    private int DFS(int L, DFSNode root) {
        if (root.lt == null && root.rt == null) { // 말단노드라면!
            return L;
        } else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt)); // 말단까지 내려가서 L을 구함 (내려갈 때마다 레벨 수 증가, 이는 즉 간선의 수를 리턴)
        // root.lt 와 root.rt 둘 다 있어야 가능한 풀이! => 따라서 BFS를 사용하는 것이 적합하다
    }
}
