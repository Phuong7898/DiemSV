package MODEL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import CONTROL.AcademicTranscript;
import CONTROL.AccountUniversity;
import CONTROL.Information;

public class InformationStudent implements InfomationShool {
	private Connection con;
	private java.sql.PreparedStatement stmt;
	private ResultSet rs;
//thông tin sinh viên
	@Override
	public Information ViewInfo(String infos) {
		con = Database.getConnection();
		Information info=new Information();
		String sql = "SELECT * FROM SINHVIEN WHERE masv=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, infos);
			rs = stmt.executeQuery();
			if (rs.next()) {
				info.setID(rs.getString(1));// mã sinh viên
				info.setName(rs.getString(2));// tên
				info.setGT(rs.getString(3));
				info.setDate(rs.getDate(4));// ngày
				info.setAddress(rs.getString(5));// địa chỉ
				info.setNumberPhone(rs.getString(6));// số điện thoại
				info.setiDFaculty(rs.getString(7));// khoa
				info.setTrainingCourse(rs.getString(8));// khóa
				info.setTypeOfTraining(rs.getString(9));// hệ đào tạo
				info.setCMND(rs.getString(10));
				info.setDegree("SINH VIEN");
				info.setAcademicRank("");			}
			stmt.isClosed();
			rs.close();
			con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return info;
	}
//danh sách sinh viên
	public List<Information> ViewAll() {
		
		List<Information> allSV=new ArrayList<Information>();
		 con = Database.getConnection();
	        String sql = "SELECT * FROM SINHVIEN";
	        	try {
					stmt = con.prepareStatement(sql);
		            rs = stmt.executeQuery();
					while (rs.next()) {
						Information infoSV=new Information();
						infoSV.setID(rs.getString(1));// mã sinh viên
						infoSV.setName(rs.getString(2));// tên
						infoSV.setGT(rs.getString(3));
						infoSV.setDate(rs.getDate(4));// ngày
						infoSV.setAddress(rs.getString(5));// địa chỉ
						infoSV.setNumberPhone(rs.getString(6));// số điện thoại
						infoSV.setiDFaculty(rs.getString(7));// khoa
						infoSV.setTrainingCourse(rs.getString(8));// khóa
						infoSV.setTypeOfTraining(rs.getString(9));// hệ đào tạo
						infoSV.setCMND(rs.getString(10));
						infoSV.setDegree("SINH VIEN");
						infoSV.setAcademicRank("");
						infoSV.setiDClass(rs.getString(11));
						allSV.add(infoSV);
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
	public List<String> BD(String id)
	{
		List<String> allSV=new ArrayList<String>();
		con = Database.getConnection();
		 String sql = "SELECT * FROM Bangdiem where magv=?";
     	try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1,id);
	            rs = stmt.executeQuery();
				while (rs.next()) {
					String infoSV;
					infoSV=rs.getString(1);// mã sinh viên
					allSV.add(infoSV);
				}
				Set<String> set = new LinkedHashSet<String>(allSV);
				allSV=new ArrayList<String>(set);
				stmt.isClosed();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
  
	return allSV;
	}
	public List<String> ViewAllBD()
	{
		List<String> allSV=new ArrayList<String>();
		con = Database.getConnection();
		 String sql = "SELECT * FROM Bangdiem";
     	try {
				stmt = con.prepareStatement(sql);
	            rs = stmt.executeQuery();
				while (rs.next()) {
					String infoSV;
					infoSV=rs.getString(1);// mã sinh viên
					allSV.add(infoSV);
				}
				Set<String> set = new LinkedHashSet<String>(allSV);
				allSV=new ArrayList<String>(set);
				stmt.isClosed();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
  
	return allSV;
	}
//Bang diem
	public AcademicTranscript ViewBD(String SV) {
		con = Database.getConnection();
	       String sql = "SELECT * FROM BANGDIEM where masv=?";
	       AcademicTranscript AT =new AcademicTranscript();
	       try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, SV);
			  rs = stmt.executeQuery();
			  while (rs.next()) {
				 
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
			  	}
	       }catch(Exception e)
	       {
	    	   
	       }
	       return AT;
	}
//danh sách sinh viên trong 1 lớp
public List<Information> ViewClass(String ID) {
		List<Information> allSV=new ArrayList<Information>();
		 con = Database.getConnection();
	        String sql = "SELECT * FROM SINHVIEN,LOP WHERE SINHVIEN.malop=LOP.malop and LOP.magv = ?";
	        	try {
					stmt = con.prepareStatement(sql);
					stmt.setString(1,ID);
		            rs = stmt.executeQuery();
					while (rs.next()) {
						Information infoSV=new Information();
						infoSV.setID(rs.getString(1));// mã sinh viên
						infoSV.setName(rs.getString(2));// tên
						infoSV.setGT(rs.getString(3));
						infoSV.setDate(rs.getDate(4));// ngày
						infoSV.setAddress(rs.getString(5));// địa chỉ
						infoSV.setNumberPhone(rs.getString(6));// số điện thoại
						infoSV.setiDFaculty(rs.getString(7));// khoa
						infoSV.setTrainingCourse(rs.getString(8));// khóa
						infoSV.setTypeOfTraining(rs.getString(9));// hệ đào tạo
						infoSV.setCMND(rs.getString(10));
						infoSV.setDegree("SINH VIEN");
						infoSV.setAcademicRank("");
						infoSV.setiDClass(rs.getString(11));
						allSV.add(infoSV);
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
//select register
		public boolean ViewRT(String infos) {
			con = Database.getConnection();
			String sql = "SELECT * FROM SINHVIEN WHERE masv=?";
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
//thêm sinh viên
	public void insertStudent(Information SV, JPanel panel_1)
	{
		 con = Database.getConnection();
		 String sql = "insert into sinhvien(masv,hoten,gioitinh,ngaysinh,diachi,sodt,makhoa,khoadt,hedt,CMND)"+"values(?,?,?,?,?,?,?,?,?,?)";
		 try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,SV.getID());
			stmt.setString(2,SV.getName());
			stmt.setString(3,SV.getGT());
			stmt.setDate(4,SV.getDate());
			stmt.setString(5,SV.getAddress());
			stmt.setString(6,SV.getNumberPhone());
			stmt.setString(7,SV.getiDFaculty());
			stmt.setString(8,SV.getTrainingCourse());
			stmt.setString(9,SV.getTypeOfTraining());
			stmt.setString(10,SV.getCMND());
			int ret= stmt.executeUpdate();
			if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Inserted", JOptionPane.INFORMATION_MESSAGE);
	         else JOptionPane.showMessageDialog(panel_1,"Warning","Insert" , JOptionPane.WARNING_MESSAGE);
			stmt.isClosed();
			con.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
//Đăng ký
	public void insertRT(AccountUniversity SV)
	{
		 con = Database.getConnection();
		 String sql = "insert into dangnhap(id,passs,loaitk)"+"values(?,?,?)";
		 try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,SV.getAccount());
			stmt.setString(2,SV.getPassword());
			stmt.setInt(3,3);
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
//sửa thông tin sinh viên
	public void updateStudent(Information SV,JPanel panel_1)
	{
		con = Database.getConnection();
		String sql = "UPDATE sinhvien SET hoten=?,gioitinh=?,ngaysinh=?,diachi=?,sodt=?,makhoa=?,khoadt=?,hedt=?,CMND=? WHERE masv=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,SV.getName());
			stmt.setString(2,SV.getGT());
			stmt.setDate(3,SV.getDate());
			stmt.setString(4,SV.getAddress());
			stmt.setString(5,SV.getNumberPhone());
			stmt.setString(6,SV.getiDFaculty());
			stmt.setString(7,SV.getTrainingCourse());
			stmt.setString(8,SV.getTypeOfTraining());
			stmt.setString(9,SV.getCMND());
			stmt.setString(10,SV.getID());

			int ret= stmt.executeUpdate();
			if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);
	         else JOptionPane.showMessageDialog(panel_1,"Warning","Update" , JOptionPane.WARNING_MESSAGE);
			stmt.isClosed();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//Xoá sinh viên
	public void deleteStudent(String id,JPanel panel_1) {
	con = Database.getConnection();
	String sql = "delete from sinhvien where masv=?";
	  try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1,id);
		int ret= stmt.executeUpdate();
		 if(ret==1) JOptionPane.showMessageDialog(panel_1, "Successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
         else JOptionPane.showMessageDialog(panel_1,"Warning","Delete" , JOptionPane.WARNING_MESSAGE);
		 stmt.isClosed();
		rs.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
