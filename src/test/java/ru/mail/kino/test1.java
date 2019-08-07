package ru.mail.kino;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class test1 {
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
    private WebElement Kurskaya;
    @FindBy(xpath = "//form[@class='js-module']//*[contains(@placeholder,'Все жанры')]")
    private WebElement Janr;
    @FindBy(xpath = "//*[@class='checkbox__inner']/span[contains(.,'драма')]/../..")
    private WebElement DramaSelect;
    @FindBy(xpath = "//*[@class='checkbox__inner']/span[contains(.,'комедия')]/../..")
    private WebElement ComedySelect;
    @FindBy(xpath = "//*[@class='checkbox__inner']/span[contains(.,'Только сеансы в 2D')]/../..")
    private WebElement onlyTwoD;
    @FindBy(name ="clb6796813")
    private WebElement Search;

    public void goMail() {
        driver.get(url);
            System.out.println("a");
    }
    public void vKino() throws InterruptedException {
        vKino.click();
        Thread.sleep(500);
    }

    public void dayWhen() throws InterruptedException {
        dayWhen.click();
        dayList.click();
        Thread.sleep(500);
    }
    public void metroSet() throws InterruptedException {
        metroSe.clear();
        metroSe.sendKeys("Курская");
        Thread.sleep(1000);
        Kurskaya.click();
    }
    public void janr()throws InterruptedException {
        Janr.click();
        Thread.sleep(500);
        DramaSelect.click();
        Thread.sleep(500);
        ComedySelect.click();
        Thread.sleep(500);
    }
    public void onlyTwoD() throws InterruptedException{
        onlyTwoD.click();
        Thread.sleep(500);
    }

    public void Search() throws InterruptedException {
        Search.click();
        Thread.sleep(500);
    }


    public test1(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
