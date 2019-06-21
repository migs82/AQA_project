import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StringTest2 {


        public StringOperations strop;

        @BeforeMethod
        public void setUp() {
            strop = new StringOperations();
        }

        @AfterMethod
        public void tearDown() {
            strop = null;
        }

        @Test
        public void testGetConcat() {
            String str1 = "aaa";
            String str2 = "bbb";
            String expectedResult = "aaabbb";
            Assert.assertEquals(expectedResult, strop.getConcat(str1, str2));
        }
}
