package visiting;

import org.junit.Before;
import org.junit.Test;
import parking.Parker;
import parking.ParkingLot;
import parking.ParkingSelector;
import parking.WithParkingCapability;

import static help.TestHelper.getParkingLotWithCapacityAndParkedSize;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static parking.ParkingSelector.firstAvailableSelector;
import static parking.ParkingSelector.maxRemainedSelector;

public class VisitorTest {

    private Visitor visitor;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor(0);
    }

    @Test
    public void should_report_parking_lot() {
        WithParkingCapability parkingLot = getParkingLotWithCapacityAndParkedSize(10, 2);
        String report = visitor.report(parkingLot);
        assertThat(report, is("ParkingLot: 2/10"));
    }

    @Test
    public void should_report_parking_boy_with_indent() {
        ParkingLot parkingLot1 = getParkingLotWithCapacityAndParkedSize(10, 2);
        ParkingLot parkingLot2 = getParkingLotWithCapacityAndParkedSize(10, 5);
        Parker parkingBoy = new Parker(asList(parkingLot1, parkingLot2), firstAvailableSelector);
        String expectedReport = "Parker:\n" +
                " ParkingLot: 2/10\n" +
                " ParkingLot: 5/10";
        assertThat(expectedReport, is(visitor.report(parkingBoy)));
    }

    @Test
    public void should_report_parking_manager_with_indent() {
        ParkingLot parkingLotA1 = getParkingLotWithCapacityAndParkedSize(10, 1);
        ParkingLot parkingLotA2 = getParkingLotWithCapacityAndParkedSize(10, 2);
        ParkingLot parkingLotB1 = getParkingLotWithCapacityAndParkedSize(10, 1);
        ParkingLot parkingLotB2 = getParkingLotWithCapacityAndParkedSize(10, 2);
        ParkingLot parkingLotB3 = getParkingLotWithCapacityAndParkedSize(10, 3);
        ParkingLot parkingLot1 = getParkingLotWithCapacityAndParkedSize(100, 1);
        ParkingLot parkingLot2 = getParkingLotWithCapacityAndParkedSize(100, 2);
        Parker boyA = new Parker(asList(parkingLotA1, parkingLotA2), firstAvailableSelector);
        Parker boyB = new Parker(asList(parkingLotB1, parkingLotB2, parkingLotB3), maxRemainedSelector);
        Parker manager = new Parker(asList(boyA, boyB, parkingLot1, parkingLot2), maxRemainedSelector);

        String expectedReport = "Parker:\n" +
                " Parker:\n" +
                "  ParkingLot: 1/10\n" +
                "  ParkingLot: 2/10\n" +
                " Parker:\n" +
                "  ParkingLot: 1/10\n" +
                "  ParkingLot: 2/10\n" +
                "  ParkingLot: 3/10\n" +
                " ParkingLot: 1/100\n" +
                " ParkingLot: 2/100";
        assertThat(visitor.report(manager), is(expectedReport));
    }

}
