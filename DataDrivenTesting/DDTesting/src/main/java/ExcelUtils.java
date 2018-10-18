import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	public static XSSFSheet getExcelWSheet() {
		return ExcelWSheet;
	}
	
	
	public static String getCellData(int RowNum, int ColNum) {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			e.printStackTrace();
			return "";

		}
	}
		
		public static void setCellData(String Result, int RowNum, int ColNum) {

			try {

				Row = ExcelWSheet.getRow(RowNum);

				Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

				if (Cell == null) {

					Cell = Row.createCell(ColNum);

					Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

				// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream(Constants.pathTestData + Constants.fileTestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	
}
