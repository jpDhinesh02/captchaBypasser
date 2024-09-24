package Razorpay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Components;

public class dummy {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = Components.startChrome();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        driver.get("https://www.google.com/recaptcha/api2/demo");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()=\"I'm not a robot\"]"))))
                .click();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@title=\"recaptcha challenge expires in two minutes\"]")));
        System.out.println("Frame switched....");
        Thread.sleep(1500);
        wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//div[@class='button-holder help-button-holder']"))))
                .click();

        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type=\"submit\"]")))).click();
    }
}
