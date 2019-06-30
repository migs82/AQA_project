import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.lang.String.*;
import java.util.List;

public class Booking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:/саша/AQA-itacademy/chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        java.util.Date sDate = new java.util.Date();
        long secDay = 86400000;
        long cdm = sDate.getTime();
        long newDay = cdm - cdm % secDay;
        long strDateArrival = newDay + secDay * 3;
        long strDateDeparture = newDay + secDay * 8;

        driver.get("https://www.booking.com/");
        WebElement searchField = driver.findElement(By.xpath(".//input[@id='ss']"));
        searchField.sendKeys("Москва");
        searchField.submit();
        WebElement searchCloseButton = driver.findElement(By.xpath(".//i[@class='c2-calendar-close-button-icon']"));
        searchCloseButton.click();
        WebElement searchGuests = driver.findElement(By.xpath(".//select[@id='group_adults']"));
        searchGuests.click();
        WebElement selectGuest = driver.findElement(By.xpath(".//select[@id='group_adults']/option[@value='3']"));
        selectGuest.click();
        WebElement searchRooms = driver.findElement(By.xpath(".//select[@id='no_rooms']"));
        searchRooms.click();
        WebElement selectRooms = driver.findElement(By.xpath(".//select[@id='no_rooms']/option[@value='2']"));
        selectRooms.click();
        WebElement findRooms = driver.findElement(By.xpath(".//button[@type='submit']"));
        findRooms.click();
        WebElement findDate = driver.findElement(By.xpath(".//div[@data-placeholder='Дата заезда']"));
        findDate.submit();
        WebElement dateArrivalSelect = driver.findElement(By.xpath(".//td[@data-id=" + strDateArrival + "]"));
        dateArrivalSelect.click();
        Thread.sleep(2000);
        WebElement setDateDeparture = driver.findElement(By.xpath(".//div[@data-placeholder='Дата отъезда']"));
        setDateDeparture.click();
        Thread.sleep(2000);
        WebElement dateDepartureSelect = driver.findElement(By.xpath(".//td[@data-id=" + strDateDeparture + "]"));
        dateDepartureSelect.submit();
        WebElement findHotel = driver.findElement(By.xpath(".//button[@type='submit']"));
        findHotel.click();
        WebElement enabledHotels = driver.findElement(By.xpath(".//div[@id='hotellist_inner' and @aria-label='Результаты поиска']"));
        //System.out.println(enabledHotels.isDisplayed());
        if (hasElement(enabledHotels)) {
            System.out.println("Отели есть");
        } else {
            System.out.println("Отелей нет");
        }
        WebElement sortByRait = driver.findElement(By.xpath(".//a[contains(text(),'Оценка по отзывам и цена')]"));
        sortByRait.click();
        //---------------Собрал отели в лист, но они записываются не по порядку на странице---------------------
//        List <WebElement> sortResult = driver.findElements(By.xpath(".//div[@id='hotellist_inner']//div[@data-hotelid]"));
//        WebElement firstHotel = sortResult.get(0);
//        String rait = firstHotel.getAttribute("data-score");
//        int raitInd = Integer.parseInt(rait);
//        System.out.println(raitInd);
        //---------------Беру первый отель на странице--------------------------------
        WebElement firstHotel = driver.findElement(By.xpath(".//div[@id='hotellist_inner']//div[2][@data-hotelid]"));
        String rait = firstHotel.getAttribute("data-score");
        int raitInd = Integer.parseInt(rait);
        System.out.println(raitInd);
        if (raitInd >= 9) {
            System.out.println("Рейтинг больше 9");
        } else {
            System.out.println("Рейтинг меньше 9");
        }


    }

    public static boolean hasElement(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignored) {
        }
        return false;
    }


}
