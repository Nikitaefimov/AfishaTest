package ru.mail.kino;
import org.junit.Test;

public class Start extends DriverSetup {
    @Test
    public void testMail() throws InterruptedException {
            test1 test = new test1(DriverSetup.driver);
            test.goMail();
            test.vKino();
            test.dayWhen();
            test.metroSet();
            test.janr();
            test.onlyTwoD();
            test.Search();
        }


}
