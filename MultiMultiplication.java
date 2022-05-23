public class MultiMultiplication extends Expression{
    private double value;
    private String printedValue;

    public MultiMultiplication(Expression... values) {
        double result = 1;
        this.printedValue = "(";
        for (Expression value : values) {
            result *= value.evaluate();
        }
        this.value = result;
        int len = values.length;
        for (int i = 0; i < len-1; i++) {
            this.printedValue += values[i].toString() + " * ";
        }
        this.printedValue += values[len-1].toString() + ")";

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
