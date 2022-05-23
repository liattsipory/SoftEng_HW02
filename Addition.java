public class Addition extends Expression {
    private double value;
    private String printedValue;

    public Addition(Expression val1, Expression val2) {
        this.value = Double.sum(val1.evaluate(), val2.evaluate());
        printedValue = "(" + val1 + ")"+"+"+"(" + val1 + ")";
    }
    public Addition() {
        this.value = 0;
        printedValue = "";
    }

    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}


