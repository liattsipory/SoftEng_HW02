public class IntegerLiteral extends DoubleLiteral{

    public IntegerLiteral(int number) {
        super(number);
    }

    @Override
    public String toString() {
        return "(" + (int)this.getValue() + ")";
    }
}
