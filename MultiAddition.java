public class MultiAddition extends Expression {
    private Expression[] expressions;
    private double value;

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







