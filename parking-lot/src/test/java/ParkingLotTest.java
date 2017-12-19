import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private Car car;
    private final ParkingLot parkingLot = new ParkingLot(1);

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
        Car car = new Car();
        assertThat(TestHelper.getFullParkingLot().park(car), is(false));
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
        assertThat(parkingLot.getRemained(), is(1));
        parkingLot.park(new Car());
        assertThat(parkingLot.getRemained(), is(0));
    }
}
