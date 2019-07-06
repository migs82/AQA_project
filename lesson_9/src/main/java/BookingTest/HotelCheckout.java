package BookingTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelCheckout {

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
    private WebElement selectHotel;
    @FindBy(xpath = ".//div[@id='wrap-hotelpage-top']//button[@id='hp_book_now_button']")
    private WebElement order;
    @FindBy(xpath = "(.//table[@class=\"hprt-table  \"]//tbody//tr//td)[5]//div//select")
    private WebElement selectQofRooms;
    @FindBy(xpath = "//select[class='hprt-nos-select']//option[contains(text(),'2')]")
    private WebElement romsQuanttity;
    @FindBy(xpath = ".//div[@class='hprt-reservation-cta']//button")
    private WebElement orderRoom;
    @FindBy(xpath = "//*[@id=\"bp_travel_purpose_business\"]")
    private WebElement tripReason;
    @FindBy(xpath = ".//div[@class=\"name\"]//select")
    private WebElement sex;
    @FindBy(xpath = ".//*[@id=\"booker_title\"]/option[2]")
    private WebElement prefics;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "email_confirm")
    private WebElement confirmEmail;
    @FindBy(xpath = "(.//button)[1]")
    private WebElement nextStep;
    @FindBy(id = "phone")
    private WebElement phone;
    @FindBy(id = "cc_type")
    private WebElement typeCard;
    @FindBy(xpath = "(.//select[@id=\"cc_type\"])//option[3]")
    private WebElement cardVisa;
    @FindBy(id = "cc_number")
    private WebElement cardNumber;
    @FindBy(id = "ccYear")
    private WebElement cardMonth;
    @FindBy(xpath = "(.//select[@id='ccYear'])//option[2]")
    private WebElement cardYear;
    @FindBy(id = "cc_cvc")
    private WebElement cardCvc;
    @FindBy(xpath = "//*[@id=\"bookwrapper_cell\"]/div[4]/div[1]/button[2]")
    private WebElement finalOrder;
    @FindBy(xpath = "//*[@id=\"b2confirmationPage\"]/div[8]/button")
    private WebElement closeWindow;

    public HotelCheckout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void findHotelRoom(String enterCity) {
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
        selectHotel.click();
    }

    public void orderHotelRoom(String lastname, String emails, String phones, String numberCard, String numberCVC) {
        order.click();
        selectQofRooms.click();
        romsQuanttity.click();
        orderRoom.click();
        tripReason.click();
        sex.click();
        prefics.click();
        lastName.sendKeys(lastname);
        email.sendKeys(emails);
        confirmEmail.sendKeys(emails);
        nextStep.click();
        phone.sendKeys(phones);
        typeCard.click();
        cardVisa.click();
        cardNumber.sendKeys(numberCard);
        cardNumber.sendKeys(numberCard);
        cardNumber.sendKeys(numberCard);
        cardNumber.sendKeys(numberCard);
        cardMonth.click();
        cardYear.click();
        cardCvc.sendKeys(numberCVC);
        finalOrder.click();
        closeWindow.click();
    }
}
