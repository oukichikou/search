package shiro_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class exceltest {

	@Test
	public void aaa() throws Exception{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("�ɼ���");
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=row.createCell(0);
		 //���õ�Ԫ������
		cell.setCellValue("ѧԱ���Գɼ�һ����");
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		//sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		//���Excel�ļ�
        OutputStream output=new FileOutputStream("d:/aa.slx");
//        OutputStream output=response.getOutputStream();
//        response.reset();
//        response.setHeader("Content-disposition", "attachment; filename=details.xls");
//        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
	}
	
	@Test
	public void ss()throws Exception {
		String fileName="d:/a.xlsx";
		 InputStream is = new FileInputStream(new File(fileName));
	        Workbook hssfWorkbook = null;
	        if (fileName.endsWith("xlsx")){
	           hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
	        }else if (fileName.endsWith("xls")){
	            hssfWorkbook = new HSSFWorkbook(is);//Excel 2003
	        }
	       Sheet sheet= hssfWorkbook.getSheetAt(0);
	       for (int rowNum = sheet.getFirstRowNum(); rowNum <= sheet.getLastRowNum(); rowNum++) {
	    	 Row row=  sheet.getRow(rowNum);
	    	 Cell cell= row.getCell(0);
	    	System.out.println(cell.getStringCellValue()); 
	       }
	}
}
