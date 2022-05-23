public class Multiplication extends Expression {
    private double value;
    private String printedValue;

    public Multiplication (Expression val1, Expression val2) {
        this.value = val1.evaluate() * val2.evaluate();
        printedValue = "(" + val1 + ")"+"*"+"(" + val1 + ")";
    }

    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}