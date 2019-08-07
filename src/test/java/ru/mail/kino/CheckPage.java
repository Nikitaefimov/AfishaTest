package ru.mail.kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class CheckPage extends DriverSetup {
    //   Проверки на:
    //1. Выбран ли день "Завтра"
    private static String tomorrowtwo = DriverSetup.driver.findElement(By.xpath("//div[(@class='input-group input-group_fixed')]//div[@class='dropdown__text js-dates__title']")).getText();
    //2. Выставлен ли чекбокс "Только сеансы в 2D"
    private Boolean twoIsDCheck = DriverSetup.driver.findElements(By.xpath("//div[@class='checkbox checkbox_colored margin_right_20']//input[@checked='checked']")).size() > 0;

    public CheckPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Логирование в консоль
    private static Logger log = Logger.getLogger(CheckPage.class.getName());

    //  1. Проверка тайтла
    public static String title() {
        String actualTitle = DriverSetup.driver.getTitle();
        return actualTitle;
    }
    //   2. Выбор дня "Завтра"
    public static  String tomorrowtwo() {
       String tomorrow = tomorrowtwo;
       return tomorrow;
    }

    //3. Выставлен чекбокс "Только сеансы в 2D"
    public void twoIsD() {
            if (twoIsDCheck) {
                log.info("Чекбокс активен");
            }
            else {
            log.info("Чекбокс не активен");
            }
    }
}
