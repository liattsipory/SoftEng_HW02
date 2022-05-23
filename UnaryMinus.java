public class UnaryMinus extends Expression {

    private double value;
    private String printedValue;

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