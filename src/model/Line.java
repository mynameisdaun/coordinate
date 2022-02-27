package model;

import java.util.List;

public class Line {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        if(isSameCoordinate(point1, point2)) {
            throw new IllegalArgumentException("직선은 서로 다른 2개의 좌표로 구성되어 있어야 합니다.");
        }
        this.point1 = point1;
        this.point2 = point2;
    }

    public static Line createLine(List<Point> pointList) {
        if(pointList.size()!=2){
            throw new IllegalArgumentException("직선은 2개의 좌표로 구성되어 있어야 합니다.");
        }
        return new Line(pointList.get(0), pointList.get(1));
    }

    public boolean isSameCoordinate(Point point1, Point point2) {
        return point1 == point2;
    }

    public double calculateDistance() {
        return Math.sqrt(Math.pow(Math.abs(point1.x- point2.x),2)+Math.pow(Math.abs(point1.y- point2.y),2));
    }
}
