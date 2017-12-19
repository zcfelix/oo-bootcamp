import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<Car> cars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>(capacity);
    }

    public boolean park(Car car) {
        if (cars.size() < capacity) {
            cars.add(car);
            return true;
        }
        return false;
    }

    public boolean pick(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return true;
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemained() {
        return capacity - cars.size();
    }
}
