package work;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

        String dosyaYolu = "src/main/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum() + 1;

        //kullanilan sutun sayisini bulmak icin ilk satiri hucre hucre gezip " " boş hucre bulunca sutun sayisi elde ederiz.
        int sonSutunIndex = 0;
        try {
            while (true) {
                if (workbook.getSheet("Sayfa1").getRow(0).getCell(sonSutunIndex).toString().equals(" ")) {
                    break;
                } else {
                    sonSutunIndex++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("satır sonuna gelindi."); // null pointer exception firlatmasi
        }

        System.out.println("Satir sayisi : " + sonSatirIndex); //satir sayisi
        System.out.println("Sutun sayisi : " + sonSutunIndex); //sutun sayisi


        String[][] arrayMDExcel = new String[sonSatirIndex + 1][sonSutunIndex];
        for (int i = 0; i < sonSatirIndex; i++) {
            for (int j = 0; j < sonSutunIndex; j++) {
                arrayMDExcel[i][j] = workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString();
            }
        }

        for (int i = 0; i < sonSatirIndex; i++) {
            for (int j = 0; j < sonSutunIndex; j++) {
                System.out.print(arrayMDExcel[i][j]+"   ");
            }
            System.out.println();
        }
    }
}