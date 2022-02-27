import controller.Controller;
import model.Point;
import view.View;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        View view = new View(bw, br);
        Controller controller = new Controller(view);
        List<Point> pointList = controller.createCoordinateList();
        controller.printResult(pointList);
    }
}
