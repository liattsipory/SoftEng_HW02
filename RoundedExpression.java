public class RoundedExpression extends Expression {
    /**
     * This class represents an arithmetical expression that
     * results after rounding an expression with given amount of decimals.
     */
    private double roundedValue;
    private String printedValue;

    /**
     * In this constructor we make sure to round the value of the given expression
     *      as instructed by the input.
     *      Notice that only the value is rounded, the printed value stays untouched.
     * @param number - The original number we want to round.
     * @param bound - The amount of decimals we keep in the rounded expression.
     */
    public RoundedExpression(Expression number, int bound) {
        double exp = Math.pow(10, bound);
        this.roundedValue = (Math.round(number.evaluate()*exp))/exp;
        this.printedValue = number.toString();
    }

    @Override
    public double evaluate() {
        return this.roundedValue;
    }

    @Override
    public String toString(){ return this.printedValue; }
}
