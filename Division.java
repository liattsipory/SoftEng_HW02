public class Division extends Multiplication {
    private double value;
    private String printedValue;

    public Division (Expression val1, Expression val2) {
        super(val1, new DoubleLiteral(1/val2.evaluate()));
    }

    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}