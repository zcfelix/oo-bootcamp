package parking;

import help.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static help.TestHelper.getFullParkingLot;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static parking.WithParkingCapability.Usage.remained;

public class ParkingLotTest {

    private Car car;
    private final WithParkingCapability parkingLot = new ParkingLot(1);

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void should_park_car_when_not_full() {
        assertThat(parkingLot.park(car), is(true));
    }


    @Test
    public void should_not_park_car_when_full() {
        assertThat(getFullParkingLot().park(car), is(false));
    }

    @Test
    public void should_pick_car_after_parking() {
        parkingLot.park(car);
        assertThat(parkingLot.pick(car), is(true));
    }

    @Test
    public void should_not_pick_when_car_not_in_lot() {
        assertThat(parkingLot.pick(new Car()), is(false));
    }

    @Test
    public void should_get_capacity_of_a_parkingLot() {
        assertThat(parkingLot.get(remained), is(1));
        parkingLot.park(new Car());
        assertThat(parkingLot.get(remained), is(0));
    }
}
