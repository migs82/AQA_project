package BookingTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking9_2 {
    java.util.Date sDate = new java.util.Date();

    long secDay = 86400000;
    long cdm = sDate.getTime();
    long newDay = cdm - cdm % secDay;
    long strDateArrival = newDay + secDay * 3;
    long strDateDeparture = newDay + secDay * 8;

    @FindBy(xpath = ".//input[@id='ss']")
    private WebElement searchField;
    @FindBy(xpath = ".//i[@class='c2-calendar-close-button-icon']")
    private WebElement searchCloseButton;
    @FindBy(xpath = ".//select[@id='group_adults']")
    private WebElement searchGuests;
    @FindBy(xpath = ".//select[@id='group_adults']/option[@value='3']")
    private WebElement selectGuest;
    @FindBy(xpath = ".//select[@id='no_rooms']")
    private WebElement searchRooms;
    @FindBy(xpath = ".//select[@id='no_rooms']/option[@value='2']")
    private WebElement selectRooms;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement findRoomsBtn;
    @FindBy(xpath = ".//div[@data-placeholder='Дата заезда']")
    private WebElement findDate;
    @FindBy(xpath = ".//td[@data-id=" + strDateArrival + "]")
    private WebElement dateArrivalSelect;
    @FindBy(xpath = ".//div[@data-placeholder='Дата отъезда']")
    private WebElement setDateDeparture;
    @FindBy(xpath = ".//td[@data-id=" + strDateDeparture + "]")
    private WebElement dateDepartureSelect;
    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement findHotel;
    @FindBy(xpath = ".//div[@id='filter_price']//a[4]")
    private WebElement sortByPrice;
    @FindBy(xpath = ".//li[contains(@class,'sort_price')]")
    private WebElement sortByMinPrice;
    @FindBy(xpath = "//div[2]//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//div[2]//span[1]")
    private WebElement selectRoom;

    public Booking9_2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int findHotelRoom(String enterCity) {
        searchField.clear();
        searchField.sendKeys(enterCity);
        searchField.submit();
        searchCloseButton.click();
        searchGuests.click();
        selectGuest.click();
        searchRooms.click();
        selectRooms.click();
        findRoomsBtn.click();
        findDate.submit();
        dateArrivalSelect.click();
        setDateDeparture.click();
        dateDepartureSelect.submit();
        findHotel.click();
        sortByPrice.click();
        sortByMinPrice.click();
        selectRoom.click();
        String roomPrice = selectRoom.getText();
        int resultPrice = Integer.parseInt(roomPrice = roomPrice.substring(4).replaceAll("\\s+", ""));

        return resultPrice;
    }


}
