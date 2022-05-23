public class Division extends Expression{
    private double value;
    private String printedValue;

    public Division(Expression val1, Expression val2) {
        this.value = val1.evaluate() / val2.evaluate();
        this.printedValue = "(" + val1 + " / " + val2 + ")";
    }

    @Override
    public double evaluate () {
        return this.value;
    }

    @Override
    public String toString () {
        return this.printedValue;
    }
}
