public class PolishNotationParser extends ExpressionParser {

    @Override
    public Expression parse(String string) {
        Expression finalExpression;
        String[] input = string.split(" ");
        int len = input.length;
        if (len == 1) finalExpression = singleStringToExp(input[0]);
        else {
            Expression[] helperArray = new Expression[len];
            int helpPointer = len;
            for (int inputPointer = len-1; inputPointer >=0; inputPointer--) {
                if (!isOperator(input[inputPointer])) {
                    helpPointer -= 1;
                    helperArray[helpPointer] = singleStringToExp(input[inputPointer]);
                }
                else if (input[inputPointer].equals("-u")) {
                    Expression[] toCalc = {helperArray[helpPointer]};
                    helperArray[helpPointer] = calculator("-u", toCalc);
                }
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