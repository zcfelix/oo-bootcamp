import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ParkingBoy {

    private LotSelector lotSelector;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(LotSelector lotSelector, ParkingLot... parkingLots) {
        this.lotSelector = lotSelector;
        this.parkingLots = new ArrayList<>();
        this.parkingLots.addAll(asList(parkingLots));
    }

    public boolean park(Car car) {
        return lotSelector.select(parkingLots).map(p -> p.park(car)).orElse(false);
    }

    public boolean pick(Car car) {
        return parkingLots
                .stream()
                .anyMatch(p -> p.pick(car));
    }
}
