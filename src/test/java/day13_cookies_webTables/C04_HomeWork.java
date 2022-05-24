package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_HomeWork extends TestBase {
    @Test
    public void Test01() {
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan department isimlerini yazdirin
        System.out.println("2. Headers da bulunan department isimlerini");
List<WebElement> headers=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][6]"));
        for (int i = 0; i < headers.size(); i++) {
           if (!(headers.get(i).getText().equals(" "))){
                System.out.println(headers.get(i).getText());
            }

        }

        //  3. sutunun basligini yazdirin
        System.out.println("3. sutun başlıkları");
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

        for (WebElement each: basliklarListesi
        ) {
            System.out.println(each.getText());
        }
        //  4. Tablodaki tum datalari yazdirin
        System.out.println("4. Tablodaki tüm datalar");
        List<WebElement> tumData=driver.findElements(By.xpath("//div[@class='rt-td']"));

            for (int i = 0; i < tumData.size(); i++) {
                if (!(tumData.get(i).getText().equals(" "))){
                    System.out.println(tumData.get(i).getText());
                }

            }

        WebElement tumtTableWebElement = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("tum datalar 2. yontem");
        System.out.println(tumtTableWebElement.getText());


        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("5. tablodaki data sayısı "+tumData.size());

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])"));
        System.out.println("6. tablo'daki satır sayısı = " + tumSatirlar.size());

        //  7. Tablodaki sutun sayisini yazdirin
        List<WebElement> tumSutunlar = driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));
        System.out.println("7. tablo'daki sutun sayısı = " + tumSutunlar.size());

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("8. Tablodaki 3.kolon");
        List<WebElement> kolon3=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        for (int i = 0; i < kolon3.size(); i++) {
            if (!(kolon3.get(i).getText().equals(" "))){
                System.out.println(kolon3.get(i).getText());
            }

        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("9. Tabloda First Name'i Kierra olan kisinin Salary'si");
        for (int i = 1; i < tumSatirlar.size(); i++) {
            if ((driver.findElement(By.xpath("//div[@class='rt-tr-group']["+i+"]//div[@class='rt-td'][1]")).getText().equals("Kierra"))){

                System.out.println(driver.findElement(By.xpath("//div[@class='rt-tr-group']["+i+"]//div[@class='rt-td'][5]")).getText());
            }

        }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        int satir = 3;
        int sutun = 4;
        System.out.println("10. "+satir+". satır, "+sutun+". sutun daki data: ");
        satirSutunYazdir(satir, sutun);

    }

    private void satirSutunYazdir(int satir, int sutun) {
        WebElement istenenHucre = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + satir + "]//div[@class='rt-td'])[" + sutun + "]"));
        System.out.print(istenenHucre.getText());
    }
}
