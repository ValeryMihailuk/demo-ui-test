package by.itacademy.valerymihailuk.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {
    ChromeDriver driver;

    @Before
    public void preparation() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        WebElement textElement = driver.findElement(By.xpath(OnlinerPage.X_PATH_2001_COPYRIGTH));
        Assert.assertEquals("© 2001—2023 Onlíner", textElement.getText());
    }

    @Test
    public void testOpenOnlinerLoginForm() {

        WebElement btmLoginElement = driver.findElement(By.xpath(OnlinerPage.BTN_LOGIN));
        btmLoginElement.click();
        WebElement textElementLogin = driver.findElement(By.xpath(OnlinerPage.LOGIN_LOGO));
        Assert.assertEquals("Вход", textElementLogin.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {

        WebElement btmLoginElement = driver.findElement(By.xpath(OnlinerPage.BTN_LOGIN));
        btmLoginElement.click();
        WebElement btmLoginInput = driver.findElement(By.xpath(OnlinerPage.LOGIN_INPUT));
        btmLoginInput.click();
        WebElement textElementError1 = driver.findElement(By.xpath(OnlinerPage.LOGIN_NIK_NAME_ERROR));
        Assert.assertEquals("Укажите ник или e-mail", textElementError1.getText());
        WebElement textElementError2 = driver.findElement(By.xpath(OnlinerPage.LOGIN_PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", textElementError2.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebElement btmLoginElement = driver.findElement(By.xpath(OnlinerPage.BTN_LOGIN));
        btmLoginElement.click();
        WebElement textLoginInput = driver.findElement(By.xpath(OnlinerPage.LOGIN_NIK_NAME_INPUT));
        textLoginInput.sendKeys(OnlinerPage.EMAIL);
        WebElement btmLoginInput = driver.findElement(By.xpath(OnlinerPage.LOGIN_INPUT));
        btmLoginInput.click();
        WebElement textElementError = driver.findElement(By.xpath(OnlinerPage.LOGIN_PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", textElementError.getText());
    }

    @After
    public void completionCode() {

        driver.quit();
    }
}