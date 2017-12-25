package parking;

import visiting.Visitor;

import java.util.List;

import static parking.WithParkingCapability.Usage.*;

public class Parker implements WithParkingCapability {

    private ParkingSelector parkingSelector;
    private List<WithParkingCapability> capabilities;


    public Parker(List<WithParkingCapability> capabilities, ParkingSelector parkingSelector) {
        this.capabilities = capabilities;
        this.parkingSelector = parkingSelector;
    }

    @Override
    public boolean park(Car car) {
        return parkingSelector.select(capabilities).map(p -> p.park(car)).orElse(false);
    }

    @Override
    public boolean pick(Car car) {
        return capabilities.stream().anyMatch(p -> p.pick(car));
    }

    public <T> T get(Usage<T> usage) {
        return usage.get(capabilities.stream().mapToInt(p -> p.get(used)).sum(),
                capabilities.stream().mapToInt(p -> p.get(total)).sum());
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public List<WithParkingCapability> getCapabilities() {
        return capabilities;
    }

}
