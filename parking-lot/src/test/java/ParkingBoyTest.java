import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingBoyTest {

    private ParkingLot fullParkingLot;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private ParkingBoy parkingBoy;

    @Before
    public void setUp() {
        fullParkingLot = TestHelper.getFullParkingLot();
        parkingLot1 = TestHelper.getParkingLotWithCapacity(1);
        parkingLot2 = TestHelper.getParkingLotWithCapacity(2);

        parkingBoy = new ParkingBoy(LotSelector.firstAvailableSelector, fullParkingLot, parkingLot2, parkingLot1);
    }

    @Test
    public void should_parking_boy_park_car_to_first_available_lot() {
        assertThat(parkingBoy.park(new Car()), is(true));
        assertThat(parkingLot1.getRemained(), is(1));
        assertThat(parkingLot2.getRemained(), is(1));
    }

    @Test
    public void should_parking_boy_not_park_car_when_all_lots_are_full() {
        ParkingBoy parkingBoyWithAllFullLots = new ParkingBoy(LotSelector.firstAvailableSelector, fullParkingLot);
        assertThat(parkingBoyWithAllFullLots.park(new Car()), is(false));
    }

    @Test
    public void should_parking_boy_pick_car_after_parking() {
        Car car = new Car();
        parkingBoy.park(car);
        assertThat(parkingBoy.pick(car), is(true));
        assertThat(parkingLot1.getRemained(), is(1));
        assertThat(parkingLot2.getRemained(), is(2));
    }

    @Test
    public void should_parking_boy_not_pick_car_when_car_not_in_lot() {
        assertThat(parkingBoy.pick(new Car()), is(false));
    }

    @Test
    public void should_smart_parking_boy_park_car_to_max_remained_capacity_lot() {
        ParkingBoy smartParkingBoy = new ParkingBoy(LotSelector.maxRemainedFirst, fullParkingLot, parkingLot1, parkingLot2);
        assertThat(smartParkingBoy.park(new Car()), is(true));
        assertThat(parkingLot2.getRemained(), is(1));
    }

    @Test
    public void should_super_parking_boy_park_car_to_max_remained_rate_lot() {
        parkingLot2.park(new Car());

        ParkingBoy superParkingBoy = new ParkingBoy(LotSelector.maxRemainedRateFirst, fullParkingLot, parkingLot1, parkingLot2);
        Car car = new Car();
        assertThat(superParkingBoy.park(car), is(true));
        assertThat(parkingLot1.getRemained(), is(0));
    }
}
