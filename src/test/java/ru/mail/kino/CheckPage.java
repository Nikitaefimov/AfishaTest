package ru.mail.kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class CheckPage extends DriverSetup {
    //   Проверки на:
    //1. Находимся на нужной странице =  "Киноафиша Москвы - Mail.ru Кино"
    private String title = "Киноафиша Москвы - Кино Mail.ru";
    private String actualTitle = DriverSetup.driver.getTitle();
    private boolean titleproverka = actualTitle.equals(title);
    //2. Выбран день "Завтра"
    private String tomorrowtwo = DriverSetup.driver.findElement(By.xpath("//div[(@class='input-group input-group_fixed')]//div[@class='dropdown__text js-dates__title']")).getText();
    private boolean expectedDayTomorrow = tomorrowtwo.equals("Завтра");
    //3. Выставлена станция "Курская" кольцевой линии
    private String metroXpathCheck = "//div[@class='input-group__item']//*[@data-id='68']";
    private Boolean meto = DriverSetup.driver.findElements(By.xpath(metroXpathCheck)).size() > 0;
    //4. Выставлен жанр "Драма"
    private Boolean testOne = DriverSetup.driver.findElements(By.xpath("//div[@class='input__tags-inner js-filter_selected_list']//*[@data-value='1']")).size() > 0;
    //5. Выставлен жанр "Комедия"
    private Boolean testTwo = DriverSetup.driver.findElements(By.xpath("//div[@class='input__tags-inner js-filter_selected_list']//*[@data-value='3']")).size() > 0;
    //6. Выставлен чекбокс "Только сеансы в 2D"
    private Boolean twoIsDCheck = DriverSetup.driver.findElements(By.xpath("//div[@class='checkbox checkbox_colored margin_right_20']//input[@checked='checked']")).size() > 0;

    public CheckPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Логирование в консоль
    private static Logger log = Logger.getLogger(CheckPage.class.getName());

    //  1. Проверка тайтла
    public void titleCheck() {
        if (titleproverka) {
            log.info("check title = TRUE");
        } else {
            log.info("check title = FALSE");
        }
    }

    //   2. Выбор дня "Завтра"
    public void tomorrowtwow() {
        if (expectedDayTomorrow) {
            log.info("Day 'Tomorrow' is selected: TRUE");
        } else {
            log.info("Day 'Tomorrow' is selected: FALSE");
       }
    }

    //3. Выставлена станция "Курская" кольцевой линии
    public void metrometro() {
        if (meto) {
            log.info("Metro 'Kursckay' is selected: TRUE");
        } else {
            log.info(" Metro 'Kursckay' is selected: FALSE");
        }
    }

    //4. Выставлен жанр "Драма"
    public void dramaCheck() {
        if (testOne) {
            log.info("Genre 'Drama' is selected: TRUE");
        } else {
            log.info("Genre 'Drama' is selected: FALSE");
        }
    }

    //5. Выставлен жанр "Комедия"
    public void comedyCheck() {
        if (testTwo) {
            log.info("Genre 'Comedy' is selected: TRUE");
        } else {
            log.info("Genre 'Comedy' is selected: FALSE");
        }
    }

    //6. Выставлен и "Драма" и "Комедия"
    public void testTTest() {
        if (testOne && testTwo) {
            log.info("Genre 'Drama' and 'Comedy' is selected: TRUE");
        } else {
            log.info("Genre 'Drama' and 'Comedy' is selected: FALSE");
        }
    }

    //6. Выставлен чекбокс "Только сеансы в 2D"
    public void twoIsD() {
        if (twoIsDCheck) {
            log.info("CheckBox 2d is select= TRUE");
        } else {
            log.info("CheckBox 2d is selected= FALSE");
        }
    }

    //6. Все ли выставлено?
    public void finalCheck() {
    //    if (twoIsDCheck && testOne && testTwo && meto && expectedDayTomorrow) {
        if (twoIsDCheck && testOne && testTwo && meto && expectedDayTomorrow) {
            log.info("Final check :TRUE - Функционал соответствует требованиям");
        } else {
            log.info("Final check :FALSE - Функционал не соответствует требованиям");
        }
    }
}
