package MODEL;

import CONTROL.AcademicTranscript;
import CONTROL.AccountUniversity;
import CONTROL.Information;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import CONTROL.Information;import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;


public class InformationTeacher implements InfomationShool{
	private Connection con;
	private java.sql.PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public Information ViewInfo(String infos) {
		con = Database.getConnection();
		Information info=new Information();
		String sql = "SELECT * FROM giaovien WHERE magv=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, infos);
			rs = stmt.executeQuery();
			if (rs.next()) {
				info.setID(rs.getString(1));// mã giáo viên
				info.setName(rs.getString(2));// tên
				info.setGT(rs.getString(3));
				info.setDate(rs.getDate(4));// ngày
				info.setAddress(rs.getString(5));// địa chỉ
				info.setNumberPhone(rs.getString(6));// số điện thoại
				info.setAcademicRank(rs.getString(7));
				info.setDegree(rs.getString(8));
				info.setiDFaculty(rs.getString(9));// khoa
				info.setCMND(rs.getString(10));
				}
			stmt.isClosed();
			rs.close();
			con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return info;
	}
public List<Information> ViewAll() {
		
		List<Information> allSV=new ArrayList<Information>();
		 con = Database.getConnection();
	        String sql = "SELECT * FROM GIAOVIEN";
	        	try {
					stmt = con.prepareStatement(sql);
		            rs = stmt.executeQuery();
					while (rs.next()) {
						Information info=new Information();
						info.setID(rs.getString(1));// mã giáo viên
						info.setName(rs.getString(2));// tên
						info.setGT(rs.getString(3));
						info.setDate(rs.getDate(4));// ngày
						info.setAddress(rs.getString(5));// địa chỉ
						info.setNumberPhone(rs.getString(6));// số điện thoại
						info.setAcademicRank(rs.getString(7));
						info.setDegree(rs.getString(8));
						info.setiDFaculty(rs.getString(9));// khoa
						info.setCMND(rs.getString(10));	
						allSV.add(info);
					}
					Set<Information> set = new LinkedHashSet<Information>(allSV);
					allSV=new ArrayList<Information>(set);
					stmt.isClosed();
					rs.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	     
		return allSV;
	}
 
//select bảng điểm sinh viên
	public List<AcademicTranscript> ViewBD(){
		List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
		 con = Database.getConnection();
	       String sql = "SELECT * FROM BANGDIEM,SINHVIEN where bangdiem.masv=sinhvien.masv";
	       try {
			stmt = con.prepareStatement(sql);
			  rs = stmt.executeQuery();
			  while (rs.next()) {
				  AcademicTranscript AT =new AcademicTranscript();
				  AT.setMASV(rs.getString(1));
				  AT.setSClass(rs.getString(2));
				  AT.setSemester(rs.getString(3));
				  AT.setSubject(rs.getString(4));
				  AT.setMAGV(rs.getString(5));
				  AT.setMarkCourse(rs.getFloat(6));
				  AT.setMarkPractice(rs.getFloat(7));
				  AT.setMarkMidTerm(rs.getFloat(8));
				  AT.setExamResults(rs.getFloat(9));
				  AT.setGPA(rs.getFloat(10));
				  AT.setScholastic(rs.getString(11));
				  AT.setName(rs.getString("hoten"));
				  BD.add(AT);
			  	}
			  Set<AcademicTranscript> set = new LinkedHashSet<AcademicTranscript>(BD);
			  BD=new ArrayList<AcademicTranscript>(set);
			  rs.close();
			  stmt.isClosed();
			  con.close();
	       }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BD;
	}
//select môn 
	public List<AcademicTranscript> ViewMD(){
		List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
		 con = Database.getConnection();
	       String sql = "SELECT * FROM monhoc,lop where lop.malop=monhoc.malop";
	       try {
			stmt = con.prepareStatement(sql);
			  rs = stmt.executeQuery();
			  while (rs.next()) {
				  AcademicTranscript AT =new AcademicTranscript();
				  AT.setSubject(rs.getString("mamh"));
				  AT.setSubjectName(rs.getString("tenmh"));
				  AT.setMAGV(rs.getString("magv"));
				  AT.setSotiet(rs.getInt("sotiet"));
				  AT.setCredit(rs.getInt("sotc"));
				  AT.setMaKhoa(rs.getString("makhoa"));
				  AT.setTypeSubject(rs.getString("loaimh"));
				  AT.setSClass(rs.getString("malop"));
				  AT.setProportionCourse(rs.getFloat("tlqt"));
				  AT.setProportionPractice(rs.getFloat("tlth"));
				  AT.setProportionMidTerm(rs.getFloat("tlgk"));
				  AT.setProportionFinal(rs.getFloat("tlck"));
				  BD.add(AT);
			  	}
			  Set<AcademicTranscript> set = new LinkedHashSet<AcademicTranscript>(BD);
			  BD=new ArrayList<AcademicTranscript>(set);
			  rs.close();
			  stmt.isClosed();
			  con.close();
	       }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return BD;
	}
//select mon hoc gv
	public List<AcademicTranscript> ViewMDSV(String in){
		List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
		 con = Database.getConnection();
	       String sql = "SELECT * FROM monhoc,lop where lop.malop=monhoc.malop and magv=?";
	       try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, in);
			  rs = stmt.executeQuery();
			  while (rs.next()) {
				  AcademicTranscript AT =new AcademicTranscript();
				  AT.setSubject(rs.getString("mamh"));
				  AT.setMAGV(rs.getString("magv"));
				  AT.setSubjectName(rs.getString("tenmh"));
				  AT.setSotiet(rs.getInt("sotiet"));
				  AT.setCredit(rs.getInt("sotc"));
				  AT.setMaKhoa(rs.getString("makhoa"));
				  AT.setTypeSubject(rs.getString("loaimh"));
				  AT.setSClass(rs.getString("malop"));
				  AT.setProportionCourse(rs.getFloat("tlqt"));
				  AT.setProportionPractice(rs.getFloat("tlth"));
				  AT.setProportionMidTerm(rs.getFloat("tlgk"));
				  AT.setProportionFinal(rs.getFloat("tlck"));
				  BD.add(AT);
			  	}
			  Set<AcademicTranscript> set = new LinkedHashSet<AcademicTranscript>(BD);
			  BD=new ArrayList<AcademicTranscript>(set);
			  rs.close();
			  stmt.isClosed();
			  con.close();
	       }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return BD;
	}
	//select malop
	public List<AcademicTranscript> ViewLOP(){
		List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
		 con = Database.getConnection();
	       String sql = "SELECT * FROM LOP";
	       try {
			stmt = con.prepareStatement(sql);
			  rs = stmt.executeQuery();
			  while (rs.next()) {
				  AcademicTranscript AT =new AcademicTranscript();
				  AT.setSClass(rs.getString(1));
				  AT.setClassName(rs.getString(2));
				  AT.setMaKhoa(rs.getString(3));
				  AT.setMAGV(rs.getString(4));
				  BD.add(AT);
			  	}
			  Set<AcademicTranscript> set = new LinkedHashSet<AcademicTranscript>(BD);
			  BD=new ArrayList<AcademicTranscript>(set);
			  rs.close();
			  stmt.isClosed();
			  con.close();
	       }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return BD;
	}
	//select mon hoc
	public List<AcademicTranscript> ViewMH(){
		con = Database.getConnection();
		List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
		String sql = "SELECT * FROM monhoc";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			 while (rs.next()) {
				  AcademicTranscript AT =new AcademicTranscript();
				  AT.setSubject(rs.getString(1));
				  AT.setSubjectName(rs.getString(2));
				  AT.setSotiet(rs.getInt(3));
				  AT.setCredit(rs.getInt(4));
				  AT.setMaKhoa(rs.getString(5));
				  AT.setTypeSubject(rs.getString(6));
				  AT.setSClass(rs.getString(7));
				  AT.setProportionCourse(rs.getFloat(8));
				  AT.setProportionMidTerm(rs.getFloat(9));
				  AT.setProportionPractice(rs.getFloat(10));
				  AT.setProportionFinal(rs.getFloat(11));
				  BD.add(AT);
			 }
			 rs.close();
			  stmt.isClosed();
			  con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BD;
	}
	//select mon hoc gv
		public List<AcademicTranscript> ViewMHGV(String GV){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT * FROM monhoc,lop,giaovien,bangdiem where monhoc.malop=lop.malop and giaovien.magv=lop.magv and bangdiem.mamh=monhoc.mamh and giaovien.magv=?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1,GV);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMAGV(GV);
					  AT.setSemester(rs.getString("mahk"));
					  AT.setNameGV(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("manh"));
					  AT.setSubject(rs.getString(1));
					  AT.setSubjectName(rs.getString(2));
					  AT.setSotiet(rs.getInt(3));
					  AT.setCredit(rs.getInt(4));
					  AT.setMaKhoa(rs.getString(5));
					  AT.setTypeSubject(rs.getString(6));
					  AT.setSClass(rs.getString(7));
					  AT.setProportionCourse(rs.getFloat(8));
					  AT.setProportionMidTerm(rs.getFloat(9));
					  AT.setProportionPractice(rs.getFloat(10));
					  AT.setProportionFinal(rs.getFloat(11));
					  BD.add(AT);
				 }
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
	//select điểm rèn luyện SV
		public List<AcademicTranscript> ViewDRLSV(String SV){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT * FROM diemrenluyen,sinhvien,lop where diemrenluyen.masv=sinhvien.masv and lop.malop=sinhvien.malop and sinhvien.masv=?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, SV);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMASV(rs.getString("masv"));
					  AT.setName(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("namhoc"));
					  AT.setDRL(rs.getFloat("diemrenluyen"));
					  AT.setSemester(rs.getString("hocky"));
					  AT.setSClass(rs.getString("malop"));
					  BD.add(AT);
				 }
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
	//select điểm rèn luyên all
		public List<AcademicTranscript> ViewDRLAll(){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT * FROM diemrenluyen,sinhvien,lop where diemrenluyen.masv=sinhvien.masv and lop.malop=sinhvien.malop";
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMASV(rs.getString("masv"));
					  AT.setName(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("namhoc"));
					  AT.setDRL(rs.getFloat("diemrenluyen"));
					  AT.setSemester(rs.getString("hocky"));
					  AT.setSClass(rs.getString("malop"));
					  BD.add(AT);
				 }
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
	//select điểm rèn luyện
		public List<AcademicTranscript> ViewDRL(String SV){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT * FROM diemrenluyen,sinhvien,lop where diemrenluyen.masv=sinhvien.masv and lop.malop=sinhvien.malop and lop.magv=?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, SV);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMASV(rs.getString("masv"));
					  AT.setName(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("namhoc"));
					  AT.setDRL(rs.getFloat("diemrenluyen"));
					  AT.setSemester(rs.getString("hocky"));
					  AT.setSClass(rs.getString("malop"));
					  BD.add(AT);
				 }
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
		//select diemtb
		public List<AcademicTranscript> ViewTB(String SV){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT * FROM bangdiem,monhoc,sinhvien where monhoc.mamh=bangdiem.mamh and sinhvien.masv=bangdiem.masv and bangdiem.masv=?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, SV);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMASV(rs.getString("masv"));
					  AT.setCredit(rs.getInt("sotc"));
					  AT.setName(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("manh"));
					  AT.setGPA(rs.getFloat("diemtb"));
					  AT.setSemester(rs.getString("mahk"));
					  AT.setSClass(rs.getString("malop"));
					  BD.add(AT);
				 }
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
//select register
		public boolean ViewRT(String infos) {
			con = Database.getConnection();
			String sql = "SELECT * FROM giaovien WHERE magv=?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, infos);
				rs = stmt.executeQuery();
				if (rs.next()) {
					return true;
				}
				stmt.isClosed();
				rs.close();
				con.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
			return false;
		}
//thống kê all
		public List<AcademicTranscript> ViewTK(){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT * FROM diemrenluyen,sinhvien,giaovien,lop where sinhvien.masv=diemrenluyen.masv and lop.magv=giaovien.magv and lop.malop=sinhvien.malop";
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMASV(rs.getString("masv"));
					  AT.setName(rs.getString("hoten"));
					  AT.setMAGV(rs.getString("magv"));
					  AT.setSemester(rs.getString("hocky"));
					  AT.setNameGV(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("namhoc"));
					  AT.setMaKhoa(rs.getString("makhoa"));
					  AT.setSClass(rs.getString("malop"));
					  AT.setDRL(rs.getFloat("diemrenluyen"));
					  AT.setGPA(rs.getFloat("diemtb"));
					  BD.add(AT);
				 }
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
//filter thống kê HL
		public List<AcademicTranscript> ViewHL(){
			con = Database.getConnection();
			List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
			String sql = "SELECT sinhvien.masv,sinhvien.hoten,giaovien.magv,hocky,giaovien.hoten,sinhvien.makhoa,namhoc,lop.malop,diemrenluyen,diemrenluyen.diemtb FROM diemrenluyen,sinhvien,giaovien,lop,bangdiem where sinhvien.masv=diemrenluyen.masv and lop.magv=giaovien.magv and lop.malop=sinhvien.malop and bangdiem.masv=sinhvien.masv and bangdiem.diemtb<5";
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				 while (rs.next()) {
					  AcademicTranscript AT =new AcademicTranscript();
					  AT.setMASV(rs.getString("masv"));
					  AT.setName(rs.getString("hoten"));
					  AT.setMAGV(rs.getString("magv"));
					  AT.setSemester(rs.getString("hocky"));
					  AT.setNameGV(rs.getString("hoten"));
					  AT.setScholastic(rs.getString("namhoc"));
					  AT.setMaKhoa(rs.getString("makhoa"));
					  AT.setSClass(rs.getString("malop"));
					  AT.setDRL(rs.getFloat("diemrenluyen"));
					  AT.setGPA(rs.getFloat("diemtb"));
					  BD.add(AT);
				 }
				  Set<AcademicTranscript> set = new LinkedHashSet<AcademicTranscript>(BD);
				  BD=new ArrayList<AcademicTranscript>(set);
				 rs.close();
				 stmt.isClosed();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return BD;
		}
//Thêm giáo viên
	public void insertTeacher(Information GV, JPanel panel_1)
	{
		 con = Database.getConnection();
		 String sql = "insert into giaovien(magv,hoten,gioitinh,ngaysinh,diachi,sodt,hocham,hocvi,makhoa,CMND)"+"values(?,?,?,?,?,?,?,?,?,?)";
		 try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,GV.getID());
			stmt.setString(2,GV.getName());
			stmt.setString(3,GV.getGT());
			stmt.setDate(4,GV.getDate());
			stmt.setString(5,GV.getAddress());
			stmt.setString(6,GV.getNumberPhone());
			stmt.setString(7,GV.getAcademicRank());
			stmt.setString(8,GV.getDegree());
			stmt.setString(9,GV.getiDFaculty());
			stmt.setString(10,GV.getCMND());
			int ret= stmt.executeUpdate();
			if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Inserted", JOptionPane.INFORMATION_MESSAGE);
	         else JOptionPane.showMessageDialog(panel_1,"Warning","Insert" , JOptionPane.WARNING_MESSAGE);
			stmt.isClosed();
			con.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(panel_1,"Error Fail","Insert" , JOptionPane.ERROR_MESSAGE);
		}
     
}
//them bang diem
public void insertBD(AcademicTranscript BD, JPanel panel_1)
{
	con = Database.getConnection();
	 String sql = "insert into bangdiem(masv,malop,mahk,mamh,magv,diemqt,diemth,diemgiuaky,diemcuoiky,diemtb,manh)"+"values(?,?,?,?,?,?,?,?,?,?,?)";
	 try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1,BD.getMASV());
		stmt.setString(2,BD.getSClass());
		stmt.setString(3,BD.getSemester());
		stmt.setString(4,BD.getSubject());
		stmt.setString(5,BD.getMAGV());
		stmt.setFloat(6,BD.getMarkCourse());
		stmt.setFloat(7,BD.getMarkPractice());
		stmt.setFloat(8,BD.getMarkMidTerm());
		stmt.setFloat(9,BD.getExamResults());
		stmt.setFloat(10,BD.getGPA());
		stmt.setString(11,BD.getScholastic());
		int ret= stmt.executeUpdate();
		if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Inserted", JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(panel_1,"Warning","Insert" , JOptionPane.WARNING_MESSAGE);
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Insert" , JOptionPane.ERROR_MESSAGE);
	}
}
//them môn học
public void insertMH(AcademicTranscript BD, JPanel panel_1)
{
	con = Database.getConnection();
	 String sql = "insert into monhoc(mamh,tenmh,sotiet,sotc,makhoa,loaimh,malop,tlqt,tlgk,tlth,tlck)"+"values(?,?,?,?,?,?,?,?,?,?,?)";
	 try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1,BD.getSubject());
		stmt.setString(2,BD.getSubjectName());
		stmt.setInt(3,BD.getSotiet());
		stmt.setInt(4,BD.getCredit());
		stmt.setString(5,BD.getMaKhoa());
		stmt.setString(6,BD.getTypeSubject());
		stmt.setString(7,BD.getSClass());
		stmt.setFloat(8,BD.getProportionCourse());
		stmt.setFloat(9,BD.getProportionPractice());
		stmt.setFloat(10,BD.getProportionMidTerm());
		stmt.setFloat(11,BD.getProportionFinal());

		int ret= stmt.executeUpdate();
		if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Inserted", JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(panel_1,"Warning","Insert" , JOptionPane.WARNING_MESSAGE);
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Insert" , JOptionPane.ERROR_MESSAGE);
	}
}
//insert lop
public int insertLOP(AcademicTranscript BD, JPanel panel_1)
{
	con = Database.getConnection();
	 String sql = "insert into lop(malop,makhoa,magv,tenlop)"+"values(?,?,?,?)";
	 try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1,BD.getSClass());
		stmt.setString(2,BD.getMaKhoa());
		stmt.setString(3,BD.getMAGV());
		stmt.setString(4,BD.getSubjectName());
		int ret= stmt.executeUpdate();

		stmt.isClosed();
		con.close();
		return ret;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Insert" , JOptionPane.ERROR_MESSAGE);
		return 0;
	}
}
//Đăng ký
public void insertRT(AccountUniversity GV)
{
	 con = Database.getConnection();
	 String sql = "insert into dangnhap(id,passs,loaitk)"+"values(?,?,?)";
	 try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1,GV.getAccount());
		stmt.setString(2,GV.getPassword());
		stmt.setInt(3,2);
		int ret= stmt.executeUpdate();
		if(ret==1) JOptionPane.showMessageDialog(null, "Successfully", "Inserted", JOptionPane.INFORMATION_MESSAGE);
         else JOptionPane.showMessageDialog(null,"Warning","Insert" , JOptionPane.WARNING_MESSAGE);
		stmt.isClosed();
		con.close();
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
}
//Cập nhật thông tin Giáo viên
public void updateTeacher(Information GV,JPanel panel_1)
{
	con = Database.getConnection();
	String sql = "UPDATE giaovien SET hoten=?,gioitinh=?,ngaysinh=?,diachi=?,sodt=?,hocham=?,hocvi=?,makhoa=?,CMND=? WHERE magv=?";
	try {
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1,GV.getName());
		stmt.setString(2,GV.getGT());
		stmt.setDate(3,GV.getDate());
		stmt.setString(4,GV.getAddress());
		stmt.setString(5,GV.getNumberPhone());
		stmt.setString(7,GV.getAcademicRank());
		stmt.setString(6,GV.getDegree());
		stmt.setString(8,GV.getiDFaculty());
		stmt.setString(9,GV.getCMND());
		stmt.setString(10,GV.getID());

		int ret= stmt.executeUpdate();
		if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);
         else JOptionPane.showMessageDialog(panel_1,"Warning","Update" , JOptionPane.WARNING_MESSAGE);
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Update" , JOptionPane.ERROR_MESSAGE);
	}
}
//cập nhật bảng điểm
public int updateBD(AcademicTranscript BD, JPanel panel_1)
{
	con = Database.getConnection();
	String sql = "UPDATE bangdiem SET malop=?,mahk=?,mamh=?,magv=?,diemqt=?,diemth=?,diemgiuaky=?,diemcuoiky=?,diemtb=?,manh=? WHERE masv=?";
	try {
		stmt = con.prepareStatement(sql);
		
		
		stmt.setString(1,BD.getSClass());
		stmt.setString(2,BD.getSemester());
		stmt.setString(3,BD.getSubject());
		stmt.setString(4,BD.getMAGV());
		stmt.setFloat(5,BD.getMarkCourse());
		stmt.setFloat(6,BD.getMarkPractice());
		stmt.setFloat(7,BD.getMarkMidTerm());
		stmt.setFloat(8,BD.getExamResults());
		stmt.setFloat(9,BD.getGPA());
		stmt.setString(10,BD.getScholastic());
		stmt.setString(11,BD.getMASV());
		
		int ret= stmt.executeUpdate();
		stmt.isClosed();
		con.close();
		return ret;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return -1;
	}
}
//cập nhật điểm tb
public void updateTBHK(String SV,float DTB,JPanel panel_1)
{
	con = Database.getConnection();
	String sql = "UPDATE diemrenluyen SET diemtb=? WHERE masv=?";
	try {
		stmt = con.prepareStatement(sql);
		
		stmt.setFloat(1,DTB);
		stmt.setString(2,SV);
		int ret= stmt.executeUpdate();
		if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);
         else JOptionPane.showMessageDialog(panel_1,"Warning","Update" , JOptionPane.WARNING_MESSAGE);
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Update" , JOptionPane.ERROR_MESSAGE);
	}
}

//cập nhật DRL
public void updateDRL(AcademicTranscript SV,JPanel panel_1)
{
	con = Database.getConnection();
	String sql = "UPDATE diemrenluyen SET diemrenluyen=?,hocky=?,namhoc=? WHERE masv=?";
	try {
		stmt = con.prepareStatement(sql);
		
		stmt.setFloat(1,SV.getDRL());
		stmt.setString(2,SV.getSemester());
		stmt.setString(3,SV.getScholastic());
		stmt.setString(4,SV.getMASV());
		stmt.executeUpdate();
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Update" , JOptionPane.ERROR_MESSAGE);
	}
}
//cập nhật monhoc
public void updateMH(AcademicTranscript BD, JPanel panel_1)
{
	con = Database.getConnection();
	 String sql = "UPDATE monhoc SET tenmh=?,sotiet=?,sotc=?,makhoa=?,loaimh=?,malop=?,tlqt=?,tlgk=?,tlth=?,tlck=? WHERE mamh=? and malop=?";
	 try {
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1,BD.getSubjectName());
		stmt.setInt(2,BD.getSotiet());
		stmt.setInt(3,BD.getCredit());
		stmt.setString(4,BD.getMaKhoa());
		stmt.setString(5,BD.getTypeSubject());
		stmt.setString(6,BD.getSClass());
		stmt.setFloat(7,BD.getProportionCourse());
		stmt.setFloat(8,BD.getProportionPractice());
		stmt.setFloat(9,BD.getProportionMidTerm());
		stmt.setFloat(10,BD.getProportionFinal());
		stmt.setString(11,BD.getSubject());
		stmt.setString(12,BD.getSClass());
		int ret= stmt.executeUpdate();
		if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Update", JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(panel_1,"Warning","Update" , JOptionPane.WARNING_MESSAGE);
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Update" , JOptionPane.ERROR_MESSAGE);
	}
}
//cập nhật lớp
public void updateLOP(AcademicTranscript BD, JPanel panel_1)
{
	con = Database.getConnection();
	 String sql = "UPDATE lop SET makhoa=?,magv=?,tenlop=? where malop=?";
	 try {
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1,BD.getMaKhoa());
		stmt.setString(2,BD.getMAGV());
		stmt.setString(3,BD.getSubjectName());
		stmt.setString(4,BD.getSClass());
		stmt.executeUpdate();
		stmt.isClosed();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(panel_1,"Error Fail","Insert" , JOptionPane.ERROR_MESSAGE);
	}
}
//Xoá sinh viên
public void deleteTeacher(String id,JPanel panel_1) {
con = Database.getConnection();
String sql = "delete from giaovien where magv=?";
  try {
	stmt = con.prepareStatement(sql);
	stmt.setString(1,id);
	int ret= stmt.executeUpdate();
	 if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
     else JOptionPane.showMessageDialog(panel_1,"Warning","Delete" , JOptionPane.WARNING_MESSAGE);
	 stmt.isClosed();
	 con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
 JOptionPane.showMessageDialog(panel_1,"Error Fail","Delete" , JOptionPane.ERROR_MESSAGE);
}
}
public void deleteBD(String id,JPanel panel_1) {
con = Database.getConnection();
String sql = "delete from bangdiem where masv=?";
  try {
	stmt = con.prepareStatement(sql);
	stmt.setString(1,id);
	int ret= stmt.executeUpdate();
	 if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
     else JOptionPane.showMessageDialog(panel_1,"Warning","Delete" , JOptionPane.WARNING_MESSAGE);
	 stmt.isClosed();
	 con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
 JOptionPane.showMessageDialog(panel_1,"Error Fail","Delete" , JOptionPane.ERROR_MESSAGE);
}
  }
public int deleteMH(String id,JPanel panel_1) {
con = Database.getConnection();
String sql = "delete from monhoc where malop=?";
  try {
	stmt = con.prepareStatement(sql);
	stmt.setString(1,id);
	int ret= stmt.executeUpdate();
	 stmt.isClosed();
	 con.close();
	 return ret;
} catch (SQLException e) {
	// TODO Auto-generated catch block
 JOptionPane.showMessageDialog(panel_1,"Error Fail","Delete" , JOptionPane.ERROR_MESSAGE);
 return 0;
}
  }
public void deleteLOP(String id,JPanel panel_1) {
con = Database.getConnection();
String sql = "delete from lop where malop=?";
  try {
	stmt = con.prepareStatement(sql);
	stmt.setString(1,id);
	int ret= stmt.executeUpdate();
	 if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
     else JOptionPane.showMessageDialog(panel_1,"Warning","Delete" , JOptionPane.WARNING_MESSAGE);
	 stmt.isClosed();
	 con.close();
	 
} catch (SQLException e) {
	// TODO Auto-generated catch block
 JOptionPane.showMessageDialog(panel_1,"Error Fail","Delete" , JOptionPane.ERROR_MESSAGE);
}
  }
}
