package VIEW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.toedter.calendar.JDateChooser;

import CONTROL.Information;
import MODEL.InfomationShool;
import MODEL.InformationStudent;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class ThongTinSV extends JPanel {
	private JTextField masv;
	private JTextField hoten;
	private JRadioButton nam = new JRadioButton("Nam");
	private JRadioButton nu = new JRadioButton("N\u1EEF");
	private JDateChooser date = new JDateChooser();
	private JTextField diachi;
	private JTextField sodt;
	private JTextField cmnd;
	private JTextField khoadt;
	private JTextField makhoa;
	private JTextField heDT;
	private ButtonGroup bg=new ButtonGroup();
	JTextPane ThongTin = new JTextPane();
	String infos;
	InformationStudent infoSV=new InformationStudent();
	
	public ThongTinSV(String in) {
		infos=in;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {150, 100, 100, 100, 150, 130};
		gbl_panel_1.rowHeights = new int[] {50, 29, 29, 29, 29, 40, 20};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 sinh vi\u00EAn:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		masv = new JTextField();
		masv.setEditable(false);
		masv.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_masv = new GridBagConstraints();
		gbc_masv.fill = GridBagConstraints.BOTH;
		gbc_masv.insets = new Insets(0, 0, 5, 5);
		gbc_masv.gridx = 1;
		gbc_masv.gridy = 1;
		panel_1.add(masv, gbc_masv);
		masv.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_5.gridx = 3;
		gbc_lblNewLabel_1_5.gridy = 1;
		panel_1.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
		sodt = new JTextField();
		sodt.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		sodt.setColumns(10);
		GridBagConstraints gbc_sodt = new GridBagConstraints();
		gbc_sodt.fill = GridBagConstraints.BOTH;
		gbc_sodt.insets = new Insets(0, 0, 5, 5);
		gbc_sodt.gridx = 4;
		gbc_sodt.gridy = 1;
		panel_1.add(sodt, gbc_sodt);
		
		JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		panel_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		hoten = new JTextField();
		hoten.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		hoten.setColumns(10);
		GridBagConstraints gbc_hoten = new GridBagConstraints();
		gbc_hoten.fill = GridBagConstraints.BOTH;
		gbc_hoten.insets = new Insets(0, 0, 5, 5);
		gbc_hoten.gridx = 1;
		gbc_hoten.gridy = 2;
		panel_1.add(hoten, gbc_hoten);
		
		JLabel lblNewLabel_1_6 = new JLabel("CMND:");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_6 = new GridBagConstraints();
		gbc_lblNewLabel_1_6.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_6.gridx = 3;
		gbc_lblNewLabel_1_6.gridy = 2;
		panel_1.add(lblNewLabel_1_6, gbc_lblNewLabel_1_6);
		
		cmnd = new JTextField();
		cmnd.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		cmnd.setColumns(10);
		GridBagConstraints gbc_cmnd = new GridBagConstraints();
		gbc_cmnd.fill = GridBagConstraints.BOTH;
		gbc_cmnd.insets = new Insets(0, 0, 5, 5);
		gbc_cmnd.gridx = 4;
		gbc_cmnd.gridy = 2;
		panel_1.add(cmnd, gbc_cmnd);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ng\u00E0y sinh:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 3;
		panel_1.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.insets = new Insets(0, 0, 5, 5);
		gbc_date.fill = GridBagConstraints.BOTH;
		gbc_date.gridx = 1;
		gbc_date.gridy = 3;
		date.setDateFormatString("dd-MM-yyyy");
		panel_1.add(date, gbc_date);
		
		JLabel lblNewLabel_1_7 = new JLabel("Kho\u00E1 \u0111\u00E0o t\u1EA1o:");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_7 = new GridBagConstraints();
		gbc_lblNewLabel_1_7.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_7.gridx = 3;
		gbc_lblNewLabel_1_7.gridy = 3;
		panel_1.add(lblNewLabel_1_7, gbc_lblNewLabel_1_7);
		
		khoadt = new JTextField();
		khoadt.setEditable(false);
		khoadt.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		khoadt.setColumns(10);
		GridBagConstraints gbc_khoadt = new GridBagConstraints();
		gbc_khoadt.fill = GridBagConstraints.BOTH;
		gbc_khoadt.insets = new Insets(0, 0, 5, 5);
		gbc_khoadt.gridx = 4;
		gbc_khoadt.gridy = 3;
		panel_1.add(khoadt, gbc_khoadt);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 4;
		panel_1.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		panel_2.add(nam);
		
		
		panel_2.add(nu);
		
		JLabel lblNewLabel_1_8 = new JLabel("M\u00E3 khoa:");
		lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_8 = new GridBagConstraints();
		gbc_lblNewLabel_1_8.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_8.gridx = 3;
		gbc_lblNewLabel_1_8.gridy = 4;
		panel_1.add(lblNewLabel_1_8, gbc_lblNewLabel_1_8);
		
		makhoa = new JTextField();
		makhoa.setEditable(false);
		makhoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		makhoa.setColumns(10);
		GridBagConstraints gbc_makhoa = new GridBagConstraints();
		gbc_makhoa.anchor = GridBagConstraints.NORTH;
		gbc_makhoa.fill = GridBagConstraints.HORIZONTAL;
		gbc_makhoa.insets = new Insets(0, 0, 5, 5);
		gbc_makhoa.gridx = 4;
		gbc_makhoa.gridy = 4;
		panel_1.add(makhoa, gbc_makhoa);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 0;
		gbc_lblNewLabel_1_4.gridy = 5;
		panel_1.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		diachi = new JTextField();
		diachi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		diachi.setColumns(10);
		GridBagConstraints gbc_diachi = new GridBagConstraints();
		gbc_diachi.fill = GridBagConstraints.BOTH;
		gbc_diachi.insets = new Insets(0, 0, 5, 5);
		gbc_diachi.gridx = 1;
		gbc_diachi.gridy = 5;
		panel_1.add(diachi, gbc_diachi);
		
		JLabel HDT = new JLabel("H\u1EC7 \u0111\u00E0o t\u1EA1o");
		HDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_HDT = new GridBagConstraints();
		gbc_HDT.anchor = GridBagConstraints.NORTH;
		gbc_HDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_HDT.insets = new Insets(0, 0, 5, 5);
		gbc_HDT.gridx = 3;
		gbc_HDT.gridy = 5;
		panel_1.add(HDT, gbc_HDT);
		
		heDT = new JTextField();
		heDT.setEditable(false);
		heDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		heDT.setColumns(10);
		GridBagConstraints gbc_heDT = new GridBagConstraints();
		gbc_heDT.insets = new Insets(0, 0, 5, 5);
		gbc_heDT.fill = GridBagConstraints.BOTH;
		gbc_heDT.gridx = 4;
		gbc_heDT.gridy = 5;
		panel_1.add(heDT, gbc_heDT);
		
		JButton CapNhat = new JButton("Cập nhật");
		CapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		
		JButton intt = new JButton("IN TH\u00D4NG TIN");
		
		intt.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_intt = new GridBagConstraints();
		gbc_intt.insets = new Insets(0, 0, 0, 5);
		gbc_intt.gridx = 1;
		gbc_intt.gridy = 6;
		panel_1.add(intt, gbc_intt);
		GridBagConstraints gbc_CapNhat = new GridBagConstraints();
		gbc_CapNhat.insets = new Insets(0, 0, 0, 5);
		gbc_CapNhat.gridx = 3;
		gbc_CapNhat.gridy = 6;
		panel_1.add(CapNhat, gbc_CapNhat);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u00F4ng Tin");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_2);
		
		JButton inT = new JButton("View");
		inT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		panel_3.add(inT);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 6;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		ThongTin.setEditable(false);
		
		
		ThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ThongTin.setContentType("text/html");
		ThongTin.setSize(595, 842);
		scrollPane.setViewportView(ThongTin);
		bg.add(nam);
		bg.add(nu);
		infoSV();
//event button
		inT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printInfo();
			}
		});
		//in thông tin
		intt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 
	                 
					 PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
	                    attr_set.add(MediaSizeName.ISO_A4);
	                    attr_set.add(Sides.DUPLEX);
	                    
					ThongTin.print(null, null, true, null, attr_set, true);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//cập nhật
		CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoSV.updateStudent(selectSV(), panel_1);
			}
		});
	
	}
	protected void infoSV() {
		Information Info=infoSV.ViewInfo(infos);
		SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
		String s=print.format(Info.getDate());
		java.util.Date dates=null;
		try {
			dates = new SimpleDateFormat("dd-MM-yyyy").parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch blockƯ
			e.printStackTrace();
		}
		masv.setText(Info.getID());
		hoten.setText(Info.getName());
		if(Info.getGT().equalsIgnoreCase("nam"))
    		nam.setSelected(true);
    	else nu.setSelected(true);
		date.setDate(dates);
		diachi.setText(Info.getAddress());
		sodt.setText(Info.getNumberPhone());
		cmnd.setText(Info.getCMND());
		makhoa.setText(Info.getiDFaculty());
		khoadt.setText(Info.getTrainingCourse());
		heDT.setText(Info.getTypeOfTraining());	

	}
	protected Information selectSV() {
		Information SV=new Information();
		SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
		String c=print.format(date.getDate());
		Date dates = Date.valueOf(c);
		SV.setID(masv.getText());
		SV.setName(hoten.getText());
		if(bg.getSelection().equals(nam.getModel()))
			SV.setGT("Nam");
		else
			SV.setGT("Nữ");
		SV.setDate(dates);
		SV.setAddress(diachi.getText());
		SV.setNumberPhone(sodt.getText());
		SV.setCMND(cmnd.getText());
		SV.setiDFaculty(makhoa.getText());
		SV.setTrainingCourse(khoadt.getText());
		SV.setTypeOfTraining(heDT.getText());
		return SV;
	} 
	protected void printInfo()
	{
		String s="";
		if(bg.getSelection().equals(nam.getModel()))
		{
		s="Nam";
		}
		else {
			s="Nữ";
		}
		String dates = null;
		dates = new SimpleDateFormat("dd-MM-yyyy").format(date.getDate());
		ThongTin.setText("<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>Document</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"	<h1 align=\"center\" style=\"font-size:10px;font-family: 'Times New Roman', Times, serif;\">TRƯỜNG ĐẠI HỌC CÔNG NGHỆ THÔNG TIN</h1>\r\n"+
				"	<div \" style=\"text-align: center;font-size:10px;font-family: 'Times New Roman', Times, serif;\">PHÒNG GIÁO DỤC VÀ ĐÀO TẠO</div>\r\n"+
				"	<h2 align=\"center\" style=\"font-size:10px;font-family: 'Times New Roman', Times, serif;\">--------</h2>\r\n"+
				"    <h1 align=\"center\" style=\"font-size:13px;font-family: 'Times New Roman', Times, serif;\">THÔNG TIN SINH VIÊN</h1>\r\n" + 
				"    <div style=\"font-size:10px;padding: 5px;font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Mã Sinh viên:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+masv.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px;padding: 5px;font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Họ và tên: "+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+hoten.getText()+"</span>" + 
				"    <span style=\"font-size:10px; padding-left: 266px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">&emsp;&emsp;&emsp;Giới tính:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+s+"</span>"+"</span>\r\n</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Ngày sinh:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+dates+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Địa chỉ:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+diachi.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Số điện thoại:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+sodt.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">CMND:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+cmnd.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Khoá đào tạo:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+khoadt.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Mã khoa:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+makhoa.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Hệ đào tạo:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+heDT.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\" text-align: right;font-size:13px; padding-top: 20px;font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Hiệu trưởng\r\n" + 
				"        <div style=\"text-align: right;font-size:40px; padding-top: 100px; font-weight: bold;\"></div>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>");
	}
}
