public class RoundedExpression extends DoubleLiteral {
    private double roundedValue;

    public RoundedExpression(Expression number, int bound) {
        super(number.evaluate());
        double exp = Math.pow(10, bound);
        this.roundedValue = (Math.round(number.evaluate()*exp))/exp;
    }

    @Override
    public double evaluate() {
        return this.roundedValue;
    }

}
