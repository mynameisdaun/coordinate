package controller;

import model.Point;
import model.Line;
import view.View;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Controller {
    private final View view;
    private final String coordinateParser = "-";

    public Controller(View view) {
        this.view = view;
    }

    public List<Point> createCoordinateList() throws IOException {
        String userInput = view.getUserInput();
        try {
            return stream(userInput.split(coordinateParser))
                        .map(Point::createCoordinate)
                        .collect(toList());
        } catch (Exception e) {
            view.print(e.getMessage());
            return createCoordinateList();
        }
    }

    public void printResult(List<Point> pointList) throws IOException {
        view.printPlane(pointList);
        if(pointList.size()==2) {
            Line line = Line.createLine(pointList);
            view.print("두 점 사이 거리는 "+line.calculateDistance());
        }
    }

    public void printPlane(List<Point> pointList) throws IOException {
        view.printPlane(pointList);
    }
}
