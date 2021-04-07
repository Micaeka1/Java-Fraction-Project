package fraction;
public class FractionImpl implements Fraction {

    private int num;
    private int denom;

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    public FractionImpl(int numerator, int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Divided by zero.");
        }
        int numAbs = Math.abs(numerator);
        int demAbs = Math.abs(denominator);
        int gcd = getGCD(numAbs,demAbs);
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

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this(wholeNumber,1);
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        int numerator = stringToNumerator(fraction);
        int denominator = stringToDenominator(fraction);
        if(denominator == 0){
            throw new ArithmeticException("Divided by zero.");
        }
        int numAbs = Math.abs(numerator);
        int demAbs = Math.abs(denominator);
        int gcd = getGCD(numAbs,demAbs);
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

    //Method to find the GCD between two positive integers
     private int getGCD(int numerator, int denominator) {
        int gcd = 1;
        int numAbs = Math.abs(numerator);
        int demAbs = Math.abs(denominator);
        for (int i = 1; i <=numAbs && i <= demAbs ; i++) {
            if (numAbs%i == 0 & demAbs%i == 0)
                gcd = i;
        }
        return gcd;
    }

    private  int getNum(Fraction f) {
        String stringFraction = f.toString();
        return stringToNumerator(stringFraction);
    }
    /* Method to extract the numerator from the fraction in string format, and return it as
        an integer. If the input is a whole number (i.e no "/" present), the
        method returns the whole number as an integer.
     */
    private int stringToNumerator(String fraction){
        String num1 = "";
        if(fraction.contains("/")){
            int i = 0;
            while(fraction.charAt(i) != '/'){
                num1 = num1 + fraction.charAt(i);
                i++;
            }
        }
        else{num1 = fraction;}
        return Integer.parseInt(num1.strip());
    }
    /* Method to extract the denominator from the fraction in sting format, and return it as
        an integer. If the input is a whole number (i.e no "/" present), the
        method returns the integer 1
     */
    private int stringToDenominator(String fraction){
        String num1 = "";
        if(fraction.contains("/")){
            int l = fraction.length();
            int i = 0;
            // Increment i until the "/" is reached in the string
            while(fraction.charAt(i) != '/'){ i++; }
            // Increment i by 1 to start extracting the characters immediately after the "/"
            i++;
            while (i < l){
                num1  = num1 + fraction.charAt(i);
                i++;
            }
        }
        else{num1 = "1";}
        return Integer.parseInt(num1.strip());
    }

    private int getDenom(Fraction f) {
        String stringFraction = f.toString();
        return stringToDenominator(stringFraction);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        int a = num;
        int b = denom;
        int c = getNum(f);
        int d = getDenom(f);
        //(ad + bc)/bd
        int numerator = a*d + b*c;
        int denominator = b*d;
        return new FractionImpl(numerator,denominator);
    }
    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        int a = num;
        int b = denom;
        int c = getNum(f);
        int d = getDenom(f);
        int numerator = a*d - b*c;
        int denominator = b*d;
        return new FractionImpl(numerator,denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        int a = num;
        int b = denom;
        int c = getNum(f);
        int d = getDenom(f);
        int numerator = a*c;
        int denominator = b*d;
        return new FractionImpl(numerator,denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        int a = num;
        int b = denom;
        int c = getNum(f);
        int d = getDenom(f);
        int numerator = a*d;
        int denominator = b*c;
        return new FractionImpl(numerator,denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        int numerator,denominator;
        if(num <0 || denom <0){
            numerator = Math.abs(num);
            denominator = Math.abs(denom);
        }
        else{
            numerator = num;
            denominator = denom;
        }
        return new FractionImpl(numerator,denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(num*-1, denom);
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
        if (obj instanceof Fraction){
            Fraction f = (Fraction) obj;
            return getNum(f) == num && getDenom(f) == denom;
        }
        else{return false;}
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
        int numerator = denom, denominator = num;
        return new FractionImpl(numerator,denominator);
    }

    /**
     * @inheritDoc
     * @return
     */
    @Override
    public int compareTo(Fraction o) {
        float f1 = (float) num/denom;
        float f2 = (float) getNum(o)/getDenom(o);
        return Float.compare(f1,f2);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if(denom == 1){ return String.format("%s",num); }
        else{return String.format("%s/%s",num,denom); }
    }


}