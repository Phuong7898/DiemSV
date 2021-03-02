package VIEW;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;

import CONTROL.Information;
import MODEL.InformationStudent;
import MODEL.InformationTeacher;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ThongTinGV extends JPanel {
	private JTextField magv;
	private JTextField hoten;
	private JTextField diachi;
	private JTextField sodt;
	private JTextField hocvi;
	private JTextField hocham;
	private JTextField makhoa;
	private ButtonGroup bg=new ButtonGroup();
	private JRadioButton nam = new JRadioButton("Nam");
	private JRadioButton nu = new JRadioButton("N\u1EEF");
	InformationTeacher infoGV=new InformationTeacher();
	JDateChooser date = new JDateChooser();
	private JTextField cmnd;
	private JTextPane ThongTin = new JTextPane();
	String infos;
	public ThongTinGV(String in) {
		infos=in;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1101, 0};
		gridBagLayout.rowHeights = new int[]{397, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {150, 100, 100, 100, 150, 130};
		gbl_panel_1.rowHeights = new int[] {50, 29, 29, 29, 29, 40, 20};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 gi\u00E1o vi\u00EAn:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		magv = new JTextField();
		magv.setEditable(false);
		magv.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_magv = new GridBagConstraints();
		gbc_magv.fill = GridBagConstraints.BOTH;
		gbc_magv.insets = new Insets(0, 0, 5, 5);
		gbc_magv.gridx = 1;
		gbc_magv.gridy = 1;
		panel_1.add(magv, gbc_magv);
		magv.setColumns(10);
		
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
		
		JLabel lblNewLabel_1_6 = new JLabel("H\u1ECDc v\u1ECB:");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_6 = new GridBagConstraints();
		gbc_lblNewLabel_1_6.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_6.gridx = 3;
		gbc_lblNewLabel_1_6.gridy = 2;
		panel_1.add(lblNewLabel_1_6, gbc_lblNewLabel_1_6);
		
		hocvi = new JTextField();
		hocvi.setEditable(false);
		hocvi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		hocvi.setColumns(10);
		GridBagConstraints gbc_hocvi = new GridBagConstraints();
		gbc_hocvi.fill = GridBagConstraints.BOTH;
		gbc_hocvi.insets = new Insets(0, 0, 5, 5);
		gbc_hocvi.gridx = 4;
		gbc_hocvi.gridy = 2;
		panel_1.add(hocvi, gbc_hocvi);
		
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
		
		JLabel lblNewLabel_1_7 = new JLabel("H\u1ECDc h\u00E0m:");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_7 = new GridBagConstraints();
		gbc_lblNewLabel_1_7.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_7.gridx = 3;
		gbc_lblNewLabel_1_7.gridy = 3;
		panel_1.add(lblNewLabel_1_7, gbc_lblNewLabel_1_7);
		
		hocham = new JTextField();
		hocham.setEditable(false);
		hocham.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		hocham.setColumns(10);
		GridBagConstraints gbc_hocham = new GridBagConstraints();
		gbc_hocham.fill = GridBagConstraints.BOTH;
		gbc_hocham.insets = new Insets(0, 0, 5, 5);
		gbc_hocham.gridx = 4;
		gbc_hocham.gridy = 3;
		panel_1.add(hocham, gbc_hocham);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 4;
		panel_1.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		panel_1.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		panel.add(nam);
		
		
		panel.add(nu);
		
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
		
		JLabel lblNewLabel_1_4_1 = new JLabel("CMND");
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_4_1.gridx = 3;
		gbc_lblNewLabel_1_4_1.gridy = 5;
		panel_1.add(lblNewLabel_1_4_1, gbc_lblNewLabel_1_4_1);
		
		cmnd = new JTextField();
		cmnd.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		cmnd.setColumns(10);
		GridBagConstraints gbc_cmnd = new GridBagConstraints();
		gbc_cmnd.insets = new Insets(0, 0, 5, 5);
		gbc_cmnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmnd.gridx = 4;
		gbc_cmnd.gridy = 5;
		panel_1.add(cmnd, gbc_cmnd);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 6;
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 7;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton CapNhat = new JButton("Cập nhật");
		bg.add(nam);
		bg.add(nu);
		
		
		JButton intt = new JButton("In th\u00F4ng tin");
		
		intt.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(intt);
		CapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(CapNhat);
		
		JButton view = new JButton("View");
		view.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		GridBagConstraints gbc_view = new GridBagConstraints();
		gbc_view.fill = GridBagConstraints.VERTICAL;
		gbc_view.anchor = GridBagConstraints.WEST;
		gbc_view.insets = new Insets(0, 0, 5, 0);
		gbc_view.gridx = 0;
		gbc_view.gridy = 1;
		add(view, gbc_view);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		ThongTin.setContentType("text/html");
		ThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		
		scrollPane.setViewportView(ThongTin);
		infoGV();
//event button
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printInfo();
			}
				});
	
	//in thông tin
	intt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		try {	
			PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
            attr_set.add(MediaSizeName.ISO_A4);
            attr_set.add(Sides.DUPLEX);
            
		ThongTin.print(null, null, true, null, attr_set, true);
	} catch (PrinterException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		}
	});
	//cập nhật
			CapNhat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					infoGV.updateTeacher(selectGV(), panel_1);
				}
			});
	}
	protected void infoGV() {
		Information Info=infoGV.ViewInfo(infos);
		SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
		String s=print.format(Info.getDate());
		java.util.Date dates=null;
		try {
			dates = new SimpleDateFormat("dd-MM-yyyy").parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch blockƯ
			e.printStackTrace();
		}
		magv.setText(Info.getID());
		hoten.setText(Info.getName());
		if(Info.getGT().equalsIgnoreCase("nam"))
    		nam.setSelected(true);
    	else nu.setSelected(true);
		date.setDate(dates);
		diachi.setText(Info.getAddress());
		sodt.setText(Info.getNumberPhone());
		cmnd.setText(Info.getCMND());
		makhoa.setText(Info.getiDFaculty());
		hocham.setText(Info.getAcademicRank());
		hocvi.setText(Info.getDegree());
	}
	
	protected Information selectGV() {
		Information GV=new Information();
		SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
		String c=print.format(date.getDate());
		Date dates = Date.valueOf(c);
		GV.setID(magv.getText());
		GV.setName(hoten.getText());
		if(bg.getSelection().equals(nam.getModel()))
			GV.setGT("Nam");
		else
			GV.setGT("Nữ");
		GV.setDate(dates);
		GV.setAddress(diachi.getText());
		GV.setNumberPhone(sodt.getText());
		GV.setCMND(cmnd.getText());
		GV.setAcademicRank(hocham.getText());
		GV.setDegree(hocvi.getText());
		GV.setiDFaculty(makhoa.getText());
		return GV;
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
				"    <h1 align=\"center\" style=\"font-size:13px;font-family: 'Times New Roman', Times, serif;\">THÔNG TIN GIÁO VIÊN</h1>\r\n" + 
				"    <div style=\"font-size:10px;padding: 5px;font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Mã giáo viên:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+magv.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px;padding: 5px;font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Họ và tên: "+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+hoten.getText()+"</span>" + 
				"    <span style=\"font-size:10px; padding-left: 266px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">&emsp;&emsp;&emsp;Giới tính:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+s+"</span>"+"</span>\r\n</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Ngày sinh:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+dates+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Địa chỉ:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+diachi.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Số điện thoại:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+sodt.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">CMND:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+cmnd.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Học vị:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+hocham.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Học vị:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+hocvi.getText()+"</span>"+"</div>\r\n" + 
				"    <div style=\"font-size:10px; padding: 5px; font-weight: bold;font-family: 'Times New Roman', Times, serif;\">Mã Khoa:\t"+"<span style=\"font-weight:lighter;font-size:10px;font-family: 'Times New Roman', Times, serif;\">"+makhoa.getText()+"</span>"+"</div>\r\n" + 
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
