abstract public class ExpressionParser {
    static final int DOT = '.';

    public abstract Expression parse(String string);

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

    protected static boolean isOperator(String string) {
        if (string == null) return false;
        String[] operators = {"+", "-", "*", "/", "-u"};
        for (String operator : operators) {
            if (string.equals(operator)) return true;
        }
        return false;
    }

    protected static boolean isDouble(String string) {
        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == DOT) return true;
        }
        return false;
    }

    protected static Expression singleStringToExp(String singleString) {
        if (isDouble(singleString)) return new DoubleLiteral(Double.parseDouble(singleString));
        else return new IntegerLiteral(Integer.parseInt(singleString));
    }
}
