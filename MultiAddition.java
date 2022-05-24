public class MultiAddition extends Expression {
    /**
     * This class represents an arithmetical expression that
     * results after summing two or more expressions.
     */

    private Expression[] expressions;
    private double value;

    /**
     * This contractor expects two or more expressions and creates a new
     *      * expression that represents their sum.
     * @param val1 - The first expression (left edge of expression)
     * @param val2 - The second expression (second after left edge of expression)
     * @param rest - Zero or more expressions added to the first two.
     */
    public MultiAddition(Expression val1, Expression val2, Expression... rest) {
        Expression[] values = new Expression[rest.length+2];
        values[0] = val1;
        values[1] = val2;
        System.arraycopy(rest, 0, values, 2, rest.length);
        this.expressions = values;
        double sum = 0;
        for (Expression value : expressions) {
            sum += value.evaluate();
        }
        this.value = sum;

    }

    public Expression[] getExpressions() {
        return expressions;
    }

    @Override
        public double evaluate () {
            return this.value;
        }

        @Override
        public String toString () {
            String result = "";
            for (int i = 1; i < getExpressions().length; i++) {
                result += " + " + getExpressions()[i].toString();
            }
            return "(" + getExpressions()[0] + result + ")";
        }
    }







