package MODEL;

import java.sql.*;
import CONTROL.AccountUniversity;
import VIEW.HOME;

public class LogIn {
	private Connection con;
	private java.sql.PreparedStatement stmt;
	private ResultSet rs;

	public boolean login(AccountUniversity ACC) {
		con = Database.getConnection();
	
		String sql = "SELECT * FROM dangnhap WHERE id=? and passs=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ACC.getAccount());
			stmt.setString(2, ACC.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {

				if (rs.getInt("loaitk")==1)// 1:phòng đào tạo|admin
				{
					// todo
					HOME home=new HOME(ACC.getAccount(),rs.getInt("loaitk"));
					home.setVisible(true);
					return true;
					
				}
				if (rs.getInt("loaitk")==2)// 2:giáo viên
				{
					// todo
					HOME home=new HOME(ACC.getAccount(),rs.getInt("loaitk"));
					home.setVisible(true);
					return true;
				}
				if (rs.getInt("loaitk")==3)// 3:Sinh viên
				{
					// todo
					HOME home=new HOME(ACC.getAccount(),rs.getInt("loaitk"));
					home.setVisible(true);
					return true;
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
	}
}
