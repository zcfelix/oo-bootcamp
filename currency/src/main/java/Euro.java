public class Euro {
    private double value;

    public Euro(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Euro add(Euro euro) {
        return new Euro(value + euro.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Euro euro = (Euro) o;

        return Double.compare(euro.value, value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }
}
