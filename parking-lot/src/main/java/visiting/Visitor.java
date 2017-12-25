package visiting;

import parking.Parker;
import parking.ParkingLot;
import parking.WithParkingCapability;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static parking.WithParkingCapability.Usage.total;
import static parking.WithParkingCapability.Usage.used;

public class Visitor {
    private int indent;

    public Visitor(int indent) {
        this.indent = indent;
    }

    public String visit(ParkingLot parkingLot) {
        return String.format("ParkingLot: %d/%d", parkingLot.get(used), parkingLot.get(total));
    }

    public String visit(Parker parker) {
        StringBuilder builder = new StringBuilder("Parker:\n");
        List<WithParkingCapability> capabilities = parker.getCapabilities();
        for (WithParkingCapability w : capabilities) {
            setIndent(getIndent() + 1);
            builder.append(makeIndent(getIndent())).append(w.accept(this)).append("\n");
            setIndent(getIndent() - 1);
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public String report(WithParkingCapability capability) {
        return capability.accept(this);
    }

    private String makeIndent(int count) {
        return Stream.generate(() -> " ").limit(count).collect(joining());
    }

    private void setIndent(int indent) {
        this.indent = indent;
    }

    public int getIndent() {
        return indent;
    }
}
