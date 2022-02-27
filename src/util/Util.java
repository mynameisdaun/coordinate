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

    public static String padStringLeft(String str, int digit) {
        return String.format("%" + digit + "s", str);
    }

    public static String padIntegerLeft(int number, int digit) {
        return String.format("%" + digit + "s", number);
    }

}
