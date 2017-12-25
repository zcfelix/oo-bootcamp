package parking;

import visiting.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements WithParkingCapability {
    private int capacity;
    private List<Car> cars;

    public ParkingLot(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity should not be less than 0");
        }
        this.capacity = capacity;
        cars = new ArrayList<>(capacity);
    }

    @Override
    public boolean park(Car car) {
        if (cars.size() < capacity) {
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean pick(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return true;
        }
        return false;
    }

    public <T> T get(Usage<T> usage) {
        return usage.get(cars.size(), capacity);
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
