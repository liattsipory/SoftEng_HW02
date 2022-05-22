public class DoubleLiteral extends Expression{
    private double value;
    private String printedValue;

    public DoubleLiteral(double number) {
        this.value = number;
        printedValue = "(" + number + ")";
    }

    public double getValue() {
        return value;
    }

    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}
