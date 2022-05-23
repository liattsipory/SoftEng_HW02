public class MultiAddition extends Expression {
    private double value;
    private String printedValue;

    public MultiAddition(Expression... values) {
        int sum = 0;
        for (Expression value : values) {
            sum += value.evaluate();
        }
        this.value = sum;
        for (Expression value : values) {
            String string_val = value.toString();
            this.printedValue = String.join(")+(", string_val);
        }

        }
        @Override
        public double evaluate () {
            return this.value;
        }

        @Override
        public String toString () {
            return this.printedValue;
        }
    }
//    public MultiAddition() {
//        this.value = 0;
//        this.printedValue = "";





}
