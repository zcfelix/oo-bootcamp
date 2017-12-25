package parking;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static parking.WithParkingCapability.Usage.remained;
import static parking.WithParkingCapability.Usage.remainedRate;

@FunctionalInterface
public interface ParkingSelector {
    ParkingSelector firstAvailableSelector = capabilities -> capabilities
            .stream()
            .filter(p -> p.get(remained) > 0)
            .findFirst();
    ParkingSelector maxRemainedSelector = capabilities -> capabilities
            .stream()
            .filter(p -> p.get(remained) > 0)
            .max(comparing(p -> p.get(remained)));
    ParkingSelector maxRemainedRateSelector = capabilities -> capabilities
            .stream()
            .filter(p -> p.get(remained) > 0)
            .max(comparing(p -> p.get(remainedRate)));

    Optional<WithParkingCapability> select(List<WithParkingCapability> capabilities);
}
