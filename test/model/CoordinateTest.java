package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoordinateTest {

    @Test
    public void X_Y좌표_모두_최대_24까지만_입력할_수_있다() throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25,1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(1,25);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-1,4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(4,-1);
        });
    }

}