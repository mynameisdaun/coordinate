package controller;

import model.Coordinate;
import view.View;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class Controller {
    private final View view;
    private final String coordinateParser = "-";

    public Controller(View view) {
        this.view = view;
    }

    public List<Coordinate> createCoordinateList() throws IOException {
        String userInput = view.getUserInput();
        try {
            return stream(userInput.split(coordinateParser))
                        .map(Coordinate::createCoordinate)
                        .collect(toList());
        } catch (Exception e) {
            view.print(e.getMessage());
            return createCoordinateList();
        }
    }
}
