package work;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Login extends TestBase {
    @Test
    public void Test01() throws InterruptedException {

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrun= driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepettekiUrun=driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertTrue(sepettekiUrun.contains(ilkUrun));

        //9. Sayfayi kapatin
        driver.close();

    }
}
