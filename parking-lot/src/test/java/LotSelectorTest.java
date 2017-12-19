import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LotSelectorTest {

    private List<ParkingLot> lots;
    private ParkingLot fullLot;
    private ParkingLot emptyLot;
    private ParkingLot maxCapacityLot;

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
        assertThat(LotSelector.firstAvailableSelector.select(lots).get(), is(emptyLot));
    }

    @Test
    public void should_return_max_remained_capacity_lot_when_use_max_remained_first_selector() {
        assertThat(LotSelector.maxRemainedFirst.select(lots).get(), is(maxCapacityLot));
    }

    @Test
    public void should_return_max_remained_rate_lot_when_use_max_remained_rate_first_selector() {
        maxCapacityLot.park(new Car());
        assertThat(LotSelector.maxRemainedRateFirst.select(lots).get(), is(emptyLot));
    }
}
