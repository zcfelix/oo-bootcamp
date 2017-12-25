package help;

import parking.Car;
import parking.ParkingLot;
import parking.WithParkingCapability;

import java.util.stream.IntStream;

public class TestHelper {

    public static ParkingLot getParkingLotWithCapacityAndParkedSize(int capacity, int parkedSize) {
        if (capacity < 0 || parkedSize < 0 || capacity < parkedSize) {
            throw new IllegalArgumentException("capacity and parkedSize must larger than " +
                    "0 and capacity should not be less than parkedSize");
        }
        ParkingLot parkingLot = new ParkingLot(capacity);
        repeat(parkedSize, () -> parkingLot.park(new Car()));
        return parkingLot;
    }

    public static ParkingLot getFullParkingLot() {
        ParkingLot lot = new ParkingLot(1);
        lot.park(new Car());
        return lot;
    }

    private static void repeat(int count, Runnable action) {
        IntStream.range(0, count).forEach(i -> action.run());
    }
}
