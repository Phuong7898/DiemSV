package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import CONTROL.AccountUniversity;
import CONTROL.Information;
import MODEL.InformationTeacher;
import javafx.fxml.Initializable;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;

public class HOME extends JFrame {

	private JPanel contentPane;
	private Information info=null;
	private AccountUniversity sT; 
	private int count=1;
	public HOME(String in, int type) {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Trang ch\u1EE7");
		setBounds(100, 100, 1455, 956);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{178, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 401, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setFocusCycleRoot(true);
		panel.setIgnoreRepaint(true);
		panel.setInheritsPopupMenu(true);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {90, 60, 60, 60, 60, 60, 60, 60, 30};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel MENU = new JLabel("MENU");
		MENU.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GridBagConstraints gbc_MENU = new GridBagConstraints();
		gbc_MENU.insets = new Insets(0, 0, 5, 0);
		gbc_MENU.gridx = 0;
		gbc_MENU.gridy = 0;
		panel.add(MENU, gbc_MENU);
		
		JButton bangDiem = new JButton("B\u1EA2NG \u0110I\u1EC2M");
		
		bangDiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_bangDiem = new GridBagConstraints();
		gbc_bangDiem.insets = new Insets(0, 0, 5, 0);
		gbc_bangDiem.fill = GridBagConstraints.BOTH;
		gbc_bangDiem.gridx = 0;
		gbc_bangDiem.gridy = 1;
		panel.add(bangDiem, gbc_bangDiem);
		
		JButton thongTin = new JButton("TH\u00D4NG TIN");
		
		thongTin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_thongTin = new GridBagConstraints();
		gbc_thongTin.fill = GridBagConstraints.BOTH;
		gbc_thongTin.insets = new Insets(0, 0, 5, 0);
		gbc_thongTin.gridx = 0;
		gbc_thongTin.gridy = 2;
		panel.add(thongTin, gbc_thongTin);
		
		JButton QLSinhVien = new JButton("QU\u1EA2N L\u00DD SINH VI\u00CAN");
		QLSinhVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		GridBagConstraints gbc_QLSinhVien = new GridBagConstraints();
		gbc_QLSinhVien.fill = GridBagConstraints.BOTH;
		gbc_QLSinhVien.insets = new Insets(0, 0, 5, 0);
		gbc_QLSinhVien.gridx = 0;
		gbc_QLSinhVien.gridy = 3;
		panel.add(QLSinhVien, gbc_QLSinhVien);
		
		JButton thongKe = new JButton("TH\u1ED0NG K\u00CA");
		
		thongKe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_thongKe = new GridBagConstraints();
		gbc_thongKe.fill = GridBagConstraints.BOTH;
		gbc_thongKe.insets = new Insets(0, 0, 5, 0);
		gbc_thongKe.gridx = 0;
		gbc_thongKe.gridy = 4;
		panel.add(thongKe, gbc_thongKe);
		
		JButton QLGiaoVien = new JButton("QU\u1EA2N L\u00DD GI\u00C1O VI\u00CAN");
		
		QLGiaoVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_QLGiaoVien = new GridBagConstraints();
		gbc_QLGiaoVien.fill = GridBagConstraints.BOTH;
		gbc_QLGiaoVien.insets = new Insets(0, 0, 5, 0);
		gbc_QLGiaoVien.gridx = 0;
		gbc_QLGiaoVien.gridy = 5;
		panel.add(QLGiaoVien, gbc_QLGiaoVien);
		
		JButton dangXuat = new JButton("\u0110\u0102NG XU\u1EA4T");
		
		dangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_dangXuat = new GridBagConstraints();
		gbc_dangXuat.insets = new Insets(0, 0, 5, 0);
		gbc_dangXuat.fill = GridBagConstraints.BOTH;
		gbc_dangXuat.gridx = 0;
		gbc_dangXuat.gridy = 7;
		panel.add(dangXuat, gbc_dangXuat);
		
		JTabbedPane boxInfo = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_boxInfo = new GridBagConstraints();
		gbc_boxInfo.fill = GridBagConstraints.BOTH;
		gbc_boxInfo.gridx = 1;
		gbc_boxInfo.gridy = 1;
		contentPane.add(boxInfo, gbc_boxInfo);
		setAlwaysOnTop(false);
		if(type==3)
		{
			QLGiaoVien.setEnabled(false);
			QLSinhVien.setEnabled(false);
			thongKe.setEnabled(false);
			QLGiaoVien.setVisible(false);
			QLSinhVien.setVisible(false);
			thongKe.setVisible(false);
		}
		if(type==2)
		{
			QLGiaoVien.setEnabled(false);
			QLGiaoVien.setVisible(false);
		}
//Bảng Điểm
		bangDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BangDiem BD=new BangDiem(in,type);
				DiemRenLuyen DRL=new DiemRenLuyen(in, type);
				MonHoc MH=new MonHoc(in,type);
				if(boxInfo.getSelectedIndex()!=-1)
		        {
		            count=1;
		            boxInfo.removeAll();
		        }
		        if(count==1)
		        {
		            count=0;
		            boxInfo.addTab("Quản lý sinh viên",BD);
		            boxInfo.addTab("Điểm Rèn luyện",DRL);
		            if(type!=3)
		            	boxInfo.addTab("Quản lý Môn",MH);
		       }
			}
		});
//Thông tin
		thongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type==3)
				{
					ThongTinSV SV=new ThongTinSV(in);
					if(boxInfo.getSelectedIndex()!=-1)
			        {
			            count=1;
			            boxInfo.removeAll();
			        }
			        if(count==1)
			        {
			            count=0;
			            boxInfo.addTab("Thông Tin",SV);
			       }
				}
				else
					if(type==2)
					{
						ThongTinGV GV=new ThongTinGV(in);
						if(boxInfo.getSelectedIndex()!=-1)
				        {
				            count=1;
				            boxInfo.removeAll();
				        }
				        if(count==1)
				        {
				            count=0;
				            boxInfo.addTab("Thông Tin",GV);
				       }
					}
			}
		});
//quản lý sinh viên
		QLSinhVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLSV qlsv = null;
				InformationTeacher infoGV=new InformationTeacher();
					qlsv=new QLSV(in,type);
				if(boxInfo.getSelectedIndex()!=-1)
		        {
		            count=1;
		            boxInfo.removeAll();
		        }
		        if(count==1)
		        {
		            count=0;
		            boxInfo.addTab("Quản lý sinh viên",qlsv);
		       }
			}
		});
//quản lý giáo viên
		QLGiaoVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QLGV qlgv=new QLGV();
				if(boxInfo.getSelectedIndex()!=-1)
		        {
		            count=1;
		            boxInfo.removeAll();
		        }
		        if(count==1)
		        {
		            count=0;
		            boxInfo.addTab("Quản lý giáo viên",qlgv);
		       }

			}
		});
//thống kê
		thongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThongKe tk=new ThongKe(in,type);
				if(boxInfo.getSelectedIndex()!=-1)
		        {
		            count=1;
		            boxInfo.removeAll();
		        }
		        if(count==1)
		        {
		            count=0;
		            boxInfo.addTab("Thống Kê",tk);
		       }

			}
		});
//Đăng xuất
		dangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int bc = JOptionPane.YES_NO_OPTION;
				 int mc = JOptionPane.QUESTION_MESSAGE;
				bc=JOptionPane.showConfirmDialog(contentPane,"Are you sure?", "Thông báo", bc,mc);
				if(bc==JOptionPane.YES_OPTION)
				{
					dispose();
				LOGIN Lg=new LOGIN();
				Lg.setVisible(true);
				
				}
			}
		});
	}
}
