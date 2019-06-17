import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @BeforeEach
    public void initTest() {
        calculator = new Calculator();
    }

    @AfterEach

    public void afterTest() {
        calculator = null;
    }

    @Test
    @Disabled("Test - Under construction")
    void getInt() {
    }

    @Test
    public void getOperation() {
        System.out.println("test getOperation");
    }

    @Test
    public void calc() {
        System.out.println("test calc");
    }

    @Test
    void getSum() throws Exception {
        assertEquals(15, calculator.getSum(7, 8));
    }

    @Test
    void getMinus() throws Exception {
        assertEquals(9, calculator.getMinus(17, 8));
    }

    @Test
    void getDivide() throws Exception {
        assertEquals(20, calculator.getDivide(100, 5));
    }


    @RunWith(value = Parameterized.class)
    public class testGetMultiple {
        private int passValue1, passValue2;
        private int expResult;
        private Calculator mp;

        @Parameterized.Parameters
        public Collection set_of_parameters() {
            return Arrays.asList(new Object[][]{
                            {6, 3, 2},
                            {12, 6, 2},
                            {27, 3, 9}
                    }
            );
        }

        public testGetMultiple(int expResult, int passValue1, int passValue2) {
            this.expResult = expResult;
            this.passValue1 = passValue1;
            this.passValue2 = passValue2;
        }

        @Before
        public void setUp() {
            mp = new Calculator();
        }

        @Test
        public void testGetMultiple() {
            assertEquals(expResult, mp.getMultiple(passValue1, passValue2));
        }
    }

    @Test
    @DisplayName("это адская попаболь и страдание  (」°ロ°)」")
    void getPow() throws Exception {
        assertEquals(16, calculator.getPow(4, 2));
    }

    @Test
    void divisionWithException() {
        Assertions.assertThrows(ArithmeticException.class, new Executable() {
            public void execute() throws Throwable {
                calculator.getDivide(15, 0);
            }
        });
    }
}
