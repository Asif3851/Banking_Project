package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Read_loginXL_Data {

	@DataProvider(name = "dynamic")
	public String[][] readxl(Method m) throws EncryptedDocumentException, IOException {
		System.out.println(m.getName());
		String filereader = m.getName();
		FileInputStream file = new FileInputStream("D:\\Automation\\Banking\\testData\\Login_with_Xl_Data_002.xlsx");
		Workbook wb= WorkbookFactory.create(file);
		Sheet xl = wb.getSheet(filereader);
		
		int n_rows= xl.getLastRowNum();
		System.out.println(n_rows);
		Row cols= xl.getRow(0); 
		int n_cols= cols.getLastCellNum();
		System.out.println(n_cols);
		
		DataFormatter format= new DataFormatter();
		String testdata[][]= new String[n_rows][n_cols];
		for(int i=1;i<=n_rows;i++) {
			for(int j=0;j<n_cols;j++) {
				testdata[i-1][j]= format.formatCellValue(xl.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}
	return testdata;
	}
}
