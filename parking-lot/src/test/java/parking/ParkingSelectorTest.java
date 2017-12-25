package parking;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static parking.ParkingSelector.*;

public class ParkingSelectorTest {

    private List<WithParkingCapability> lots;
    private WithParkingCapability fullLot;
    private WithParkingCapability emptyLot;
    private WithParkingCapability maxCapacityLot;

    @Before
    public void setUp() {
        fullLot = new ParkingLot(1);
        fullLot.park(new Car());
        emptyLot = new ParkingLot(2);
        maxCapacityLot = new ParkingLot(20);

        lots = asList(fullLot, emptyLot, maxCapacityLot);
    }

    @Test
    public void should_return_first_available_lot_when_use_first_available_selector() {
        assertThat(firstAvailableSelector.select(lots).get(), is(emptyLot));
    }

    @Test
    public void should_return_max_remained_capacity_lot_when_use_max_remained_first_selector() {
        assertThat(maxRemainedSelector.select(lots).get(), is(maxCapacityLot));
    }

    @Test
    public void should_return_max_remained_rate_lot_when_use_max_remained_rate_first_selector() {
        maxCapacityLot.park(new Car());
        assertThat(maxRemainedRateSelector.select(lots).get(), is(emptyLot));
    }
}
