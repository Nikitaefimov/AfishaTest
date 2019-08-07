package ru.mail.kino;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Logger;

public class Start extends DriverSetup {
        private static Logger log = Logger.getLogger(Start.class.getName());

        @Test
    public void testMail() {
            test1 test = new test1(DriverSetup.driver);
            test.goMail();
                log.info("Переход на сайт выполнен");
            test.vKino();
                log.info("Произошло нажатие кнопки 'В кино'");
            test.dayWhen();
                log.info("Произошел выбор дня");
            test.metroSet();
                log.info("Произошел выбор станции метро");
            test.janr();
                log.info("Произошел выбор жанра");

                String Drama1 = test1.dramaSelect();
                Assert.assertEquals("драма",Drama1);
                log.info("Выполнена проверка Драмы");

                String Comedy1 = test1.comedySelect();
                Assert.assertEquals("комедия",Comedy1);
                log.info("Выполнена проверка Комедии");

                log.info("Выбраны оба жанра Драма и Комедия");

            test.onlyTwoD();
                log.info("Произошло заполнение чекбокса 'Только 2-д'");
            test.Search();
                log.info("Выполнено нажатие кнопки 'Поиск'");

            CheckPage check = new CheckPage(DriverSetup.driver);

                String titleAssert = "Киноафиша Москвы - Кино Mail.ru";
                Assert.assertEquals(CheckPage.title(),titleAssert);
                log.info("Выполнена проверка тайтла");

                String metro = test1.Kurskaya();
                Assert.assertEquals("×\n" + "Курская",metro);
                log.info("Выполнена проверка станции");

                String movieDay = CheckPage.tomorrowtwo();
                Assert.assertEquals("Завтра",movieDay);
                log.info("Выполнена проверка дня");

                check.twoIsD();
                log.info("Выполнена полная проверка. Функционал соответствует требованиям");
    }
}
