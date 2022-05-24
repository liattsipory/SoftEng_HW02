abstract public class ExpressionParser {
    /**
     * An abstract class that represents an arithmetical expression that
     * results from an arithmetical expression that is given (as a string).
     */

    /**
     * Setting final for a dot string. Used in isDouble method.
     */
    static final int DOT = '.';

    /**
     * This is an abastract constructor for an expression parse.
     * receives a string that holds an arithmetical expression that is written.
     */
    public abstract Expression parse(String string);

    /**
     * This method specify which Expression type is given.
     * @param operator a string of the operator of the expression, classifing the type of expression.
     * @param vals An array of the expressions we apply the operation on.
     * @return The result as an Expression type object.
     */

    protected static Expression calculator(String operator, Expression... vals){
        switch (operator) {
            case "*":
                return new Multiplication(vals[0], vals[1]);
            case "+":
                return new Addition(vals[0], vals[1]);
            case "-":
                return new Subtraction(vals[0], vals[1]);
            case "/":
                return new Division(vals[0], vals[1]);
            case "-u":
                return new UnaryMinus(vals[0]);
        }
        return null;
    }

    /**
     * This method determines if the given string is an operator.
     * @param string - The string we want to check.
     * @return -
     *          * True - if it is an operator.
     *          * False - if not.
     */

    protected static boolean isOperator(String string) {
        if (string == null) return false;
        String[] operators = {"+", "-", "*", "/", "-u"};
        for (String operator : operators) {
            if (string.equals(operator)) return true;
        }
        return false;
    }
    /**
     * This method determines if the given string is a representation of a double type,
     * by checking if there is a DOT in the string.
     *
     * @param string - The string we want to check.
     * @return -
     *          * True - if it is a double type.
     *          * False - if not.
     */

    protected static boolean isDouble(String string) {
        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == DOT) return true;
        }
        return false;
    }

    /**
     * This method creates a new Expression based on the given value in a string.
     * @param singleString - string represantation of a number.
     * @return - A new Expression the type that is represented in the string.
     */

    protected static Expression singleStringToExp(String singleString) {
        if (isDouble(singleString)) return new DoubleLiteral(Double.parseDouble(singleString));
        else return new IntegerLiteral(Integer.parseInt(singleString));
    }
}
