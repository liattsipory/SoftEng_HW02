public class PolishNotationParser extends ExpressionParser {
static final int SYMBOL_BOUND = 48;
static final int DOT = '.';

    @Override
    public Expression parse(String string) {
        Expression finalExpression;
        String[] input = string.split("[ ]", 0);
        int len = input.length;
        if (len == 1) finalExpression = singleStringToExp(input[0]);
        else {
            int operators = countOperators(input, len);
            for (int i = 1; i <= operators; i++) {

            }
        }
        return finalExpression;
    }

    private static int countOperators(String[] input, int len) {
        int result = 0;
        for(int i = 0; i < len; i++){
           if (isOperator(input[i])) result += 1;
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