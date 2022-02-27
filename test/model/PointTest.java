package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void X_Y좌표_모두_최대_24까지만_입력할_수_있다() throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Point(25,1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Point(1,25);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Point(-1,4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Point(4,-1);
        });
    }

}