package dataProviders;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelFileReader {

    public static List<HashMap<String,String>> data(String filePath, String sheetName)
    {
        List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
        try {
            FileInputStream fs = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row HeaderRow = sheet.getRow(0);

            for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
            {
                Row currentRow = sheet.getRow(i);
                HashMap<String,String> currentHash = new HashMap<String,String>();
                for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
                {
                    Cell currentCell = currentRow.getCell(j);
                    switch (currentCell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case Cell.CELL_TYPE_STRING:
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                            break;
                    }
                }
                mydata.add(currentHash);
            }
            fs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return mydata;
    }

    public static void main(String args[]) throws Throwable {
    // System.out.print(data());
      //  readFromFileExcel();
        List<HashMap<String,String>> mydata = data("","");
        for (int i = 0; i < mydata.size(); i ++){
            System.out.print(mydata.get(i).get("pass"));
            System.out.print(mydata.get(i).get("username"));
        }

    }

}
