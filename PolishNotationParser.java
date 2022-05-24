public class PolishNotationParser extends ExpressionParser {
static final int SYMBOL_BOUND = 48;
static final int DOT = '.';

    @Override
    public Expression parse(String string) {
        Expression finalExpression;
        String[] input = string.split(" ");
        int len = input.length;
        if (len == 1) finalExpression = singleStringToExp(input[0]);
        else {
            Expression[] helperArray = new Expression[len];
            int pointer = 0;
            for (int i = len-1; i >=0; i--) {
                if (!isOperator(input[i])) {
                    helperArray[pointer] = singleStringToExp(input[i]);
                    pointer += 1;
                }
                else if (input[i].equals("-u")) {
                    Expression[] toCalc = {helperArray[pointer-1]};
                    pointer -= 1;
                    helperArray[pointer-1] = calculator(input[i], toCalc);
                }
                else {
                    Expression[] toCalc = {helperArray[pointer-1], helperArray[pointer-2]};
                    pointer -= 1;
                    helperArray[pointer] = calculator(input[i], toCalc);
                }

            }
            finalExpression = helperArray[pointer];
        }
        return finalExpression;
    }

//    private static Double calc_app(String[] input, int len) { //I know its not really good right know i have to leave
//        Double result = 0.0;
//        for (int j= len-1; j>1; j--) {
//            if (input[j]=="-u" && !isOperator(input[j+1])) {
//                Expression val = singleStringToExp(input[j+1]);
//                Expression expression = new UnaryMinus(val);
//                result = expression.evaluate();
//            }
//            if (!isOperator(input[j]) && !isOperator(input[j+1]) && isOperator(input[j+2])) {
//                Expression val1 = singleStringToExp(input[j]);
//                Expression val2 = singleStringToExp(input[j+1]);
//                String curr_operator = input[j+2];
//                calculator(val1, val2, curr_operator);
//            } else continue;
//        }
//    }

    private static Expression calculator(String operator, Expression... vals){

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


//    private static int countOperators(String[]input,int len){
//        int result = 0;
//        for (int i = 0; i < len; i++) {
//            if (isOperator(input[i])) result += 1;
//           }
//        return result;
//    }
//

    private static boolean isOperator(String string) {
        if (string == null) return false;
        String[] operators = {"+", "-", "*", "/", "-u"};
        for (String operator : operators) {
            if (string.equals(operator)) return true;
        }
        return false;
    }

    private static boolean isDouble(String string) {
        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == DOT) return true;
        }
        return false;
    }

    private static Expression singleStringToExp(String singleString) {
        if (isDouble(singleString)) return new DoubleLiteral(Double.parseDouble(singleString));
        else return new IntegerLiteral(Integer.parseInt(singleString));
    }

}