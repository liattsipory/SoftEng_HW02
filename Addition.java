public class Addition extends MultiAddition {
    private double value;
    private String printedValue;

    public Addition(Expression val1, Expression val2) {
        super(val1, val2);
    }
   public Addition() {
      this.value = 0;
      printedValue = "";
    }
    @Override
    public double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.printedValue;
    }
}


