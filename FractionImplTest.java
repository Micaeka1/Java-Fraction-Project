package fraction;
import static org.junit.Assert.*;
import org.junit.*;
public class FractionImplTest {
    @Test(expected = ArithmeticException.class)
    public void testExceptionConstructor1(){
        Fraction f = new FractionImpl(4,0);
    }
    @Test(expected = ArithmeticException.class)
    public void testExceptionStringConstructor(){
        Fraction f = new FractionImpl("4/0");

    }

    @Test
    public void testAdd(){
        Fraction f2 = new FractionImpl(2, 3);
        Fraction f3 =  new FractionImpl(8, 12);
        f3 = f3.add(f2);
        assertEquals(f3.toString(),"4/3");

    }



}
