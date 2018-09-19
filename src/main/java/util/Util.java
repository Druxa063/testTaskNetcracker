package util;

public class Util {
    private Util() {}

    public static <T> T orElse(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static  <T extends Comparable<? super T>>boolean isBetween(T value, T startDate, T endDate) {
        return value.compareTo(startDate) >= 0 && value.compareTo(endDate) <= 0;
    }
}
