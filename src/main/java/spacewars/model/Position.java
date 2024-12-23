package spacewars.model;

public record Position(double x, double y) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return Double.compare(position.x, x) == 0 &&
                Double.compare(position.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int xHash;
        int yHash;

        if (Double.isNaN(x)) {
            xHash = 0; // Treat NaN as hash code 0
        } else if (x == Double.POSITIVE_INFINITY) {
            xHash = 1; // Positive infinity
        } else if (x == Double.NEGATIVE_INFINITY) {
            xHash = -1; // Negative infinity
        } else {
            xHash = Double.hashCode(x); // Normal case
        }

        if (Double.isNaN(y)) {
            yHash = 0; // Treat NaN as hash code 0
        } else if (y == Double.POSITIVE_INFINITY) {
            yHash = 1; // Positive infinity
        } else if (y == Double.NEGATIVE_INFINITY) {
            yHash = -1; // Negative infinity
        } else {
            yHash = Double.hashCode(y); // Normal case
        }

        return 31 * xHash + yHash;
    }


}
