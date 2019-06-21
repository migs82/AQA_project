import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringTest3 {


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
    public void testEndWith() {
        String str = "www.tut.com";
        String endstr1 = ".com";
        Assert.assertTrue(strop.endWith(str, endstr1));
    }

    @Test
    public void testEmpty() { //Негативный
        String str = "sdfgs";
        Assert.assertFalse(strop.empty(str));
    }

    @Test(enabled = false)       //Ignored
    public void testEmpty2() {
        String str = "sdfgs";
        Assert.assertFalse(strop.empty(str));
    }

    @DataProvider(name = "ourdata")
    public Object[][] testEndWithParam() {
        return new Object[][]{
                {"google.com", ".com"},
                {"tut.by", ".by"},
                {"mail.ru", ".ru"},
        };
    }

    @Test(dataProvider = "ourdata")
    public void testEndWith1(String a, String b) {
        Assert.assertTrue(strop.endWith(a, b));
    }
}
