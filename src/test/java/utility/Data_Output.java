package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class Data_Output {
	public static void WriteToExcel(List<WebElement> doc_name, List<WebElement> doc_exp, List<WebElement> fees) {
		try(FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/Excel/Excel_Output.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook()){
			XSSFSheet sheet1 = workbook.createSheet("Doctor Details");
			XSSFRow row1 = sheet1.createRow(0);
			XSSFCell cella = row1.createCell(0);
			XSSFCell cellb = row1.createCell(1);
			XSSFCell cellc = row1.createCell(2);
			cella.setCellValue("Doctor Names");
			cellb.setCellValue("Experience");
			cellc.setCellValue("Consultation Fees");
			int docRow = 1;
			for(int i=0;i<5;i++) {
				XSSFRow row = sheet1.createRow(docRow++);
				XSSFCell cell1 = row.createCell(0);
				XSSFCell cell2 = row.createCell(1);
				XSSFCell cell3 = row.createCell(2);
				cell1.setCellValue(doc_name.get(i).getText());
				cell2.setCellValue(doc_exp.get(i).getText());
				cell3.setCellValue(fees.get(i).getText());

			}
			System.out.println("Successfully printed the output in the excel file!!!");
			workbook.write(fos);
			workbook.close();
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
