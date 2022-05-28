package work;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class C02_excelWrite extends TestBase {


    @Test
    public void Test01() throws IOException {

        //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
        //seçilir.
        driver.get("https://www.n11.com/");
        driver.findElement(By.id("myLocation-close-info")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Mağazalar')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Mağazaları Gör')]")).click();

        //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
        //txt dosyasına yazdırılır.
        driver.findElement(By.xpath("//h3[contains(text(),'Tüm Mağazalar')]")).click();
        driver.findElement(By.xpath("//span[@title='A']")).click();

        ArrayList<WebElement> aHarfliMagazalar=new ArrayList<>(driver.findElements(By.xpath("(//div[@class='sellerListHolder'])[4]//ul/li")));

        String dosyaYolu="src/main/resources/Book1.xls";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("N11").
                createRow(0).
                createCell(0).
                setCellValue("Mağazalar");


        //9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);


int t=1;
        for (WebElement w:aHarfliMagazalar) {
                workbook.getSheet("N11").createRow(t).createCell(0).setCellValue(w.getText());
      t++;

        }

        fis.close();
        fos.close();



    }
}
