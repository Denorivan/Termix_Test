package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestForScrewdrivers {
    @Test
    public static void runThirdTest() {


        System.setProperty("webdriver.chrome.driver", "D:\\Programing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kulibin.com.ua");

        WebElement elektroInstrument = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        elektroInstrument.click();

        WebElement Screwdrivers = driver.findElement(By.xpath("//a[@title='Шуруповерты']"));
        Screwdrivers.click();
        System.out.println();
        System.out.println("First page: ");
        listForProducts(driver);


        WebElement twoPages = driver.findElement(By.cssSelector("[title='Страница 2']"));
        twoPages.click();
        System.out.println();
        System.out.println("Second page: ");
        listForProducts(driver);

        System.out.println();
        System.out.println("Third page: ");
        WebElement threePages = driver.findElement(By.cssSelector("[title='Страница 3']"));
        threePages.click();
        listForProducts(driver);


        End(driver);
    }

    public static void listForProducts(WebDriver driver) {
        List<WebElement> findProductInPage = driver.findElements(By.className("js-product"));
        for (WebElement oneItem : findProductInPage) {
            WebElement flagFind = oneItem.findElement(By.cssSelector(".item-brand-country > img"));
            String imgSrc = flagFind.getAttribute("src");
            if (imgSrc.endsWith("/United_states.jpg")) {
                String nameElement = oneItem.findElement(By.cssSelector("h4.s_title")).getText();
                System.out.println(nameElement);
            }
        }
    }

    public static void End (WebDriver driver) {
        driver.close();
    }
}


