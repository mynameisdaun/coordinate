package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Util.toInt;

public class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        if(x > 24 || x < 0 || y > 24 || y < 0) {
            throw new IllegalArgumentException("유효한 좌표 범위가 아닙니다.\n유효한 좌표의 범위는 0 ~ 24 입니다.");
        }
        this.x = x;
        this.y = y;
    }

    public static Point createCoordinate(String str) {
        String regex = "(\\d+),(\\d+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if(!m.find()) {
            throw new IllegalArgumentException("유효한 좌표가 아닙니다.\n유효한 좌표 형식은 (x,y) 입니다.");
        }
        return new Point(toInt(m.group(1)), toInt(m.group(2)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point that = (Point) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
