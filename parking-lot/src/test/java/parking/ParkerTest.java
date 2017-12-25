package parking;

import org.junit.Before;
import org.junit.Test;

import static help.TestHelper.getFullParkingLot;
import static help.TestHelper.getParkingLotWithCapacityAndParkedSize;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static parking.ParkingSelector.firstAvailableSelector;
import static parking.ParkingSelector.maxRemainedSelector;
import static parking.ParkingSelector.maxRemainedRateSelector;
import static parking.WithParkingCapability.Usage.remained;

public class ParkerTest {

    private Parker parkingBoy;
    private Parker smartParkingBoy;
    private Parker superParkingBoy;
    private ParkingLot largeParkedLot;
    private ParkingLot smallEmptyLot;

    @Before
    public void setUp() throws Exception {
        ParkingLot fullLot = getFullParkingLot();
        smallEmptyLot = getParkingLotWithCapacityAndParkedSize(1, 0);
        largeParkedLot = getParkingLotWithCapacityAndParkedSize(10, 2);
        parkingBoy = new Parker(asList(fullLot, smallEmptyLot, largeParkedLot), firstAvailableSelector);
        smartParkingBoy = new Parker(asList(fullLot, smallEmptyLot, largeParkedLot), maxRemainedSelector);
        superParkingBoy = new Parker(asList(fullLot, smallEmptyLot, largeParkedLot), maxRemainedRateSelector);
    }

    @Test
    public void should_boy_park_car_when_has_available_parking_lot() {
        int originalRemained = parkingBoy.get(remained);
        assertThat(parkingBoy.park(new Car()), is(true));
        int currentRemained = parkingBoy.get(remained);
        assertThat(currentRemained, is(originalRemained - 1));
    }

    @Test
    public void should_boy_not_park_car_when_has_no_available_parking_lot() {
        ParkingLot fullLot1 = getFullParkingLot();
        ParkingLot fullLot2 = getFullParkingLot();
        Parker parkingBoy = new Parker(asList(fullLot1, fullLot2), firstAvailableSelector);
        assertThat(parkingBoy.park(new Car()), is(false));
    }

    @Test
    public void should_boy_pick_car_after_parking() {
        Car car = new Car();
        parkingBoy.park(car);
        assertThat(parkingBoy.pick(car), is(true));
    }

    @Test
    public void should_boy_not_pick_car_without_parking() {
        Car unParkedCar = new Car();
        assertThat(parkingBoy.pick(unParkedCar), is(false));
    }

    @Test
    public void should_smart_parking_boy_choose_max_remained_lot_to_park() {
        int smallLotOriginalRemained = smallEmptyLot.get(remained);
        int largeLotOriginalRemained = largeParkedLot.get(remained);
        assertThat(smartParkingBoy.park(new Car()), is(true));
        int smallLotCurrentRemained = smallEmptyLot.get(remained);
        int largeLotCurrentRemained = largeParkedLot.get(remained);
        assertThat(smallLotCurrentRemained, is(smallLotOriginalRemained));
        assertThat(largeLotCurrentRemained, is(largeLotOriginalRemained - 1));
    }

    @Test
    public void should_super_parking_boy_choose_max_remained_rate_lot_to_park() {
        int smallLotOriginalRemained = smallEmptyLot.get(remained);
        int largeLotOriginalRemained = largeParkedLot.get(remained);
        assertThat(superParkingBoy.park(new Car()), is(true));
        int smallLotCurrentRemained = smallEmptyLot.get(remained);
        int largeLotCurrentRemained = largeParkedLot.get(remained);
        assertThat(smallLotCurrentRemained, is(smallLotOriginalRemained - 1));
        assertThat(largeLotCurrentRemained, is(largeLotOriginalRemained));
    }

    @Test
    public void should_parking_manager_assign_to_boy_with_max_remained_lot_to_park() {
        ParkingLot parkingLot = getParkingLotWithCapacityAndParkedSize(10, 1);
        Parker parkingManager = new Parker(asList(smartParkingBoy, superParkingBoy, parkingLot), maxRemainedSelector);

        int superParkingBoyOriginalRemained = superParkingBoy.get(remained);
        assertThat(parkingManager.park(new Car()), is(true));
        int superParkingBoyCurrentRemained = superParkingBoy.get(remained);
        assertThat(superParkingBoyCurrentRemained, is(superParkingBoyOriginalRemained - 1));
    }
}
