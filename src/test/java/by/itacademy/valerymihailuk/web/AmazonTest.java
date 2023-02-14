package by.itacademy.valerymihailuk.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

    @Test
    public void testOpenAmazon() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        WebElement textElement = driver.findElement(By.xpath(AmazonPage.X_PATH_COPYRIGTH));
        Assert.assertEquals(AmazonPage.TEXT_COPYRIGHT, textElement.getText());
        driver.quit();
    }

    @Test
    public void testOpenAmazonCart() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        By btnCardBy = By.xpath(AmazonPage.BTN_CARD);
        WebElement cardInput = driver.findElement(btnCardBy);
        cardInput.click();
        WebElement textElement = driver.findElement(By.xpath(AmazonPage.CARD_LOGO));
        Assert.assertEquals("Your Amazon Cart is empty", textElement.getText());
        driver.quit();
    }

    @Test
    public void testOpenAmazonLoginForm() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        By btnCardBy = By.xpath(AmazonPage.BTN_CARD);
        WebElement cardInput = driver.findElement(btnCardBy);
        cardInput.click();
        WebElement signCard = driver.findElement(By.xpath(AmazonPage.CARD_INPUT_SIGN));
        signCard.click();
        WebElement textElementError1 = driver.findElement(By.xpath(AmazonPage.CARD_TEXT));
        Assert.assertEquals("Sign in", textElementError1.getText());
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        By btnCardBy = By.xpath(AmazonPage.BTN_CARD);
        WebElement cardInput = driver.findElement(btnCardBy);
        cardInput.click();
        WebElement signCard = driver.findElement(By.xpath(AmazonPage.CARD_INPUT_SIGN));
        signCard.click();
        WebElement cardContinue = driver.findElement(By.xpath(AmazonPage.CARD_CONTINUE));
        cardContinue.click();
        WebElement textElementError = driver.findElement(By.xpath(AmazonPage.CARD_ERROR));
        Assert.assertEquals("Enter your email or mobile phone number", textElementError.getText());
        driver.quit();
    }
}
