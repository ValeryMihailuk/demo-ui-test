package by.itacademy.valerymihailuk.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
    @Test
    public void OnlinerOpenPage() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        WebElement textElement = driver.findElement(By.xpath(OnlinerPage.X_PATH_2001_COPYRIGTH));
        Assert.assertEquals("© 2001—2023 Onlíner", textElement.getText());
        driver.quit();
    }

    @Test
    public void OnlinerOpenLoginPage() {
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
}