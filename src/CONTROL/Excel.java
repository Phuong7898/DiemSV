package CONTROL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import MODEL.InformationTeacher;

public class Excel {
	public CellStyle SheetStyle(XSSFSheet sheet, boolean Bold, int size, HorizontalAlignment alig) {
		// Tạo định dạng: font Times New Roman, in đậm, font-size
		Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) size);
		// canh le
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(alig);
		return cellStyle;

	}

	public void Write(List<AcademicTranscript> listOfStudent, AcademicTranscript SV,String Path) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Bảng điểm");
		int rowNum = 0;
		// merge cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));// truong
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));// phong dao tao
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 7));// tieu de
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 2));// hk
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 3, 5));// nam hoc
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 2));// mon hoc
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 3, 5));// lop
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 2));// giang vien
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 3, 5));// ma giang vien

		Row firstRow = sheet.createRow(rowNum++);
		CellStyle cellStyle;
		Cell firstCell = firstRow.createCell(0);
		firstCell.setCellValue("TRƯỜNG");

		cellStyle = SheetStyle(sheet, true, 14, HorizontalAlignment.LEFT);// tao dinh dang
		firstCell.setCellStyle(cellStyle);

		firstRow = sheet.createRow(rowNum++);
		firstCell = firstRow.createCell(0);
		firstCell.setCellValue("PHÒNG ĐÀO TẠO ĐẠI HỌC");

		cellStyle = SheetStyle(sheet, true, 14, HorizontalAlignment.LEFT);// tao dinh dang
		firstCell.setCellStyle(cellStyle);

		rowNum = 3;

		firstRow = sheet.createRow(rowNum++);
		firstCell = firstRow.createCell(0);
		firstCell.setCellValue("BẢNG ĐIỂM");

		cellStyle = SheetStyle(sheet, true, 14, HorizontalAlignment.CENTER);// tao dinh dang
		firstCell.setCellStyle(cellStyle);

		firstRow = sheet.createRow(rowNum++);
		firstCell = firstRow.createCell(0);
		firstCell.setCellValue("Học kỳ:" + SV.getSemester());
		firstCell = firstRow.createCell(3);
		firstCell.setCellValue("Năm Học:" + SV.getScholastic());

		firstRow = sheet.createRow(rowNum++);
		firstCell = firstRow.createCell(0);
		firstCell.setCellValue("Môn học:" + SV.getSubject());
		firstCell = firstRow.createCell(3);
		firstCell.setCellValue("Lớp:" + SV.getSClass());

		firstRow = sheet.createRow(rowNum++);
		firstCell = firstRow.createCell(0);
		firstCell.setCellValue("Giảng viên:" + SV.getNameGV());
		firstCell = firstRow.createCell(3);
		firstCell.setCellValue("Mã giảng viên:" + SV.getMAGV());
		firstRow = sheet.createRow(rowNum++);
		firstRow = sheet.createRow(rowNum++);

		firstCell = firstRow.createCell(0);// set title
		firstCell.setCellValue("Mã sinh viên");
		firstCell = firstRow.createCell(1);
		firstCell.setCellValue("Họ và tên");
		firstCell = firstRow.createCell(2);
		firstCell.setCellValue("Tín chỉ");
		firstCell = firstRow.createCell(3);
		firstCell.setCellValue("Quá Trình");
		firstCell = firstRow.createCell(4);
		firstCell.setCellValue("Giữa Kỳ");
		firstCell = firstRow.createCell(5);
		firstCell.setCellValue("Thực Hành");
		firstCell = firstRow.createCell(6);
		firstCell.setCellValue("Cuối Kỳ");
		firstCell = firstRow.createCell(7);
		firstCell.setCellValue("Học Kỳ");

		sheet.setColumnWidth(0, 3000); // set size
		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(3, 2000);
		sheet.setColumnWidth(4, 2000);
		sheet.setColumnWidth(5, 2000);
		sheet.setColumnWidth(6, 2000);
		sheet.setColumnWidth(7, 2000);

		for (int columnIndex = 0; columnIndex < 7; columnIndex++) {
			sheet.autoSizeColumn(columnIndex, Boolean.TRUE);
		}
		// todo
		for (AcademicTranscript MHSV : listOfStudent) {
			// gán giá trị vào excel
			if(MHSV.getSClass().equalsIgnoreCase(SV.getSClass())&&MHSV.getSubject().equalsIgnoreCase(SV.getSubject())&&MHSV.getScholastic().equalsIgnoreCase(SV.getScholastic()))
			{
			Row row = sheet.createRow(rowNum++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(MHSV.getMASV());
			cell1 = row.createCell(1);
			cell1.setCellValue(MHSV.getName());
			cell1 = row.createCell(2);
			cell1.setCellValue(MHSV.getCredit());
			cell1 = row.createCell(3);
			cell1.setCellValue(MHSV.getMarkCourse());
			cell1 = row.createCell(4);
			cell1.setCellValue(MHSV.getMarkMidTerm());
			cell1 = row.createCell(5);
			cell1.setCellValue(MHSV.getMarkPractice());
			cell1 = row.createCell(6);
			cell1.setCellValue(MHSV.getExamResults());
			cell1 = row.createCell(7);
			cell1.setCellValue(MHSV.getGPA());
			}
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(Path);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<AcademicTranscript> Read(AcademicTranscript SV,String path) {
		
		List<AcademicTranscript> listOfStudent = new ArrayList<AcademicTranscript>();
		try {
			CalculationAcademicTranscript CAT=new CalculationAcademicTranscript();
			File file = new File(path);
			FileInputStream excelFile;
			InformationTeacher InfoBD=new InformationTeacher();
			excelFile = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (row.getRowNum() >= 4 && row.getRowNum() < 7) {
					String[] s1 = row.getCell(0).getStringCellValue().split(":");
					String[] s2 = row.getCell(3).getStringCellValue().split(":");
					if (row.getRowNum() == 4) {
						SV.setSemester(s1[1]);
						SV.setScholastic(s2[1]);
					}
					if (row.getRowNum() == 5) {
						SV.setSubject(s1[1]);
						SV.setSClass(s2[1]);
					}
					if (row.getRowNum() == 6) {
						SV.setNameGV(s1[1]);
						SV.setMAGV(s2[1]);
					}
				}
				Iterator<AcademicTranscript> iterator2 =InfoBD.ViewMH().iterator();
				if (row.getRowNum() >= 9) {
					// lấy giá trị từ excel
					AcademicTranscript SV1=new AcademicTranscript();
					SV1.setMASV(row.getCell(0).getStringCellValue());
					SV1.setName(row.getCell(1).getStringCellValue());
					SV1.setCredit((int)row.getCell(2).getNumericCellValue());
					SV1.setMarkCourse((float)row.getCell(3).getNumericCellValue());
					SV1.setMarkMidTerm((float)row.getCell(4).getNumericCellValue());
					SV1.setMarkPractice((float)row.getCell(5).getNumericCellValue());
					SV1.setExamResults((float)row.getCell(6).getNumericCellValue());
					SV1.setSemester(SV.getSemester());
					SV1.setScholastic(SV.getScholastic());
					SV1.setSubject(SV.getSubject());
					SV1.setSClass(SV.getSClass());
					SV1.setNameGV(SV.getNameGV());
					SV1.setMAGV(SV.getMAGV());
				 	while (iterator2.hasNext()) {
				 		AcademicTranscript infoC=iterator2.next();
				 		if(infoC.getSClass().equalsIgnoreCase(SV.getSClass()))
				 		{
				 		SV1.setProportionCourse(infoC.getProportionCourse());
				 		SV1.setProportionMidTerm(infoC.getProportionMidTerm());
				 		SV1.setProportionPractice(infoC.getProportionPractice());
				 		SV1.setProportionFinal(infoC.getProportionFinal());
				 	}
				 		}
				
				
				SV1.setGPA(CAT.AverageGPA(SV1));
					listOfStudent.add(SV1);
				}
			}
			workbook.close();
			return listOfStudent;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfStudent;

	}
}
