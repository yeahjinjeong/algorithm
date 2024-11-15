package com.inflearn;

import java.util.*;

public class CoordinateSort {
    public static void main(String[] args) {
        CoordinateSort coordinateSort = new CoordinateSort();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        // 1)
        Collections.sort(points); // reason: no instance(s) of type variable(s) T exist so that Point conforms to Comparable<? super T>
        // 2)
        Collections.sort(points, (Point p1, Point p2) -> {if (p1.getX() == p2.getX()) return p1.getY() - p2.getY(); return p1.getX() - p2.getX();});
        // 3)
        Comparator<Point> sortPoints = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() == o2.getX()) return o1.getY() - o2.getY();
                return o1.getX() - o2.getX();
            }
        };
        // 4)
        Collections.sort(points, sortPoints);
        // 5)
        points.sort(sortPoints); // ArrayList#sort()

        for (Point p : points) {
            System.out.println(p.getX() + " " + p.getY());
        }
    }
}

class Point implements Comparable<Point> { // 음수값을 리턴
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    } // 오름차순 정렬을 하고 싶다면, 앞에 있는 작은 수에서 뒤에 있는 큰 수를 뺀다.
}