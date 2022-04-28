package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class TestForPerfors {

    @Test
public static void runFirstTest()  throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the number of test repetitions required: ");
    int size = Integer.parseInt(reader.readLine());

    for (int i = 0; i < size; i++) {
        System.setProperty("webdriver.chrome.driver", "D:\\Programing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kulibin.com.ua");

        WebElement elektroInstrument = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        elektroInstrument.click();

        WebElement perforators = driver.findElement(By.xpath("//a[@title='Перфораторы']"));
        perforators.click();

        List<WebElement> listings = driver.findElements(By.xpath("//h4[@class='s_title']"));
        Random random = new Random();
        int randomValue = random.nextInt(listings.size());
        listings.get(randomValue).click();

            if (driver.findElements(By.xpath("//span[@class='item_old_price old-price']")).isEmpty()){
            System.out.println("This item has discount!");
            } else {
                System.out.println("This item hasn't discount!");
                }
            driver.close();
         }
    }
}
