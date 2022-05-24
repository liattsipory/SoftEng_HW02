public class DoubleLiteral extends Expression{
    /**
     * This class represents an arithmetical expression that is a double number.
     */
    private double value;

    /**
     * This construct the DoubleLiteral expression.
     * @param number - The value of the DoubleLiteral.
     */

    public DoubleLiteral(double number) {
        this.value = number;
    }

    /**
     * Overriding evaluate of Expression.
     * @return the value of the DoubleLiteral
     */

    @Override
    public double evaluate() {
        return this.value;
    }

    /**
     * Overriding toString of Expression.
     * @return a string that represents this DoubleLiteral.
     */

    @Override
    public String toString() {
        return "(" + this.value + ")";
    }
}
