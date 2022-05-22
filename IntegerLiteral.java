public class IntegerLiteral extends Expression{
    private int value;
    private String printedValue;

    public IntegerLiteral(int number) {
        this.value = number;
        printedValue = "(" + number + ")";
    }

    public double evaluate() {
       return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}
