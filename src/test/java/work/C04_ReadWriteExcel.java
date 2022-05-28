package work;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class C04_ReadWriteExcel {
    @Test
    public void readWriteExcel() throws IOException {
        String dosyaYolu = "src/main/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum() + 1;

        //kullanilan sutun sayisini bulmak icin ilk satiri hucre hucre gezip " " boş hucre bulunca sutun sayisi elde ederiz.
        int sutunSayisi = 0;
        try {
            while (true) {
                if (workbook.getSheet("Sayfa1").getRow(0).getCell(sutunSayisi).toString().equals(" ")) {
                    break;
                } else {
                    sutunSayisi++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("satır sonuna gelindi."); // null pointer exception firlatmasini onlemek icin
        }

        System.out.println("Satir sayisi : " + satirSayisi); //satir sayisi
        System.out.println("Sutun sayisi : " + sutunSayisi); //sutun sayisi


        String[][] arrayMDExcel = new String[satirSayisi][sutunSayisi];
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                arrayMDExcel[i][j] = workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString();
            }
        }

      //  System.out.println(Arrays.deepToString(arrayMDExcel));

        // Başka bir excele yazalım

        String dosyaYolu2 = "src/main/resources/ulkeler2.XLSX";
        FileInputStream fis2 = new FileInputStream(dosyaYolu2);

        for (int i = 0; i < satirSayisi; i++) {
            workbook.getSheet("Sayfa1").createRow(i);
            for (int j = 0; j < sutunSayisi; j++) {
                workbook.getSheet("Sayfa1")
                        .getRow(i)
                        .createCell(j)
                        .setCellValue(arrayMDExcel[i][j]);
            }
        }

        FileOutputStream fos = new FileOutputStream(dosyaYolu2);
        workbook.write(fos);

    }
}