package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBFS {
    BFSNode root;
    public static void main(String[] args) {
        ShortestBFS shortestBFS = new ShortestBFS();
        shortestBFS.root = new BFSNode(1);
        shortestBFS.root.lt = new BFSNode(2);
        shortestBFS.root.rt = new BFSNode(3);
        shortestBFS.root.lt.lt = new BFSNode(4);
        shortestBFS.root.lt.rt = new BFSNode(5);

        System.out.println(shortestBFS.BFS(shortestBFS.root));
    }

    private int BFS(BFSNode root) {
        Queue<BFSNode> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                BFSNode cur = queue.poll();
                if (cur.lt == null && cur.rt == null) return L; // 이건 몇 레벨인지 구하는 게 아니라 간선의 개수를 구하는 것이기 때문에 L이다!
                if (cur.lt != null) queue.offer(cur.lt); // 큐에 레벨 왼쪽부터 오른쪽까지 차례차례 담게 되는 것
                if (cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }
    // queue = {1} L = 0 / queue = {2 3} L = 1 / queue = {3 4 5} / queue = {4 5} return L! (여기까지 다 채워졌으면 L = 2)
}
