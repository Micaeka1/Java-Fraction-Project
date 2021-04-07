package fraction;
import static org.junit.Assert.*;
import org.junit.*;
public class FractionImplTest {
    Fraction f1 = new FractionImpl(8, -12);
    Fraction f2 = new FractionImpl(2, 3);
    Fraction f3 = new FractionImpl(11);
    Fraction f4 = new FractionImpl("6/-14");
    Fraction f5 = new FractionImpl(-2,2);

    @Test(expected = ArithmeticException.class)
    public void testExceptionConstructor1(){
        Fraction f = new FractionImpl(4,0);
    }

    @Test(expected = ArithmeticException.class)
    public void testExceptionStringConstructor(){ Fraction f = new FractionImpl("4/0"); }

    @Test
    public void testConstructors(){
        assertEquals(f1.toString(), "-2/3");
        assertEquals(f2.toString(),"2/3");
        assertEquals(f3.toString(),"11");
        assertEquals(f4.toString(), "-3/7");
        assertEquals(f5.toString(),"-1");

    }

    @Test
    public void testAdd1(){
        Fraction fTest1 = f1.add(f2);
        Fraction fTest2 = f3.add(f1);
        Fraction fTest3 = f4.add(f1);
        Fraction fTest4 = f2.add(f1);
        Fraction fTest5 = f4.add(f4);
        assertEquals(fTest1.toString(),"0");
        assertEquals(fTest2.toString(),"31/3");
        assertEquals(fTest3.toString(),"-23/21");
        assertEquals(fTest4.toString(),"0");
        assertEquals(fTest5.toString(),"-6/7");
    }

    @Test
    public void testTOString(){
        assertEquals(f1.toString(), "-2/3");
        assertEquals(f2.toString(),"2/3");
        assertEquals(f3.toString(),"11");
        assertEquals(f4.toString(), "-3/7");

    }

    @Test
    public void testSubtract(){
        Fraction fTest1 = f1.subtract(f2);
        Fraction fTest2 = f3.subtract(f1);
        Fraction fTest3 = f4.subtract(f1);
        Fraction fTest4 = f2.subtract(f1);
        Fraction fTest5 = f4.subtract(f4);
        assertEquals(fTest1.toString(),"-4/3");
        assertEquals(fTest2.toString(),"35/3");
        assertEquals(fTest3.toString(),"5/21");
        assertEquals(fTest4.toString(),"4/3");
        assertEquals(fTest5.toString(),"0");
    }

    @Test
    public void testMultiply(){
        Fraction fTest1 = f1.multiply(f2);
        Fraction fTest2 = f3.multiply(f1);
        Fraction fTest3 = f4.multiply(f1);
        Fraction fTest4 = f2.multiply(f1);
        Fraction fTest5 = f3.multiply(f3);
        assertEquals(fTest1.toString(),"-4/9");
        assertEquals(fTest2.toString(), "-22/3");
        assertEquals(fTest3.toString(),"2/7");
        assertEquals(fTest4.toString(), "-4/9");
        assertEquals(fTest5.toString(), "121");

    }

    @Test
    public void testDivide(){
        Fraction fTest1 = f1.divide(f2);
        Fraction fTest2 = f3.divide(f1);
        Fraction fTest3 = f4.divide(f1);
        Fraction fTest4 = f2.divide(f3);
        Fraction fTest5 = f3.divide(f3);
        assertEquals(fTest1.toString(),"-1");
        assertEquals(fTest2.toString(), "-33/2");
        assertEquals(fTest3.toString(), "9/14");
        assertEquals(fTest4.toString(),"2/33");
        assertEquals(fTest5.toString(),"1");
    }

    @Test
    public void testAbs(){
        Fraction fTest1 = f1.abs();
        Fraction fTest2 = f4.abs();
        Fraction fTest3 = f3.abs();
        Fraction fTest4 = f2.abs();
        Fraction fTest5 = f5.abs();
        assertEquals(fTest1.toString(),"2/3");
        assertEquals(fTest2.toString(),"3/7");
        assertEquals(fTest3.toString(),"11");
        assertEquals(fTest4.toString(),"2/3");
        assertEquals(fTest5.toString(),"1");
    }

    @Test
    public void testNegate(){
        assertEquals(f1.negate().toString(), "2/3");
        assertEquals(f2.negate().toString(),"-2/3");
        assertEquals(f3.negate().toString(), "-11");
        assertEquals(f4.negate().negate().toString(),f4.toString());
        assertEquals(f5.negate().toString(),"1");
    }

    @Test
    public void testInverse(){
        assertEquals(f1.inverse().toString(),"-3/2");
        assertEquals(f2.inverse().toString(), "3/2");
        assertEquals(f3.inverse().toString(), "1/11");
        assertEquals(f3.inverse().inverse().toString(), f3.toString());
        assertEquals(f5.inverse().toString(),"-1");
    }

    @Test
    public void testEquals(){
        assertEquals(f1, f1);
        assertNotEquals(f3, f2);
        assertEquals(f4, new FractionImpl("-3/7"));
        assertNotEquals("11", f3);
        assertNotEquals(f5, -1);


    }

    @Test
    public void testCompareTo(){
        assertEquals(f1.compareTo(f2), -1);
        assertEquals(f1.compareTo(f5),1);
        assertEquals(f5.compareTo(f4),-1);
        assertEquals(f5.compareTo(new FractionImpl(-1)), 0 );
        assertEquals(f3.compareTo(f5), 1);
    }



}
