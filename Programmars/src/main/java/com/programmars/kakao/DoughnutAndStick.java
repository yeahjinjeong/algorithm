package com.programmars.kakao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoughnutAndStick {

    public static void main(String[] args) {
        DoughnutAndStick doughnutAndStick = new DoughnutAndStick();
//        int[][] edges = new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
//        int[][] edges = new int[][]{{2, 2}, {3, 2}, {3, 1}, {1, 4}};
//        int[][] edges = new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}};
//        int[][] edges = new int[][]{{1, 12},{8, 3}, {12, 7}, {7, 11},{9, 6}, {10, 11}, {6, 10},{3, 5}, {11, 1},{5, 3}, {11, 9},{3, 8}, {4, 11},{4, 8}};
        int[][] edges = new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};

        int[] solution = doughnutAndStick.solution(edges);
        System.out.print(Arrays.toString(solution));
    }

    public int[] solution(int[][] edges) {
        Node[] nodeArray = new Node[edges.length + 1];

        for (int i = 0; i < edges.length + 1; i++) {
            nodeArray[i] = new Node();
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            nodeArray[start].setOut(end);
            nodeArray[end].setIn(start);
        }

        int stick = 0;
        int eight = 0;
        int doughnut = 0;
        int center = 0;

        for (int i = 0; i < nodeArray.length; i++) {
            Node node = nodeArray[i];
            if (node.getOut().size() >= 2 && node.getIn().size() == 0) center = i;
            if (node.getOut().size() == 0 && node.getIn().size() >= 1) stick++; // 들어오는 것만 있고 나가는 게 없는 정점 = 막대
            if (node.getOut().size() >= 2 && node.getIn().size() >= 2) eight++;
        }
        if (nodeArray[center] != null) doughnut = nodeArray[center].getOut().size() - stick - eight;

        return new int[]{center, doughnut, stick, eight};
    }
}

class Node {
    List<Integer> in;
    List<Integer> out;

    public Node() {
        this.in = new ArrayList<>();
        this.out = new ArrayList<>();
    }

    public void setIn(int i) {
        this.in.add(i);
    }

    public void setOut(int o) {
        this.out.add(o);
    }

    public List<Integer> getIn() {
        return this.in;
    }

    public List<Integer> getOut() {
        return this.out;
    }
}
