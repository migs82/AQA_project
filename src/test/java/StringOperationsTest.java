import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StringOperationsTest {

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

    @Test
    public void testStringToInt() {
        String str = "6";
        int exres = 6;
        Assert.assertEquals(exres, strop.stringToInt(str));
    }

    @Test
    public void testCharAtString() {
        String str = "abcdefg";
        int n = 3;
        char exres = 'd';
        Assert.assertEquals(exres, strop.charAtString(str, n));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class) // Обработка исключения
    public void testCharAtStringException() {
        String str = "abcdefg";
        int n = 33;
        char exres = 'd';
        Assert.assertEquals(exres, strop.charAtString(str, n));
    }

    @Test
    public void testGetLength() {
        String str = "qwerty";
        int exres = 6;
        Assert.assertEquals(exres, strop.getLength(str));
    }

    @Test
    public void testGetLengthNegativ() { //Негативный
        String str = "qwerty";
        int exres = 66;
        Assert.assertNotEquals(exres, strop.getLength(str));
    }

    @Test
    public void testReplaceChar() {
        String old = "abrakadabra";
        char a = 'a';
        char b = 'b';
        String exres = "bbrbkbdbbrb";
        Assert.assertEquals(exres, strop.replaceChar(old, a, b));
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

//    https://www.tutorialspoint.com/java/lang/java_lang_string.htm

