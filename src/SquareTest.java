
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is the unit test for the Square class.
 * 
 * In general, each method of the class being tested should have a corresponding
 * test method in the unit test class. The convention is that the name of the
 * test method is the name of method being tested prefixed with "test". For
 * example, the testToString method in this class is the test corresponding to
 * the toString method in the Square class.
 * 
 */

public class SquareTest {
    /**
     * Default constructor for test class SquareTest
     */
    public SquareTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method. If there is code that must be executed
     * at the start of every test method, put it here to avoid duplication.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method. If there is code that must be executed
     * at the end of every test method, put it here to avoid duplication.
     */
    @After
    public void tearDown() {
    }

    @Test
    public void testAccessors() {
        /**
         * While best practice is for each test method to test only one method of the
         * class being tested, in this case, the getRow, getCol, and getType methods are
         * all simple accessors that just return the value of an instance variable, so
         * it is reasonable to test all three of these methods in the same test method.
         * 
         * The first step in a test method is to create an instance of the class being
         * tested. In this case, we create a Square with row 2, column 3, and type WALL.
         * It is rare that a method can be tested without also invoking other methods of
         * the class being tested. In this case, the constructor of the Square class is
         * invoked to create the Square that we want to test. So, in this test method,
         * we are also testing the constructor of the Square class, in addition to the
         * getRow, getCol, and getType methods.
         * 
         * The next step in a test method is to check that the method being tested
         * returns the expected result. We use the assertEquals method to check that the
         * expected result is equal to the actual result returned by the method being
         * tested. If the expected result is not equal to the actual result, then the
         * test will fail. If we don't invoke some variant of the assertEquals method in
         * a test method, then the test will not actually be testing anything, and it
         * will always pass, even if the code being tested is incorrect. So, it is
         * important to make sure that each test method includes at least one assertion
         * to check that the code being tested is working correctly.
         * 
         */
        Square sq = new Square(2, 3, Square.WALL);

        // The first argument to the assertEquals method is the expected value, and the
        // second argument is the actual value returned by the method being tested. The
        // order of the arguments is important as the assertEquals method will report a
        // failure message that includes the expected and actual values, and it will say
        // something like "expected:<expected value> but was:<actual value>". If the
        // order of the arguments is reversed, then the failure message will be
        // confusing and may make it harder to identify the problem. So, it is important
        // to make sure that the expected value is the first argument and the actual
        // value is the second argument in the assertEquals method. If these two values
        // are not equal, then the test will fail immediately.
        assertEquals(2, sq.getRow());
        assertEquals(3, sq.getCol());
        assertEquals(Square.WALL, sq.getType());
    }

    @Test
    public void testToString() {
        Square sq = new Square(2, 3, Square.WALL);
        assertEquals("#", sq.toString());
        sq = new Square(2, 3, Square.START);
        assertEquals("S", sq.toString());
        sq = new Square(2, 3, Square.EXIT);
        assertEquals("E", sq.toString());
        sq = new Square(2, 3, Square.SPACE);
        assertEquals("_", sq.toString());
    }

    @Test
    public void testEquals() {
        /**
         * It is important to test as many of the behaviors of the method being tested
         * as possible. It is especially important to test edge cases, which are cases
         * that are at the extreme ends of the range of possible inputs. In this case,
         * the equals method should return true when two Squares have the same row,
         * column, and type, and it should return false when any of these three
         * attributes are different. So, we should test all of these cases to make sure
         * that the equals method is working correctly.
         */
        Square sq1 = new Square(2, 3, Square.WALL);
        Square sq2 = new Square(2, 3, Square.WALL);
        assertEquals(sq1, sq2);

        sq2 = new Square(3, 3, Square.WALL);
        assertNotEquals(sq1, sq2);

        sq2 = new Square(2, 2, Square.WALL);
        assertNotEquals(sq1, sq2);

        sq2 = new Square(2, 3, Square.SPACE);
        assertNotEquals(sq1, sq2);
    }
}