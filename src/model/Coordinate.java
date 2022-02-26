package model;

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        if(x > 24 || x < 0 || y > 24 || y < 0) {
            throw new IllegalArgumentException("유효한 좌표의 범위는 0 ~ 24 입니다.");
        }
        this.x = x;
        this.y = y;
    }

}
