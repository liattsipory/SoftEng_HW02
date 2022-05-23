public class DoubleLiteral extends Expression{
    private double value;

    public DoubleLiteral(double number) {
        this.value = number;
    }

    public double getValue() {
        return value;
    }

    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return "(" + this.value + ")";
    }
}
