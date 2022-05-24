public class Multiplication extends MultiMultiplication {
    /**
     * This class represents an arithmetical expression that
     * results after multiplying two expressions.
     * Subclass of MultiMultiplication.
     * @param val1 - first value of multiplication (right side of expression)
     * @param val2 - second value of multiplication (left side of expression)
     */

    public Multiplication(Expression val1, Expression val2) {
        super(val1, val2);
    }
}