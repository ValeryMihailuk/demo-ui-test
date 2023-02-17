package by.itacademy.valerymihailuk.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonTest {
    ChromeDriver driver;

    @Before
    public void preparation() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(AmazonPage.URL);

    }

    @Test
    public void testOpenAmazon() {

        WebElement textElement = driver.findElement(By.xpath(AmazonPage.X_PATH_COPYRIGTH));
        Assert.assertEquals(AmazonPage.TEXT_COPYRIGHT, textElement.getText());

    }

    @Test
    public void testOpenAmazonCart() {
        WebElement cardInput = driver.findElement(By.xpath(AmazonPage.BTN_CARD));
        cardInput.click();
        WebElement textElement = driver.findElement(By.xpath(AmazonPage.CARD_LOGO));
        Assert.assertEquals("Your Amazon Cart is empty", textElement.getText());

    }

    @Test
    public void testOpenAmazonLoginForm() {

        WebElement cardInput = driver.findElement(By.xpath(AmazonPage.BTN_CARD));
        cardInput.click();
        WebElement signCard = driver.findElement(By.xpath(AmazonPage.CARD_INPUT_SIGN));
        signCard.click();
        WebElement textElementError1 = driver.findElement(By.xpath(AmazonPage.CARD_TEXT));
        Assert.assertEquals("Sign in", textElementError1.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebElement cardInput = driver.findElement(By.xpath(AmazonPage.BTN_CARD));
        cardInput.click();
        WebElement signCard = driver.findElement(By.xpath(AmazonPage.CARD_INPUT_SIGN));
        signCard.click();
        WebElement cardContinue = driver.findElement(By.xpath(AmazonPage.CARD_CONTINUE));
        cardContinue.click();
        WebElement textElementError = driver.findElement(By.xpath(AmazonPage.CARD_ERROR));
        Assert.assertEquals("Enter your email or mobile phone number", textElementError.getText());
    }
@Test
public void amazonInputUserAccount(){
    WebElement cardInput = driver.findElement(By.xpath(AmazonPage.BTN_CARD));
    cardInput.click();
    WebElement signCard = driver.findElement(By.xpath(AmazonPage.CARD_INPUT_SIGN));
    signCard.click();
    WebElement emailInput = driver.findElement(By.xpath(AmazonPage.CARD_EMAIL_INPUT));
    emailInput.sendKeys(AmazonPage.EMAIL);
    WebElement cardContinue = driver.findElement(By.xpath(AmazonPage.CARD_CONTINUE));
    cardContinue.click();
    WebElement passwordInput = driver.findElement(By.xpath(AmazonPage.XPATH_PASSWORD));
    passwordInput.sendKeys(AmazonPage.PASSWORD);
    WebElement passwordContinue = driver.findElement(By.xpath(AmazonPage.XPATH_PASSWORD_SIGN));
   passwordContinue.click();
}
    @After
    public void completionCode() {
        driver.quit();
    }

}
