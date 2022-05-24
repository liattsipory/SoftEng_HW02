public class Division extends Expression{
    /**
     * This class represents an arithmetical expression that
     * results after dividing one expression by the other.
     */
    private double value;
    private String printedValue;

    /**
     * This constructs the Division object.
     * @param val1 - The expression that is the dividend.
     * @param val2 - The expression that is the divisor.
     */
    public Division(Expression val1, Expression val2) {
        this.value = val1.evaluate() / val2.evaluate();
        this.printedValue = "(" + val1 + " / " + val2 + ")";
    }

    /**
     * Overriding evaluate of Expression.
     * @return - The value of the division expression.
     */

    @Override
    public double evaluate () {
        return this.value;
    }

    /**
     * Overriding toString of Expression.
     * @return - a string that represents the division expression.
     */

    @Override
    public String toString () {
        return this.printedValue;
    }
}
