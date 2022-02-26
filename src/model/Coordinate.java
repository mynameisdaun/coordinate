package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Util.toInt;

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        if(x > 24 || x < 0 || y > 24 || y < 0) {
            throw new IllegalArgumentException("유효한 좌표 범위가 아닙니다.\n유효한 좌표의 범위는 0 ~ 24 입니다.");
        }
        this.x = x;
        this.y = y;
    }

    public static Coordinate createCoordinate(String str) {
        String regex = "(\\d+),(\\d+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if(!m.find()) {
            throw new IllegalArgumentException("유효한 좌표가 아닙니다.\n유효한 좌표 형식은 (x,y) 입니다.");
        }
        return new Coordinate(toInt(m.group(1)), toInt(m.group(2)));
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
