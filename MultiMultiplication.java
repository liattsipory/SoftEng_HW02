public class MultiMultiplication extends Expression{
    private double value;
    private String printedValue;

    public MultiMultiplication(Expression... values) {
        int result = 1;
        for (Expression value : values) {
            result *= value.evaluate();
        }
        this.value = result;
        for (Expression value : values) {
            String string_val = value.toString();
            this.printedValue = String.join("*", string_val);
        }

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
