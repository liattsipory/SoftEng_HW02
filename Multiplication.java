public class Multiplication extends MultiMultiplication {
    private double value;
    private String printedValue;

    public Multiplication (Expression val1, Expression val2) {
        super(val1, val2);
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}