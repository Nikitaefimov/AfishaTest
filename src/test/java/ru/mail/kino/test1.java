package ru.mail.kino;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class test1 {

    public test1(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    private WebDriver driver;

    private String url = "https://kino.mail.ru";

    @FindBy(name = "clb6796617")
    private WebElement vKino;

    @FindBy (xpath = "//div[@class='input-group input-group_fixed']//div[@class='dropdown__field js-dates__toggle']")
    private WebElement dayWhen;

    @FindBy(xpath = "//*[@data-title='Завтра']//..")
    private WebElement dayList;

    @FindBy (xpath = "//div[@class='input-group input-group_fixed']//input[@class='input__field js-suggest__input']")
    private WebElement metroSet;

    @FindBy(xpath = "//form[@class='js-module']//*[contains(@placeholder,'Станции метро')]")
    private WebElement metroSe;

    @FindBy(xpath = "//*[@data-id='68']")
    private static  WebElement Kurskaya;

    @FindBy(xpath = "//form[@class='js-module']//*[contains(@placeholder,'Все жанры')]")
    private WebElement Janr;

    @FindBy(xpath = "//*[@class='checkbox__inner']/span[contains(.,'драма')]/../..")
    private static WebElement DramaSelect;

    @FindBy(xpath = "//*[@class='checkbox__inner']/span[contains(.,'комедия')]/../..")
    private static WebElement ComedySelect;

    @FindBy(xpath = "//*[@class='checkbox__inner']/span[contains(.,'Только сеансы в 2D')]/../..")
    private WebElement onlyTwoD;

    @FindBy(name ="clb6796813")
    private WebElement Search;

    public void goMail() {
        driver.get(url);
    }
    public void vKino() {
        vKino.click();
    }

    public void dayWhen() {
        dayWhen.click();
        dayList.click();
    }

    public void metroSet() {
        metroSe.clear();
        metroSe.sendKeys("Курская");
        Kurskaya.click();
    }

    public void janr() {
        Janr.click();
        DramaSelect.click();
        ComedySelect.click();
    }

    public void onlyTwoD() {
        onlyTwoD.click();
    }

    public void Search() {
        Search.click();
    }

    public static String Kurskaya() {
        String kursk = Kurskaya.getText();
        return kursk;
    }

    public static String dramaSelect() {
        String drama = DramaSelect.getText();
        return drama;
    }

    public static String comedySelect() {
        String comedy = ComedySelect.getText();
        return comedy;
    }
}
