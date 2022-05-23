public class Subtraction extends Addition {

    public Subtraction (Expression val1, Expression val2) {
        super(val1, new UnaryMinus(val2));
    }

    @Override
    public String toString() {
        return "(" + getExpressions()[0].toString() + " - " + getExpressions()[1].toString().substring(2);
    }
}