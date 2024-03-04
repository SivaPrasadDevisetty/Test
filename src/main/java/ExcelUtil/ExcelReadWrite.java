package ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	 FileInputStream fis;
	    XSSFWorkbook xssfWorkbook;
	    XSSFSheet sheet;
	    FileOutputStream fos;
	    static File src = new File("./src/main/resources/testdata/Data.xlsx");
	    static File src2 = new File("./src/main/resources/testdata/Data1.xlsx");
	public static void main (String [] args) throws Exception{
		
		ExcelReadWrite excelReadWrite = new ExcelReadWrite();
		excelReadWrite.excelRead(src);
		excelReadWrite.excelWrite(src2);
	}
		
		public void excelRead(File file) throws IOException {
			LinkedHashMap<String, String> map = new LinkedHashMap<>();
		    fis = new FileInputStream(file);
		    xssfWorkbook = new XSSFWorkbook(fis);
		    sheet = xssfWorkbook.getSheetAt(0);
             int rows = sheet.getLastRowNum();
             int columns = sheet.getRow(1).getLastCellNum();
		       for(int i=1;i<rows;i++) {
		    	   System.out.println("================================================");
			     Row row =sheet.getRow(i);
			
			        for(int j=0;j<columns;j++) {
			        	String data = "";
				       Cell cell=row.getCell(j);
				       data=cell.getStringCellValue();
			        map.put(sheet.getRow(0).getCell(j).getStringCellValue(), data);
			    }
			    for (Map.Entry<String, String> values: map.entrySet()){
			        System.out.println(values.getKey() + ":" + values.getValue());
			    }
		}
}
		public void excelWrite(File file) throws  IOException, InvalidFormatException {
			xssfWorkbook = new XSSFWorkbook();
			sheet = xssfWorkbook.createSheet();
			ArrayList<Object[]> a = new ArrayList<Object[]>();
			a.add(new Object[]{"Ram" ,"Spring", "300"});
			a.add(new Object[]{"Sita" ,"JavaScript", "200"});
			a.add(new Object[]{"Laxman" ,"Selenium", "500"});
			
			int rcount=0;
			for(Object[] emp:a) {
				
				XSSFRow row = sheet.createRow(rcount++);
				
				int clmCount =0;
				
			    for(Object value:emp) {
			    	
			    	XSSFCell cell = row.createCell(clmCount++);
			    	
			    	
			    	if (value instanceof String)
						cell.setCellValue((String) value);
					if (value instanceof Integer)
						cell.setCellValue((Integer) value);
					if (value instanceof Boolean)
						cell.setCellValue((Boolean) value);
				
			}
				
			}
			fos = new FileOutputStream(file);
			xssfWorkbook.write(fos);
	        fos.close();
		}
}