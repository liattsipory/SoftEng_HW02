public class Subtraction extends Addition {
    /**
     * This class represents an arithmetical expression that
     * results after subtracting two expressions.
     */

    /**
     * The constructor is the same as in "Addition" class, only with the value of
     * Unary Minus applied to the second value.
     * @param val1 - The first argument (right side of expression)
     * @param val2 - The number that is being subtracted from val1
     */
    public Subtraction (Expression val1, Expression val2) {
        super(val1, new UnaryMinus(val2));
    }

    /**
     * Overriding the toString method of "Adding" class, so we don't print the expression with "+".
     * @return The expression as a subtraction expression.
     */
    @Override
    public String toString() {
        return "(" + getExpressions()[0].toString() + " - " + getExpressions()[1].toString().substring(2);
    }
}