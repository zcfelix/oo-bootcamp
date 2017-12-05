public enum Direction {
    N(0, 1) {
        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }
    }, S(0, -1) {
        @Override
        public Direction left() {
            return E;
        }

        @Override
        public Direction right() {
            return W;
        }
    }, W(-1, 0) {
        @Override
        public Direction left() {
            return S;
        }

        @Override
        public Direction right() {
            return N;
        }
    }, E(1, 0) {
        @Override
        public Direction left() {
            return N;
        }

        @Override
        public Direction right() {
            return S;
        }
    };

    Direction(final int stepOnX, final int stepOnY) {
        this.stepOnX = stepOnX;
        this.stepOnY = stepOnY;
    }

    private int stepOnY;
    private int stepOnX;

    public abstract Direction left();

    public abstract Direction right();

    public int getStepOnY() {
        return stepOnY;
    }

    public int getStepOnX() {
        return stepOnX;
    }
}
