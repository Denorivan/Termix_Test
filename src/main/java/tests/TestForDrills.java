package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestForDrills {
    @Test
    public static void runSecondTest()   {
        System.setProperty("webdriver.chrome.driver", "D:\\Programing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kulibin.com.ua");

        WebElement elektroInstrument = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        elektroInstrument.click();

        WebElement drills = driver.findElement(By.xpath("//a[@title='Дрели']"));
        drills.click();


        System.out.println("First page");
        List<WebElement> elementsInFirstPage = driver.findElements(By.cssSelector("li span.price"));
        int[] indexElementsInFirstPage = new int[elementsInFirstPage.size()];
        for (int i = 0; i < elementsInFirstPage.size(); i++) {
            System.out.print(i+1 + " ");
        }

        System.out.println();


        System.out.println("Second page");
        WebElement twoPages = driver.findElement(By.cssSelector("[title='Страница 2']"));
        twoPages.click();

        List<WebElement> elementsInSecondPage = driver.findElements(By.cssSelector("li span.price"));
        int[] indexElementsInSecondPage = new int[elementsInSecondPage.size()];
        for (int i = 0; i < elementsInSecondPage.size(); i++) {
            System.out.print(i+1 + " ");
        }
        driver.close();
    }
}
