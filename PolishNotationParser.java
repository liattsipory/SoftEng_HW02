public class PolishNotationParser extends ExpressionParser {
    /**
     * This class represents an arithmetical expression that
     * results from an arithmetical expression
     * that is given (as a string) in a Polish notation.
     */

    /**
     * This constructor receives a string that holds an arithmetical
     * expression that is written in a Polish notation, and creates
     * an Expression type object that represents the same expression.
     * @param string - The expression written in Polish notation (string).
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
           to the right of the operator
         */
        else {
            /* Using the helperArray as a "stack" that holds the full expression */
            Expression[] helperArray = new Expression[len];
            int helpPointer = len;
            for (int inputPointer = len-1; inputPointer >=0; inputPointer--) {
                /* Transforming numbers into an Expression type and putting them in the "stack" */
                if (!isOperator(input[inputPointer])) {
                    helpPointer -= 1;
                    helperArray[helpPointer] = singleStringToExp(input[inputPointer]);
                }
                /* Creating an UnaryMinus type object with the last expression*/
                else if (input[inputPointer].equals("-u")) {
                    Expression[] toCalc = {helperArray[helpPointer]};
                    helperArray[helpPointer] = calculator("-u", toCalc);
                }
                /* Creating the relevant type object with the last two expressions*/
                else {
                    helpPointer += 1;
                    Expression[] toCalc = {helperArray[helpPointer-1], helperArray[helpPointer]};
                    helperArray[helpPointer] = calculator(input[inputPointer], toCalc);
                }

            }
            finalExpression = helperArray[helpPointer];
        }
        return finalExpression;
    }
}