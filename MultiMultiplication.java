public class MultiMultiplication extends Expression{
    private double value;
    private String printedValue;

    public MultiMultiplication(Expression val1, Expression val2, Expression... rest) {
        Expression[] values = new Expression[rest.length+2];
        values[0] = val1;
        values[1] = val2;
        System.arraycopy(rest, 0, values, 2, rest.length);
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
