package fraction;
public class FractionImpl implements Fraction {

    private int num;
    private int denom;
    public FractionImpl(int numerator, int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Divided by zero.");
        }
        int gcd = getGCD(numerator,denominator);
        int numAbs = Math.abs(numerator);
        int demAbs = Math.abs(denominator);
        if ((numerator < 0 && denominator >0) || (numerator > 0 && denominator <0)){
            this.num = (numAbs/gcd)*-1;
            this.denom =demAbs/gcd;
        }
        else if (numerator == 0){
            this.num = 0;
            this.denom = 1;
        }
        else if (numerator < 0){
            this.num = numAbs/gcd;
            this.denom = demAbs/gcd;
        }
        else {
            this.num = numAbs/gcd;
            this.denom = demAbs/gcd;
        }
    }

    public FractionImpl(int wholeNumber) {
        this(wholeNumber,1);
    }

    public FractionImpl(String fraction) {
        int l = fraction.length();
        int i = 0;
        String num1 = "";
        String num2 = "";
        while(fraction.charAt(i) != '/'){
            num1 = num1 + Character.toString(fraction.charAt(i));
            i++;
        }
        i++;
        while (i < l){
            num2  = num2 + Character.toString(fraction.charAt(i));
            i++;
        }
        int numerator = Integer.parseInt(num1.strip());
        int denominator = Integer.parseInt(num2.strip());
        if(denominator == 0){
            throw new ArithmeticException("Divided by zero.");
        }
        int gcd = getGCD(numerator,denominator);
        int numAbs = Math.abs(numerator);
        int demAbs = Math.abs(denominator);
        if ((numerator < 0 && denominator >0) || (numerator > 0 && denominator <0)){
            this.num = (numAbs/gcd)*-1;
            this.denom =demAbs/gcd;
        }
        else if (numerator == 0){
            this.num = 0;
            this.denom = 1;
        }
        else if (numerator < 0){
            this.num = numAbs/gcd;
            this.denom = demAbs/gcd;
        }
        else {
            this.num = numAbs/gcd;
            this.denom = demAbs/gcd;
        }
    }


    private int getGCD(int numerator, int denominator) {
        int gcd = 1;
        int numAbs = Math.abs(numerator);
        int demAbs = Math.abs(denominator);
        for (int i = 1; i <numAbs && i <= demAbs ; i++) {
            if (numAbs%i == 0 & demAbs%i == 0)
                gcd = i;
        }
        return gcd;
    }


    @Override
    public Fraction add(Fraction f) {
        int a = num;
        int b = denom;
        int c = getNum(f);
        int d = getDenom(f);
        //(ad + bc)/bd
        int numerator = a*d + b*c;
        int denominator = b*d;
        Fraction result = new FractionImpl(numerator,denominator);
        return result;
    }

    private  int getNum(Fraction f) {
        return this.num;
    }

    private int getDenom(Fraction f) {
        return denom;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return String.format("%s/%s",num,denom);
    }

}