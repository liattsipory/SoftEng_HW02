public class ReversePolishNotationParser extends ExpressionParser {
    /**
     * This class represents an arithmetical expression that
     * results from an arithmetical expression
     * that is given (as a string) in a reverse Polish notation.
     */

    /**
     * This constructor receives a string that holds an arithmetical
     * expression that is written in a reverse Polish notation, and creates
     * an Expression type object that represents the same expression.
     * @param string - The expression written in reverse Polish notation (string).
     * @return Expression type object.
     */
    @Override
    public Expression parse(String string) {
        Expression finalExpression;
        String[] input = string.split(" ");
        int len = input.length;
        /* In case there are no operators - only a number */
        if (len == 1) finalExpression = singleStringToExp(input[0]);
        /* In case there are operators - we create the expression
           that matches the operator, applied on the expressions that are
           to the left of the operator
         */
        else {
            /* Using the helperArray as a "stack" that holds the full expression */
            Expression[] helperArray = new Expression[len];
            int helpPointer = -1;
            for (int inputPointer = 0; inputPointer < len; inputPointer++) {
                if (!isOperator(input[inputPointer])) {
                    helpPointer += 1;
                    helperArray[helpPointer] = singleStringToExp(input[inputPointer]);
                }
                else if (input[inputPointer].equals("-u")) {
                    Expression[] toCalc = {helperArray[helpPointer]};
                    helperArray[helpPointer] = calculator("-u", toCalc);
                }
                else {
                    helpPointer -= 1;
                    Expression[] toCalc = {helperArray[helpPointer], helperArray[helpPointer+1]};
                    helperArray[helpPointer] = calculator(input[inputPointer], toCalc);
                }

            }
            finalExpression = helperArray[helpPointer];
        }
        return finalExpression;
    }

}
