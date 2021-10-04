import static org.junit.Assert.*;

/**
 * RomanToDecimalTest is a program designed to test different roman numerals to see if they are valid, invalid, logically incorrect or not equal
 * @version Sunday, October 3
 * @author molliedoyle
 */

public class RomanToDecimalTest {

    /**
     * romanToDecimal tests roughly 20 different roman numerals and determines if they are valid, invalid, logically incorrect or not equal
     */
    @org.junit.Test
    public void romanToDecimal() {
        //valid x10
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("XX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("CIX"), 109);
        assertEquals(RomanToDecimal.romanToDecimal("MMCV"), 2105);
        assertEquals(RomanToDecimal.romanToDecimal("IC"), 101);
        assertEquals(RomanToDecimal.romanToDecimal("XVIII"), 18);
        assertEquals(RomanToDecimal.romanToDecimal("MXC"), 1090);
        assertEquals(RomanToDecimal.romanToDecimal("LXIX"), 69);
        assertEquals(RomanToDecimal.romanToDecimal("lxxx"), 80);
        assertEquals(RomanToDecimal.romanToDecimal("DccLxiI"), 762);
        //logically incorrect=> x4
        assertEquals(RomanToDecimal.romanToDecimal("XXXXXXXXXX"), 100);
        assertEquals(RomanToDecimal.romanToDecimal("MXCXCI"), 1201);
        assertEquals(RomanToDecimal.romanToDecimal("MCDCD"), 2000);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        //notEquals x2
        assertNotEquals(RomanToDecimal.romanToDecimal("Joe"), 20);
        assertNotEquals(RomanToDecimal.romanToDecimal("XIV"), 15);
        //invalid x4
        assertEquals(RomanToDecimal.romanToDecimal("yourMom"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("HMMMMMMMM"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("XXXVIn"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("IDKMAN"), -1);
        }
    }
