package ru.mail.kino;
import java.io.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.IOException;

public class DriverSetup {
private static GeckoDriverService service;
public static WebDriver driver;

    @BeforeClass
    public static void Create() throws IOException {
        service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("c:/geckodriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }
    @Before
    public void SetUp() {
         driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @AfterClass
    public static void stopService() {
        service.stop();
    }
}
