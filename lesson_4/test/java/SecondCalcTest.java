import org.junit.jupiter.api.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondCalcTest {
//    private Calculator calculator;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

//    @BeforeEach
//    public void initTest() {
//        calculator = new Calculator();
//    }
//
//    @AfterEach
//
//    public void afterTest() {
//        calculator = null;
//    }

    @Test
    public void getOperation() {
        System.out.println("getOperation method test");
    }
}
