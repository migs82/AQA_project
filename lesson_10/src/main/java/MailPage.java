import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MailPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='b-toolbar__right']//div[@data-name='spam']")
    private WebElement buttonSpam;

    @FindBy(xpath = ".//body[@class='compose__beautiful GlobalOnlineMode layout-fixed g-default-font']/div[@id='ScrollBody']/div[@id='ScrollBodyInner']/div[@id='theme']/div[@class='theme__left']/div[@class='theme__right']/div[@class='theme__top']/div[@class='theme__bottom']/div[@class='theme__left-center']/div[@class='theme__right-center']/div[@class='theme__top-center']/div[@class='theme__bottom-center']/div[@class='theme__center']/div[@class='theme__top-left']/div[@class='theme__top-right']/div[@class='theme__bottom-left']/div[@id='themeInner']/div[@id='LEGO']/div[@class='b-layout b-layout_main']/div[@class='b-layout__col b-layout__col_2_2']/div[@id='b-letters']/div[@class='b-datalists']/div/div[@class='b-datalist b-datalist_letters b-datalist_letters_from']/div[@class='b-datalist__body']/div[1]/div[1]/a[1]/div[1]")
    private WebElement selectCheckBox;
//    @FindBy(xpath = "(.//div[contains (@class, 'avatar')])[1]")
//    private WebElement selectCheckBox;

    @FindBy(xpath = ".//div[@id='theme']//div[5]//div[1]//div[2]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]")
    private WebElement checkBoxInSpam;

    @FindBy(xpath = ".//div[contains (@class, 'avatar')]//div")
    private WebElement CheckBoxStstus;

    @FindBy(xpath = "//span[@class='b-nav__item__text'][contains(text(),'Спам')]")
    private WebElement buttonMoveToSpamFolder;

    @FindBy(xpath = ".//div[@class='list-letter-tip__message' and contains (text(), 'Письма, перемещённые в Спам более месяца назад, будут автоматически удаляться.')]")
    private WebElement expCond;

    @FindBy(xpath = ".//div[@id='b-toolbar__right']//div//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad'][contains(text(),'Не спам')]")
    private WebElement buttonUnspam;

    @FindBy(xpath = ".//span[@class='b-nav__item__text b-nav__item__text_unread'][contains(text(),'Входящие')]")
    private WebElement buttonMoveToInBox;

    @FindBy(xpath = ".//div[@id='b-toolbar__left']//div//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad'][contains(text(),'Написать письмо')]")
    private WebElement buttonNewMail;

    @FindBy(xpath = ".//div[contains(@class,'compose-head__row-wrapper compose-head__row-wrapper_to js-row')]//textarea[contains(@class,'js-input compose__labels__input')]")
    private WebElement toSendField;

    @FindBy(xpath = ".//input[contains(@name,'Subject')]")
    private WebElement themeField;

    @FindBy(xpath = ".//body[contains(@class,'mceContentBody compose2')]")
    private WebElement textMailField;

    @FindBy(xpath = ".//div[@id='b-toolbar__right']//div//span[@class='b-toolbar__btn__text'][contains(text(),'Отправить')]")
    private WebElement buttonSend;

    public MailPage(WebDriver driver) {
        PageFactory.initElements( driver, this );
        this.driver = driver;
    }


    public MailPage selectMailAndMoveToSpam() {
        selectCheckBox.click();
        buttonSpam.click();
        return this;
    }

    public MailPage selectMailAndReturnMailInBox() {
        buttonMoveToSpamFolder.click();
        //добавить рефреш на страницу чере кнопку или команду
        //driver.findElement( By.xpath( "(.//div[contains (@class, 'avatar')])[1]" ) ).click();
        (new WebDriverWait( driver, 10 )).until( ExpectedConditions.urlMatches( driver.getCurrentUrl() ) );
        checkBoxInSpam.click();
        buttonUnspam.click();
        driver.get(driver.getCurrentUrl());
        buttonMoveToInBox.click();
        return this;
    }

    public MailPage createNewMailAndSendGroup(String group, String theme, String text) {
        buttonNewMail.click();
        toSendField.sendKeys( group );
        themeField.sendKeys( theme );
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys("test");
        driver.switchTo().defaultContent();
        (new WebDriverWait( driver, 10 )).until( ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath(".//div[@id='b-toolbar__right']//div//span[@class='b-toolbar__btn__text'][contains(text(),'Отправить')]")) ) );
        buttonSend.click();
        return this;
    }

    public MailPage selectMailByIndex(int index) {
        ArrayList<WebElement> latterLiast = (ArrayList<WebElement>) driver.findElements( By.xpath( ".//div[@class='b-datalist__body'][1]/div[@data-bem=\"b-datalist__item\"]" ) );
        latterLiast.get( index ).findElement( By.xpath( ".//div[@data-bem=\"b-flag\"][@data-act=\"flag\"]" ) ).click();
        return this;
    }

    public MailPage unselectAllMail() throws InterruptedException {
        ArrayList<WebElement> latterList = (ArrayList<WebElement>) driver.findElements( By.xpath( ".//div[@data-bem='b-flag'][@data-act='flag'][@title='Снять флажок']") );
        latterList.addAll(driver.findElements(By.xpath(".//div[@data-bem='b-flag'][@data-act='flag'][@data-title='Снять флажок']")));
        for (int i = 0; i < latterList.size(); i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(latterList.get(i)).click().build().perform();
//            latterList.get(i).click();
//            Thread.sleep(2000);
            }
        return this;
    }


//    public MailPage unselectAllMail() throws InterruptedException {
//        ArrayList<WebElement> latterList = (ArrayList<WebElement>) driver.findElements( By.xpath( ".//div[@class='b-datalist__body'][1]/div[@data-bem='b-datalist__item']"  ) );
//        String attrValue = "Снять флажок";
//        for (int i = 0; i < latterList.size(); i++) {
//            if ( attrValue.equals(latterList.get( i ).getAttribute("title") )) {
//                latterList.get( i ).findElement( By.xpath( ".//div[@data-bem='b-flag'][@data-act='flag'][@title='Снять флажок']" ) ).click();
//                Thread.sleep(5000);
//            }
//        }
//        return this;
//    }


//    public MailPage unselectAllMail() {
//        ArrayList<WebElement> latterLiast = (ArrayList<WebElement>) driver.findElements( By.xpath( ".//div[@class='b-datalist__body'][1]/div[@data-bem=\"b-datalist__item\"]"  ) );
//        String attrValue = "Снять флажок";
//        for (int i = 0; i < latterLiast.size(); i++) {
//            if (attrValue.equals( latterLiast.get( i ).findElement( By.xpath( ".//div[@data-bem=\"b-flag\"][@data-act=\"flag\"][@data-title=\"Снять флажок\"]" ) ))) {
//                latterLiast.get( i ).findElement( By.xpath( ".//div[@data-bem=\"b-flag\"][@data-act=\"flag\"][@data-title=\"Снять флажок\"]" ) ).click();
//            }
//        }
//        return this;
//    }


}
