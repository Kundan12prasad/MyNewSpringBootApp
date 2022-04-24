package com.practice.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.practice.model.PlanEntity;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "PLAN_ID", "PLAN_NAME", "PLAN_STATUS", "PLAN_STARTDATE", "PLAN_ENDDATE",
			"PLAN_BENEFIT_AMOUNTT" };
	static String SHEET = "Plan_Details";

	public static ByteArrayInputStream plansToExcel(List<PlanEntity> planDetails) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) 
		{
		      Sheet sheet = workbook.createSheet(SHEET);
		      
		   // Header
		      Row headerRow = sheet.createRow(0);

		      for (int col = 0; col < HEADERs.length; col++)
		      {
		        Cell cell = headerRow.createCell(col);
		        cell.setCellValue(HEADERs[col]);
		      }

		      int rowIdx = 1;		      
		      for (PlanEntity planDetail : planDetails)
		      {
		          Row row = sheet.createRow(rowIdx++);
		          
		          row.createCell(0).setCellValue(planDetail.getPlanId());
		          row.createCell(1).setCellValue(planDetail.getPlanName());
		          row.createCell(2).setCellValue(planDetail.getPlanStatus());
		          row.createCell(3).setCellValue(planDetail.getPlanStartDate());
		          row.createCell(4).setCellValue(planDetail.getPlanEndDate());
		          row.createCell(5).setCellValue(planDetail.getBenefitAmount());
		      }
		          workbook.write(out);
		          return new ByteArrayInputStream(out.toByteArray());        
		}
		      
		      catch (IOException e) 
		      {
		          throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		        }	    
	
	}	      

}
