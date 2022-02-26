package controller;

import model.Coordinate;
import view.View;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public List<Coordinate> createCoordinateList() throws IOException {
        String userInput = view.getUserInput();
        String[] split = userInput.split("-");
        try {
            return Arrays.stream(split)
                    .map(Coordinate::createCoordinate)
                    .collect(toList());
        } catch (Exception e) {
            view.print(e.getMessage());
            return createCoordinateList();
        }
    }
}
