package util;

import model.Coordinate;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Util {

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }

    public static Collector<Coordinate, ?, List<Coordinate>> toList() {
        return Collectors.toList();
    }

}
