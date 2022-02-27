package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    
    @Test
    public void 직선인_경우는_두_점_사이_거리를_계산해서_출력한다() throws Exception {
        //given
        Point point1 = new Point(1,1);
        Point point2 = new Point(1,2);
        Line line = new Line(point1, point2);

        //when
        double distance = line.calculateDistance();
                
        //then
        assertEquals(1,distance);
    }   

}