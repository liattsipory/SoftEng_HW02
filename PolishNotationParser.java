public class PolishNotationParser extends ExpressionParser {
static final int SYMBOL_BOUND = 48;
static final int DOT = '.';

    @Override
    public Expression parse(String string) {
        Expression finalExpression;
        String[] input = string.split("[ ]", 0); // dont we need ( ) ?
        int len = input.length;
        if (len == 1) finalExpression = singleStringToExp(input[0]);
        else {
//            String[] tmp = new String[len];
            int operators_num = countOperators(input, len);
            for (int i = 1; i <= operators_num; i++) {
                calc_app(input, len);


            }
        }
        return finalExpression;
    }

    private static Double calc_app(String[] input, int len) { //I know its not really good right know i have to leave
        Double result = 0.0;
        for (int j= len-1; j>1; j--) {
            if (input[j]=="-u" && !isOperator(input[j+1])) {
                Expression val = singleStringToExp(input[j+1]);
                Expression expression = new UnaryMinus(val);
                result = expression.evaluate();
            }
            if (!isOperator(input[j]) && !isOperator(input[j+1]) && isOperator(input[j+2])) {
                Expression val1 = singleStringToExp(input[j]);
                Expression val2 = singleStringToExp(input[j+1]);
                String curr_operator = input[j+2];
                calculator(val1, val2, curr_operator);
            } else continue;
        }
    }

    private static Double calculator(Expression val1, Expression val2, String operator){
        Expression curr_expression;
        Double result = 0.0;
        if (operator == "*"){
            curr_expression = new Multiplication(val1,val2);
            result = curr_expression.evaluate();
        }
        if (operator == "+"){
            curr_expression = new Addition(val1,val2);
            result = curr_expression.evaluate();
        }
        if (operator == "-"){
            curr_expression = new Subtraction(val1,val2);
            result = curr_expression.evaluate();
        }
        if (operator == "/"){
            curr_expression = new Division(val1,val2);
            result = curr_expression.evaluate();
        }
        return result;
    }

//    private String[] create_operators_arr(String[] operators_arr, int operators_num, String[] input) {
//        for (int i = 0; i < operators_num; i++) {
//            operators_arr[i] =
//        }

        private static int countOperators (String[]input,int len){
            int result = 0;
            for (int i = 0; i < len; i++) {
                if (isOperator(input_str[i])) result += 1;
            }
            return result;
        }


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