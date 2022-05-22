public class RoundedExpression extends Expression {
    private double value;
    private String printedValue;
    private int bound;

    public RoundedExpression(Expression number, int bound) {
        this.bound = bound;
        double exp = Math.pow(10, bound);
        this.value = (Math.round(number.evaluate()*exp))/exp;
        this.printedValue = number.toString();
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
