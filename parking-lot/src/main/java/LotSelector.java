import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

@FunctionalInterface
public interface LotSelector {
    LotSelector firstAvailableSelector = lots -> lots.stream().filter(p -> p.getRemained() > 0).findFirst();
    LotSelector maxRemainedFirst = lots -> lots.stream().max(comparing(ParkingLot::getRemained));
    LotSelector maxRemainedRateFirst = lots -> lots.stream().max(comparing(p -> p.getRemained() * 1.0 / p.getCapacity()));

    Optional<ParkingLot> select(List<ParkingLot> lots);
}
