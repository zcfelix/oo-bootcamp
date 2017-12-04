public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEvens() {
        int count = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int countOdds() {
        int count = 0;
        for (int i : numbers) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public int countNegatives() {
        int count = 0;
        for (int i : numbers) {
            if (i < 0) {
                count++;
            }
        }
        return count;
    }

    public int countPositives() {
        int count = 0;
        for (int i : numbers) {
            if (i > 0) {
                count++;
            }
        }
        return count;
    }
}
