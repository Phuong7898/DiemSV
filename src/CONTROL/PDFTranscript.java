package CONTROL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import MODEL.InformationStudent;
import MODEL.InformationTeacher;

public class PDFTranscript {
	
	public static Font fontAli(float s) {
		Font font = FontFactory.getFont("vuArial.ttf", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED, s);
		return font;
	}

	public void importPDF(String info, String path) {
		Document document = new Document();
//khai báo
		InformationTeacher infoGV=new InformationTeacher();
		InformationStudent infoSV=new InformationStudent();
		List<AcademicTranscript> listOfStudent = null; 										//todo
		AcademicTranscript sv=new AcademicTranscript();
		
		try {
// khởi tạo một PdfWriter truyền vào document và FileOutputStream
			PdfWriter.getInstance(document, new FileOutputStream(path));

// mở file để thực hiện viết
			document.open();
// thêm nội dung sử dụng add function
			Paragraph paragraph1 = new Paragraph("BẢNG ĐIỂM HỌC KỲ", fontAli(16f));
			Paragraph paragraph2 = new Paragraph("Giảng viên: " + sv.getNameGV(), fontAli(10f));
			Paragraph paragraph3 = new Paragraph("Mã Giảng viên: " + sv.getMAGV(), fontAli(10f));
			Paragraph paragraph4 = new Paragraph("Môn: " + sv.getSubject(), fontAli(10f));
			Paragraph paragraph5 = new Paragraph("Lớp: " + sv.getSClass(), fontAli(10f));
			Paragraph paragraph6 = new Paragraph("Tín chỉ: " + sv.getCredit(), fontAli(10f));
			// Định dạng đoạn văn bản thứ nhất
			paragraph1.setIndentationLeft(80);
			paragraph1.setIndentationRight(80);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			paragraph1.setSpacingAfter(15);
			paragraph2.setSpacingBefore(15);
			paragraph2.setAlignment(Element.ALIGN_LEFT);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			paragraph4.setAlignment(Element.ALIGN_LEFT);
			paragraph5.setAlignment(Element.ALIGN_LEFT);
			paragraph6.setAlignment(Element.ALIGN_LEFT);
			paragraph6.setSpacingAfter(15);
			Phrase phrase = new Phrase();

			paragraph1.add(phrase);
			paragraph2.add(phrase);
			paragraph3.add(phrase);
			paragraph4.add(phrase);
			paragraph5.add(phrase);
			paragraph6.add(phrase);
			document.add(paragraph1);
			document.add(paragraph2);
			document.add(paragraph3);
			document.add(paragraph4);
			document.add(paragraph5);
			document.add(paragraph6);
			PdfPTable table = new PdfPTable(8);
// kích thước cột
			table.setWidths(new int[] { 10, 20, 60, 20, 20, 20, 20, 20 });
// set tilte
			Stream.of("STT", "MASV", "Họ và Tên", "QT", "GK", "TH", "CK", "TBHK").forEach(columnTitle -> {
				PdfPCell header = new PdfPCell();
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(columnTitle, fontAli(10f)));
				table.addCell(header);
			});
// set kích thước table
			table.setTotalWidth(PageSize.A4.getWidth() - 10);
			table.setLockedWidth(true);
// Thêm data vào bảng.
			int i = 1;
			for (AcademicTranscript MHSV : listOfStudent) {
				PdfPCell MASV = new PdfPCell(new Paragraph("" + MHSV.getMASV(), fontAli(12f)));
				PdfPCell Name = new PdfPCell(new Paragraph("" + MHSV.getName(), fontAli(12f)));
				PdfPCell QT = new PdfPCell(new Paragraph("" + MHSV.getMarkCourse(), fontAli(12f)));
				PdfPCell GK = new PdfPCell(new Paragraph("" + MHSV.getMarkMidTerm(), fontAli(12f)));
				PdfPCell TH = new PdfPCell(new Paragraph("" + MHSV.getMarkPractice(), fontAli(12f)));
				PdfPCell CK = new PdfPCell(new Paragraph("" + MHSV.getExamResults(), fontAli(12f)));
				PdfPCell GPA = new PdfPCell(new Paragraph("" + MHSV.getGPA(), fontAli(12f)));
				PdfPCell id = new PdfPCell(new Paragraph("" + i));

				table.addCell(id);
				table.addCell(MASV);
				table.addCell(Name);
				table.addCell(QT);
				table.addCell(GK);
				table.addCell(TH);
				table.addCell(CK);
				table.addCell(GPA);
				i++;
			}
			document.add(table);

// đóng file
			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
//QLSV
	public void importPDFSV(String info, String path, int type) {
		Document document = new Document();
		InformationTeacher infoGV=new InformationTeacher();
		InformationStudent infoSV=new InformationStudent();
		List<Information> listOfStudent=null;
		Information sv=new Information();
		sv=infoGV.ViewInfo(info);
		if(type==1)
			listOfStudent = infoSV.ViewAll();
		else 
			listOfStudent = infoSV.ViewClass(info);
		
		try {
// khởi tạo một PdfWriter truyền vào document và FileOutputStream
			PdfWriter.getInstance(document, new FileOutputStream(path));
// mở file để thực hiện viết
			document.open();
// thêm nội dung sử dụng add function
			Paragraph paragraph1 = new Paragraph("DANH SÁCH SINH VIÊN", fontAli(16f));
			Paragraph paragraph2=null;
			Paragraph paragraph3=null;
			Paragraph paragraph4=null;
			
					paragraph2 = new Paragraph("Phòng Đào Tạo ", fontAli(10f));
		if(sv.getID()!=null)
			{
					paragraph2 = new Paragraph("Mã giáo viên:  "+sv.getID(), fontAli(10f));
					paragraph3 = new Paragraph("Tên giáo viên:  "+sv.getName(), fontAli(10f));
					paragraph4 = new Paragraph("Mã khoa:  "+sv.getiDFaculty(), fontAli(10f));
			}
// Định dạng đoạn văn bản thứ nhất
			paragraph1.setIndentationLeft(80);
			paragraph1.setIndentationRight(80);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			paragraph1.setSpacingAfter(15);
			paragraph2.setSpacingBefore(15);
			paragraph2.setAlignment(Element.ALIGN_LEFT);
			if(sv.getID()!=null)
			{
			paragraph3.setSpacingBefore(15);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			paragraph4.setSpacingBefore(15);
			paragraph4.setAlignment(Element.ALIGN_LEFT);
			paragraph4.setSpacingAfter(15);
			}
			else 
			paragraph2.setSpacingAfter(15);
			Phrase phrase = new Phrase();

			paragraph1.add(phrase);
			paragraph2.add(phrase);
			
			document.add(paragraph1);
			document.add(paragraph2);
			if(sv.getID()!=null)
			{
				paragraph3.add(phrase);
				paragraph4.add(phrase);
				document.add(paragraph3);
				document.add(paragraph4);
			}
			PdfPTable table = new PdfPTable(11);
// kích thước cột
			table.setWidths(new int[] { 10, 20, 40, 15, 20, 20, 20, 20, 20, 20, 20});
// set tilte
			Stream.of("STT", "MASV", "Họ và Tên", "Giới Tính", "Ngày Sinh", "Địa chỉ", "Số Điện Thoại","CMND", "Mã Khoa","Khoá","Hệ Đào tạo").forEach(columnTitle -> {
				PdfPCell header = new PdfPCell();
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(columnTitle, fontAli(10f)));
				table.addCell(header);
			});
// set kích thước table
			table.setTotalWidth(PageSize.A4.getWidth() - 10);
			table.setLockedWidth(true);
// Thêm data vào bảng.
			int i = 1;
			SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
			String s="";
			for (Information MHSV : listOfStudent) {
				if(type==1||MHSV.getiDFaculty().equals(sv.getiDFaculty()))
				{
				PdfPCell id = new PdfPCell(new Paragraph(""+(i)));
				PdfPCell MASV = new PdfPCell(new Paragraph("" + MHSV.getID(), fontAli(10f)));
				PdfPCell Name = new PdfPCell(new Paragraph("" + MHSV.getName(), fontAli(10f)));
				PdfPCell GT = new PdfPCell(new Paragraph("" + MHSV.getGT(), fontAli(10f)));
				 s=print.format(MHSV.getDate());
				PdfPCell date = new PdfPCell(new Paragraph("" + s, fontAli(8f)));
				PdfPCell address = new PdfPCell(new Paragraph("" + MHSV.getAddress(), fontAli(8f)));
				PdfPCell SoDT = new PdfPCell(new Paragraph("" + MHSV.getNumberPhone(), fontAli(8f)));
				PdfPCell CMND = new PdfPCell(new Paragraph("" + MHSV.getCMND(), fontAli(8f)));
				PdfPCell Makhoa = new PdfPCell(new Paragraph(""+MHSV.getiDFaculty(),fontAli(10f)));
				PdfPCell KDT = new PdfPCell(new Paragraph("" + MHSV.getTrainingCourse(), fontAli(10f)));
				PdfPCell HDT = new PdfPCell(new Paragraph("" + MHSV.getTypeOfTraining(), fontAli(10f)));
				
				table.addCell(id);
				table.addCell(MASV);
				table.addCell(Name);
				table.addCell(GT);
				table.addCell(date);
				table.addCell(address);
				table.addCell(SoDT);
				table.addCell(CMND);
				table.addCell(Makhoa);
				table.addCell(KDT);
				table.addCell(HDT);
				}
				i++;
			}
			document.add(table);

// đóng file
			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
//Ql Giao vien
	public void importPDFGV( String path, int type) {
		Document document = new Document();
		InformationTeacher infoGV=new InformationTeacher();
		List<Information> listOfTeacher=null;
		
			listOfTeacher = infoGV.ViewAll();
		
		try {
// khởi tạo một PdfWriter truyền vào document và FileOutputStream
			PdfWriter.getInstance(document, new FileOutputStream(path));
// mở file để thực hiện viết
			document.open();
// thêm nội dung sử dụng add function
			Paragraph paragraph1 = new Paragraph("DANH SÁCH SINH VIÊN", fontAli(16f));
			Paragraph paragraph2=null;
			
					paragraph2 = new Paragraph("Phòng Đào Tạo ", fontAli(10f));
// Định dạng đoạn văn bản thứ nhất
			paragraph1.setIndentationLeft(80);
			paragraph1.setIndentationRight(80);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			paragraph1.setSpacingAfter(15);
			paragraph2.setSpacingBefore(15);
			paragraph2.setAlignment(Element.ALIGN_LEFT); 
			paragraph2.setSpacingAfter(15);
			Phrase phrase = new Phrase();

			paragraph1.add(phrase);
			paragraph2.add(phrase);
			
			document.add(paragraph1);
			document.add(paragraph2);
			PdfPTable table = new PdfPTable(11);
// kích thước cột
			table.setWidths(new int[] { 10, 20, 40, 15, 20, 20, 20, 20, 20, 20, 20});
// set tilte
			Stream.of("STT", "MASV", "Họ và Tên", "Giới Tính", "Ngày Sinh", "Địa chỉ", "Số Điện Thoại","CMND", "Mã Khoa","Học hàm","Học vị").forEach(columnTitle -> {
				PdfPCell header = new PdfPCell();
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(columnTitle, fontAli(10f)));
				table.addCell(header);
			});
// set kích thước table
			table.setTotalWidth(PageSize.A4.getWidth() - 10);
			table.setLockedWidth(true);
// Thêm data vào bảng.
			int i = 1;
			SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
			String s="";
			for (Information MHGV : listOfTeacher) {
				PdfPCell id = new PdfPCell(new Paragraph(""+(i)));
				PdfPCell MASV = new PdfPCell(new Paragraph("" + MHGV.getID(), fontAli(10f)));
				PdfPCell Name = new PdfPCell(new Paragraph("" + MHGV.getName(), fontAli(10f)));
				PdfPCell GT = new PdfPCell(new Paragraph("" + MHGV.getGT(), fontAli(10f)));
				 s=print.format(MHGV.getDate());
				PdfPCell date = new PdfPCell(new Paragraph("" + s, fontAli(8f)));
				PdfPCell address = new PdfPCell(new Paragraph("" + MHGV.getAddress(), fontAli(8f)));
				PdfPCell SoDT = new PdfPCell(new Paragraph("" + MHGV.getNumberPhone(), fontAli(8f)));
				PdfPCell CMND = new PdfPCell(new Paragraph("" + MHGV.getCMND(), fontAli(8f)));
				PdfPCell Makhoa = new PdfPCell(new Paragraph(""+MHGV.getiDFaculty(),fontAli(10f)));
				PdfPCell HocHam = new PdfPCell(new Paragraph("" + MHGV.getAcademicRank(), fontAli(10f)));
				PdfPCell HocVi = new PdfPCell(new Paragraph("" + MHGV.getDegree(), fontAli(10f)));
				
				table.addCell(id);
				table.addCell(MASV);
				table.addCell(Name);
				table.addCell(GT);
				table.addCell(date);
				table.addCell(address);
				table.addCell(SoDT);
				table.addCell(CMND);
				table.addCell(Makhoa);
				table.addCell(HocHam);
				table.addCell(HocVi);
				i++;
			}
			document.add(table);

// đóng file
			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
