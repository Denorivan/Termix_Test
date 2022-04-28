package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.List;

import static java.lang.Math.ceil;


public class TestForGrinder {
    @Test
    public static void runFourthTest() throws IOException{
        System.setProperty("webdriver.chrome.driver", "D:\\Programing\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kulibin.com.ua");

        WebElement elektroInstrument = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        elektroInstrument.click();

        WebElement grinders = driver.findElement(By.xpath("//a[@title='Болгарки']"));
        grinders.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of test repetitions required: ");
        int size = Integer.parseInt(reader.readLine());

        for (int i = 0; i < size; i++) {
            findDiscountSticker(driver);
            clickNextPage(driver);
        }

        End(driver);



    }

    public static void End (WebDriver driver) {
        driver.close();
    }

    public static void clickNextPage (WebDriver driver){
        WebElement nextPage = driver.findElement(By.cssSelector("[class='next btn-blue']"));
        nextPage.click();
    }


    public static void findDiscountSticker (WebDriver driver){
        List<WebElement> findProduct = driver.findElements(By.cssSelector(".js-product"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement oneItem : findProduct) {

            String numberOfPrice;
            String numberOfOldPrice;
            String numberOfDiscount;
            boolean hasDiscount = oneItem.getAttribute("innerHTML").contains("image_sticker_discount");
            boolean hasPrice = oneItem.getAttribute("innerHTML").contains("price");
            boolean hasOldPrice = oneItem.getAttribute("innerHTML").contains("old-price");
            if (hasDiscount && hasOldPrice && hasPrice){

                numberOfDiscount = oneItem.findElement(By.cssSelector(".stick-list__item .stick-list__span")).getText();
                System.out.println(numberOfDiscount);
                String discount = numberOfDiscount.replaceAll("[^0-9]", "");

                numberOfOldPrice = oneItem.findElement(By.cssSelector(".catalog .old-price")).getText();
                System.out.println(numberOfOldPrice);
                String oldPriceInInt = numberOfOldPrice.replaceAll("[^0-9]", "");


                numberOfPrice = oneItem.findElement(By.cssSelector(".catalog .price")).getText();
                System.out.println(numberOfPrice);
                String priceInInt = numberOfPrice.replaceAll("[^0-9]", "");

                double doubleDiscount = Integer.parseInt(discount);
                double oldPrice = Integer.parseInt(oldPriceInInt);
                int expectedPrice = Integer.parseInt(priceInInt);
                int realPrice = (int) ceil (oldPrice -(oldPrice*(doubleDiscount/100)));
                String findTitle = oneItem.findElement(By.cssSelector("h4.s_title")).getText();


                softAssert.assertEquals(realPrice, expectedPrice, findTitle + " " + "Expected price: " + expectedPrice + " But we got " + realPrice);
            }
            softAssert.assertAll();
        }
    }

}






