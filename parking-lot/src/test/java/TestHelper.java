public class TestHelper {
    public static ParkingLot getFullParkingLot() {
        ParkingLot lot = new ParkingLot(1);
        lot.park(new Car());
        return lot;
    }

    public static ParkingLot getParkingLotWithCapacity(int n) {
        return new ParkingLot(n);
    }
}
