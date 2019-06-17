import org.junit.jupiter.api.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThirdCalcTest {
//    private Calculator calculator;

    @BeforeAll
    public void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterAll
    public void afterClass() {
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
    public void calc() {
        System.out.println("calc method test");
    }
}
