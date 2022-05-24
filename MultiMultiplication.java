public class MultiMultiplication extends Expression{
    /**
    * This class represents an arithmetical expression that
    * results after multiplying two or more expressions.
    */

    private double value;
    private String printedValue;

    /**
     * This contractor expects two or more expressions and creates a new
     * expression that represents their multiplication.
     * @param val1 The first expression (multiplicand)
     * @param val2 The second expression (multiplier)
     * @param rest Array of zero or more expression (more multiplicands)
     */
    public MultiMultiplication(Expression val1, Expression val2, Expression... rest) {
        /* Creating one combined array of all input*/
        Expression[] values = new Expression[rest.length+2];
        values[0] = val1;
        values[1] = val2;
        System.arraycopy(rest, 0, values, 2, rest.length);
        /* Calculating the result of the expression*/
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
