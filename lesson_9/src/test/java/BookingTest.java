import BookingTest.Booking9_1;
import BookingTest.Booking9_2;
import BookingTest.HotelCheckout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookingTest {
    private WebDriver driver;
    private Booking9_1 hotelRoom;
    private Booking9_2 hotelRoomMinPrice;
    private HotelCheckout orderHotelRoom;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:/саша/AQA-itacademy/chromedriver.exe");
        driver = new ChromeDriver();
        java.util.Date sDate = new java.util.Date();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        long secDay = 86400000;
        long cdm = sDate.getTime();
        long newDay = cdm - cdm % secDay;
        long strDateArrival = newDay + secDay * 3;
        long strDateDeparture = newDay + secDay * 8;

        driver.get("http://www.booking.com");
        hotelRoom = new Booking9_1(driver);
        hotelRoomMinPrice = new Booking9_2(driver);
        orderHotelRoom = new HotelCheckout(driver);
    }

    @Test
    public void hotelRoomTest() {
        int expectedResult = 5000;
        boolean result = false;
        if (expectedResult > hotelRoom.findHotelRoom("париж"))
            result = true;
        Assert.assertTrue(result);

    }


    @Test
    public void hotelRoom2Test() {
        int expectedResult = 10000;
        boolean result = false;
        if (expectedResult < hotelRoomMinPrice.findHotelRoom("париж"))
            result = true;
        Assert.assertTrue(result);

    }

    @Test
    public void orderHotelRoomTest() {
        orderHotelRoom.findHotelRoom("париж");
        String parentHandle = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
        orderHotelRoom.orderHotelRoom("Gurbanguliberdimuhamedov", "muha@gmail.com", "3752998988", "4242 4242 4242 4242", "424");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

