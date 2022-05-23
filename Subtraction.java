public class Subtraction extends Addition {
    private double value;
    private String printedValue;

    public Subtraction (Expression val1, Expression val2) {
        super(val1, new UnaryMinus(val2));
    }

    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}