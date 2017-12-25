package parking;

import visiting.Visitor;

public interface WithParkingCapability {
    boolean park(Car car);

    boolean pick(Car car);

    <T> T get(Usage<T> usage);

    String accept(Visitor visitor);

    @FunctionalInterface
    interface Usage<T> {
        Usage<Integer> total = (used, total) -> total;
        Usage<Integer> used = (used, total) -> used;
        Usage<Integer> remained = (used, total) -> total - used;
        Usage<Double> remainedRate = (used, total) -> (total - used) * 1.0 / total;

        T get(int used, int total);
    }
}
