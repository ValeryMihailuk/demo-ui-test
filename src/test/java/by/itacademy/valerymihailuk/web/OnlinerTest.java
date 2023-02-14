package by.itacademy.valerymihailuk.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
    @Test
    public void testOpenOnliner() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        WebElement textElement = driver.findElement(By.xpath(OnlinerPage.X_PATH_2001_COPYRIGTH));
        Assert.assertEquals("© 2001—2023 Onlíner", textElement.getText());
        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        By btnLoginBy = By.xpath(OnlinerPage.BTN_LOGIN);
        WebElement btmLoginElement = driver.findElement(btnLoginBy);
        btmLoginElement.click();
        WebElement textElementLogin = driver.findElement(By.xpath(OnlinerPage.LOGIN_LOGO));
        Assert.assertEquals("Вход", textElementLogin.getText());
        driver.quit();
    }

   @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        By btnLoginBy = By.xpath(OnlinerPage.BTN_LOGIN);
        WebElement btmLoginElement = driver.findElement(btnLoginBy);
        btmLoginElement.click();
        WebElement btmLoginInput = driver.findElement(By.xpath(OnlinerPage.LOGIN_INPUT));
        btmLoginInput.click();
        WebElement textElementError1 = driver.findElement(By.xpath(OnlinerPage.LOGIN_NIK_NAME_ERROR));
        Assert.assertEquals("Укажите ник или e-mail", textElementError1.getText());
        WebElement textElementError2 = driver.findElement(By.xpath(OnlinerPage.LOGIN_PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", textElementError2.getText());
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        By btmLoginBy = By.xpath(OnlinerPage.BTN_LOGIN);
        WebElement btmLoginElement = driver.findElement(btmLoginBy);
        btmLoginElement.click();
        WebElement textLoginInput = driver.findElement(By.xpath(OnlinerPage.LOGIN_NIK_NAME_INPUT));
        textLoginInput.sendKeys(OnlinerPage.EMAIL);
        WebElement btmLoginInput = driver.findElement(By.xpath(OnlinerPage.LOGIN_INPUT));
        btmLoginInput.click();
        WebElement textElementError = driver.findElement(By.xpath(OnlinerPage.LOGIN_PASSWORD_ERROR));
        Assert.assertEquals("Укажите пароль", textElementError.getText());
        driver.quit();
    }
}