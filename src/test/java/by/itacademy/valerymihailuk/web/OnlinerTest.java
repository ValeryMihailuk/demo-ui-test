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
        WebElement element = driver.findElement(By.xpath(OnlinerPage.X_PATH_2001_COPYRIGTH));
        Assert.assertTrue(element.isDisplayed());
        driver.quit();
    }

    @Test
    public void OnlinerOpenLoginPage() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        By btmLoginBy = By.xpath(OnlinerPage.BTN_LOGIN)
        WebElement element = driver.findElement(By.xpath(OnlinerPage.));
        Assert.assertTrue(element.isDisplayed());
        driver.quit();
    }
}