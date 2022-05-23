public class RoundedExpression extends Expression {
    private double roundedValue;
    private String printedValue;

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
