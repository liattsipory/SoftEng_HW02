public class UnaryMinus extends Expression {
    /**
     * This class represents an arithmetical expression that
     * results after applying unary minus on an expression.
     */
    private double value;
    private String printedValue;

    /**
     * This constructs the UnaryMinus object based on a given expression.
     * @param val1 - the expression we want to transform.
     *        * The value is the same but with an opposite sign
     *        * The printing is adding another minus ("-") to the original input value.
     */
    public UnaryMinus (Expression val1) {
        this.value = (-1)*val1.evaluate();
        this.printedValue = "(-" + val1.toString() + ")";
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return printedValue;
    }
}