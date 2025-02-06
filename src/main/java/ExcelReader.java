import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelReader {

    public static class PokerData {
        Date date;
        double amountIn;
        double amountOut;

        public PokerData(Date date, double amountIn, double amountOut) {
            this.date = date;
            this.amountIn = amountIn;
            this.amountOut = amountOut;
        }
    }

    public static List<PokerData> readExcelFile(String filePath) throws IOException {
        List<PokerData> dataList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Suponiendo que los datos están en la primera hoja

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;
            Cell dateCell = row.getCell(0);
            Cell inCell = row.getCell(1);
            Cell outCell = row.getCell(2);
            if (dateCell != null && inCell != null && outCell != null) {
                Date date = dateCell.getDateCellValue();
                double amountIn = inCell.getNumericCellValue();
                double amountOut = outCell.getNumericCellValue();
                dataList.add(new PokerData(date, amountIn, amountOut));
            }
        }
        workbook.close();
        fis.close();
        return dataList;
    }
}
