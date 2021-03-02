package VIEW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.formula.functions.Count;
import org.apache.poi.ss.usermodel.Row;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.toedter.calendar.JDateChooser;

import CONTROL.AccountUniversity;
import CONTROL.Information;
import CONTROL.PDFTranscript;
import MODEL.InfomationShool;
import MODEL.InformationStudent;
import MODEL.InformationTeacher;

import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.CardLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class QLSV extends JPanel {
	/**
	 * Create the panel.
	 */
	private JTextField maSV;
	private JTextField hoTen;
	private JTextField address;
	private JTextField soDT;
	private JTextField soCMND;
	private JTextField KDT;
	private JTextField HDT;
	private DefaultTableModel defaultTable;
	private ButtonGroup bg=new ButtonGroup();
	private String info;
	private int typeSV;
	private JTable table;
	
	
	InformationStudent infoSV=new InformationStudent();
	private JTextField Find;
	public QLSV(String in,int type) {
		//gán giá trị
				info=in;
				typeSV=type;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {27, 30, 0, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
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
		gbl_panel_1.rowHeights = new int[] {50, 29, 29, 29, 29, 20, 20};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel QuanLy = new JLabel("QU\u1EA2N L\u00DD SINH VI\u00CAN");
		QuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		QuanLy.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GridBagConstraints gbc_QuanLy = new GridBagConstraints();
		gbc_QuanLy.fill = GridBagConstraints.BOTH;
		gbc_QuanLy.insets = new Insets(0, 0, 5, 5);
		gbc_QuanLy.gridwidth = 5;
		gbc_QuanLy.gridx = 0;
		gbc_QuanLy.gridy = 0;
		panel_1.add(QuanLy, gbc_QuanLy);
		
		JLabel ID = new JLabel("M\u00E3 sinh vi\u00EAn:");
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_ID = new GridBagConstraints();
		gbc_ID.anchor = GridBagConstraints.WEST;
		gbc_ID.fill = GridBagConstraints.VERTICAL;
		gbc_ID.insets = new Insets(0, 0, 5, 5);
		gbc_ID.gridx = 0;
		gbc_ID.gridy = 1;
		panel_1.add(ID, gbc_ID);
		
		maSV = new JTextField();
		GridBagConstraints gbc_maSV = new GridBagConstraints();
		gbc_maSV.fill = GridBagConstraints.BOTH;
		gbc_maSV.insets = new Insets(0, 0, 5, 5);
		gbc_maSV.gridx = 1;
		gbc_maSV.gridy = 1;
		panel_1.add(maSV, gbc_maSV);
		maSV.setColumns(10);
		
		JLabel NumberPhone = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		NumberPhone.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_NumberPhone = new GridBagConstraints();
		gbc_NumberPhone.anchor = GridBagConstraints.NORTH;
		gbc_NumberPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_NumberPhone.insets = new Insets(0, 0, 5, 5);
		gbc_NumberPhone.gridx = 3;
		gbc_NumberPhone.gridy = 1;
		panel_1.add(NumberPhone, gbc_NumberPhone);
		
		soDT = new JTextField();
		soDT.setColumns(10);
		GridBagConstraints gbc_soDT = new GridBagConstraints();
		gbc_soDT.fill = GridBagConstraints.BOTH;
		gbc_soDT.insets = new Insets(0, 0, 5, 5);
		gbc_soDT.gridx = 4;
		gbc_soDT.gridy = 1;
		panel_1.add(soDT, gbc_soDT);
		
		JLabel Name = new JLabel("H\u1ECD t\u00EAn:");
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.anchor = GridBagConstraints.WEST;
		gbc_Name.fill = GridBagConstraints.VERTICAL;
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.gridx = 0;
		gbc_Name.gridy = 2;
		panel_1.add(Name, gbc_Name);
		
		hoTen = new JTextField();
		hoTen.setColumns(10);
		GridBagConstraints gbc_hoTen = new GridBagConstraints();
		gbc_hoTen.fill = GridBagConstraints.BOTH;
		gbc_hoTen.insets = new Insets(0, 0, 5, 5);
		gbc_hoTen.gridx = 1;
		gbc_hoTen.gridy = 2;
		panel_1.add(hoTen, gbc_hoTen);
		
		JLabel CMND = new JLabel("CMND:");
		CMND.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_CMND = new GridBagConstraints();
		gbc_CMND.anchor = GridBagConstraints.NORTH;
		gbc_CMND.fill = GridBagConstraints.HORIZONTAL;
		gbc_CMND.insets = new Insets(0, 0, 5, 5);
		gbc_CMND.gridx = 3;
		gbc_CMND.gridy = 2;
		panel_1.add(CMND, gbc_CMND);
		
		soCMND = new JTextField();
		soCMND.setColumns(10);
		GridBagConstraints gbc_soCMND = new GridBagConstraints();
		gbc_soCMND.fill = GridBagConstraints.BOTH;
		gbc_soCMND.insets = new Insets(0, 0, 5, 5);
		gbc_soCMND.gridx = 4;
		gbc_soCMND.gridy = 2;
		panel_1.add(soCMND, gbc_soCMND);
		
		JLabel ngaySinh = new JLabel("Ng\u00E0y sinh:");
		ngaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_ngaySinh = new GridBagConstraints();
		gbc_ngaySinh.anchor = GridBagConstraints.WEST;
		gbc_ngaySinh.fill = GridBagConstraints.VERTICAL;
		gbc_ngaySinh.insets = new Insets(0, 0, 5, 5);
		gbc_ngaySinh.gridx = 0;
		gbc_ngaySinh.gridy = 3;
		panel_1.add(ngaySinh, gbc_ngaySinh);
		
		JDateChooser DATE = new JDateChooser();
		DATE.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		DATE.setDateFormatString("dd-MM-yyyy");
		GridBagConstraints gbc_DATE = new GridBagConstraints();
		gbc_DATE.insets = new Insets(0, 0, 5, 5);
		gbc_DATE.fill = GridBagConstraints.BOTH;
		gbc_DATE.gridx = 1;
		gbc_DATE.gridy = 3;
		panel_1.add(DATE, gbc_DATE);
		
		JLabel khoaDT = new JLabel("Kho\u00E1 \u0111\u00E0o t\u1EA1o:");
		khoaDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_khoaDT = new GridBagConstraints();
		gbc_khoaDT.anchor = GridBagConstraints.NORTH;
		gbc_khoaDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_khoaDT.insets = new Insets(0, 0, 5, 5);
		gbc_khoaDT.gridx = 3;
		gbc_khoaDT.gridy = 3;
		panel_1.add(khoaDT, gbc_khoaDT);
		
		KDT = new JTextField();
		KDT.setColumns(10);
		GridBagConstraints gbc_KDT = new GridBagConstraints();
		gbc_KDT.fill = GridBagConstraints.BOTH;
		gbc_KDT.insets = new Insets(0, 0, 5, 5);
		gbc_KDT.gridx = 4;
		gbc_KDT.gridy = 3;
		panel_1.add(KDT, gbc_KDT);
		
		JLabel GT = new JLabel("Gi\u1EDBi t\u00EDnh:");
		GT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_GT = new GridBagConstraints();
		gbc_GT.fill = GridBagConstraints.VERTICAL;
		gbc_GT.anchor = GridBagConstraints.WEST;
		gbc_GT.insets = new Insets(0, 0, 5, 5);
		gbc_GT.gridx = 0;
		gbc_GT.gridy = 4;
		panel_1.add(GT, gbc_GT);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton Nam = new JRadioButton("Nam");
		panel_2.add(Nam);
		
		JRadioButton Nu = new JRadioButton("N\u1EEF");
		panel_2.add(Nu);
		
		JLabel MaKhoa = new JLabel("M\u00E3 khoa:");
		MaKhoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_MaKhoa = new GridBagConstraints();
		gbc_MaKhoa.anchor = GridBagConstraints.NORTHWEST;
		gbc_MaKhoa.insets = new Insets(0, 0, 5, 5);
		gbc_MaKhoa.gridx = 3;
		gbc_MaKhoa.gridy = 4;
		panel_1.add(MaKhoa, gbc_MaKhoa);
		
		JComboBox idKhoa = new JComboBox();
		idKhoa.setModel(new DefaultComboBoxModel(new String[] {"", "CNTT", "KTMT", "HTTT", "CNPM", "KTPM", "ATTT", "KHMT"}));
		idKhoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_idKhoa = new GridBagConstraints();
		gbc_idKhoa.anchor = GridBagConstraints.WEST;
		gbc_idKhoa.insets = new Insets(0, 0, 5, 5);
		gbc_idKhoa.fill = GridBagConstraints.VERTICAL;
		gbc_idKhoa.gridx = 4;
		gbc_idKhoa.gridy = 4;
		panel_1.add(idKhoa, gbc_idKhoa);
		
		JLabel DiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_DiaChi = new GridBagConstraints();
		gbc_DiaChi.fill = GridBagConstraints.VERTICAL;
		gbc_DiaChi.anchor = GridBagConstraints.WEST;
		gbc_DiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_DiaChi.gridx = 0;
		gbc_DiaChi.gridy = 5;
		panel_1.add(DiaChi, gbc_DiaChi);
		
		address = new JTextField();
		address.setColumns(10);
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.fill = GridBagConstraints.BOTH;
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.gridx = 1;
		gbc_address.gridy = 5;
		panel_1.add(address, gbc_address);
		
		JLabel HeDT = new JLabel("Hệ đào tạo");
		HeDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_HeDT = new GridBagConstraints();
		gbc_HeDT.anchor = GridBagConstraints.NORTH;
		gbc_HeDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_HeDT.insets = new Insets(0, 0, 5, 5);
		gbc_HeDT.gridx = 3;
		gbc_HeDT.gridy = 5;
		panel_1.add(HeDT, gbc_HeDT);
		
		HDT = new JTextField();
		HDT.setColumns(10);
		GridBagConstraints gbc_HDT = new GridBagConstraints();
		gbc_HDT.insets = new Insets(0, 0, 5, 5);
		gbc_HDT.fill = GridBagConstraints.BOTH;
		gbc_HDT.gridx = 4;
		gbc_HDT.gridy = 5;
		panel_1.add(HDT, gbc_HDT);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 6;
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 7;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton Them = new JButton("Th\u00EAm");
		
		Them.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(Them);
		
		JButton Xoa = new JButton("Xo\u00E1");
		
		Xoa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(Xoa);
		
		JButton Sua = new JButton("S\u1EEDa");
		
		Sua.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(Sua);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel DanhSach = new JLabel("Danh s\u00E1ch sinh vi\u00EAn");
		GridBagConstraints gbc_DanhSach = new GridBagConstraints();
		gbc_DanhSach.anchor = GridBagConstraints.WEST;
		gbc_DanhSach.gridwidth = 2;
		gbc_DanhSach.insets = new Insets(0, 0, 0, 5);
		gbc_DanhSach.gridx = 0;
		gbc_DanhSach.gridy = 0;
		panel_4.add(DanhSach, gbc_DanhSach);
		DanhSach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		Find = new JTextField();
		
		
		Find.setText("Search");
		Find.setForeground(Color.GRAY);
		Find.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_Find = new GridBagConstraints();
		gbc_Find.gridwidth = 9;
		gbc_Find.insets = new Insets(0, 0, 0, 5);
		gbc_Find.fill = GridBagConstraints.BOTH;
		gbc_Find.gridx = 2;
		gbc_Find.gridy = 0;
		panel_4.add(Find, gbc_Find);
		Find.setColumns(10);
		
		JButton PDF = new JButton("PDF");
		GridBagConstraints gbc_PDF = new GridBagConstraints();
		gbc_PDF.fill = GridBagConstraints.VERTICAL;
		gbc_PDF.anchor = GridBagConstraints.EAST;
		gbc_PDF.gridx = 31;
		gbc_PDF.gridy = 0;
		panel_4.add(PDF, gbc_PDF);
		
		PDF.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		//PDF
				PDF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ChooseFilePDF pdf=new ChooseFilePDF(info,typeSV);
						
						pdf.setVisible(true);
						
					}
				});
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 8;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "name_48358652098000");

		if(type==2)
		{
			panel_1.setVisible(false);;
			
		}
		table = new JTable();
		
		
		InfoSV();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		bg.add(Nam);
		bg.add(Nu);
//mouse click
	//Find
		Find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Find.getForeground().equals(Color.GRAY))
				{
					Find.setText(null);
				}
			}
		});
		Find.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (Find.getText().isEmpty()) {
		            Find.setForeground(Color.GRAY);
		            Find.setText("Search");
		        }
			}
		});
	//table
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				
				int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint()); 
		        int numcols = defaultTable.getColumnCount();
		        for(int i=0;i<numcols;i++)
	            {
	                                if(row<0) {
	                                    break;
	                                }
	                                String str  = (String)defaultTable.getValueAt(row,i);
	                                if(i==0) maSV.setText(str);
	                                if(i==1) hoTen.setText(str);
	                                if(i==2) 
	                                	if(str.equals("nam"))
	                                		Nam.setSelected(true);
	                                	else Nu.setSelected(true);
	                                if(i==3) 
	                                	{
	                                	java.util.Date date = null;
										try {
											date = new SimpleDateFormat("dd-MM-yyyy").parse(str);
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
	                                	DATE.setDate(date);
	                                	}
	                                if(i==4) address.setText(str);
	                                if(i==5) soDT.setText(str);
	                                if(i==6) soCMND.setText(str);
	                             	if(i==7) idKhoa.setSelectedItem(str);
	                                if(i==8) KDT.setText(str);
	                                if(i==9) HDT.setText(str);
	            }
			}
		});
//event key
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN) {
					int row=0;
					if(evt.getKeyCode()==KeyEvent.VK_UP)
						row=table.getSelectedRow()-1 ;
						else
							if(evt.getKeyCode()==KeyEvent.VK_DOWN)
								row=table.getSelectedRow()+1 ;
						
						if(row<0) row=0;
						if(row>=defaultTable.getRowCount()) row=defaultTable.getRowCount()-1;
					maSV.setText((String)defaultTable.getValueAt(row,0));
                   hoTen.setText((String)defaultTable.getValueAt(row,1));
                   String str=(String)defaultTable.getValueAt(row,2);
                    	if(str.equals("nam"))
                    		Nam.setSelected(true);
                    	else Nu.setSelected(true);
                 
                    	java.util.Date date = null;
						try {
							date = new SimpleDateFormat("dd-MM-yyyy").parse((String)defaultTable.getValueAt(row,3));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    	DATE.setDate(date);
                    address.setText((String)defaultTable.getValueAt(row,4));
                    soDT.setText((String)defaultTable.getValueAt(row,5));
                    soCMND.setText((String)defaultTable.getValueAt(row,6));
                 	idKhoa.setSelectedItem((String)defaultTable.getValueAt(row,7));
                    KDT.setText((String)defaultTable.getValueAt(row,8));
                    HDT.setText((String)defaultTable.getValueAt(row,9));
				}
			}
		});
	//Find key
		Find.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				Find.setForeground(Color.BLACK);
				FindSV(removeAccent(Find.getText()));
			}
		});
//Event button:
	//thêm
		Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Information SV=new Information();
				SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
				String c=print.format(DATE.getDate());
				Date date = Date.valueOf(c);
				if(!maSV.getText().equals(null)||!hoTen.getText().equals(null)||!idKhoa.getSelectedItem().toString().equals(null))
				{
					SV.setID(maSV.getText());
					SV.setName(hoTen.getText());
					if(bg.getSelection().equals(Nam.getModel()))
					{
					SV.setGT("nam");
					}
					else {
						SV.setGT("nữ");
					}
					SV.setDate(date);
					SV.setAddress(address.getText());
					SV.setNumberPhone(soDT.getText());
					SV.setiDFaculty(idKhoa.getSelectedItem().toString());
					SV.setTrainingCourse(KDT.getText());
					SV.setTypeOfTraining(HDT.getText());
					SV.setCMND(soCMND.getText());
					SV.setiDClass(idKhoa.getSelectedItem().toString()+""+KDT.getText());
					infoSV.insertStudent(SV,panel_1);
				}
				InfoSV();
			}
		});
	// sửa
		Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Information SV=new Information();
				
				SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
				String c=print.format(DATE.getDate());
				Date date = Date.valueOf(c);
				if(!maSV.getText().equals(null)||!hoTen.getText().equals(null)||!idKhoa.getSelectedItem().toString().equals(null))
				{
					SV.setID(maSV.getText());
					SV.setName(hoTen.getText());
					if(bg.getSelection().equals(Nam.getModel()))
					{
					SV.setGT("Nam");
					}
					else {
						SV.setGT("Nữ");
					}
					SV.setDate(date);
					SV.setAddress(address.getText());
					SV.setNumberPhone(soDT.getText());
					SV.setiDFaculty(idKhoa.getSelectedItem().toString());
					SV.setTrainingCourse(KDT.getText());
					SV.setTypeOfTraining(HDT.getText());
					SV.setCMND(soCMND.getText());
					SV.setiDClass(idKhoa.getSelectedItem().toString()+""+KDT.getText());
					infoSV.updateStudent(SV,panel_1);
				}
			InfoSV();
			}
			
		});
	//Xoá
		Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!maSV.getText().equals(null))
				{
					infoSV.deleteStudent(maSV.getText(),panel_1);
				}
				InfoSV();
			}
		});
	}
protected void InfoSV() {
	 Vector cols = new Vector();
	 Vector data = new Vector();
	 TableRowSorter sorter;
	 TableModel model;
	
	 cols.addElement("MASV");
     cols.addElement("Họ Tên");
     cols.addElement("GT");
     cols.addElement("Ngày sinh");
     cols.addElement("Địa chỉ");
     cols.addElement("Số điện thoại");
     cols.addElement("CMND");
     cols.addElement("Khoa");
     cols.addElement("Khoá đào tạo");
     cols.addElement("hệ đào tạo");
     

    InformationTeacher infoGV=new InformationTeacher();
	SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
	String s="";
	List<Information> allSV=new ArrayList<Information>();
	if(typeSV==1)
		allSV=infoSV.ViewAll(); 
	if(typeSV==2)
		allSV=infoSV.ViewClass(info);
	Iterator<Information> iterator =allSV.iterator();

	while (iterator.hasNext()) {
		Information infoC=iterator.next();
		 Vector user = new Vector();
		 user.addElement(infoC.getID());
		 user.addElement(infoC.getName());
		 user.addElement(infoC.getGT());
		 s=print.format(infoC.getDate());//set format date
		 user.addElement(s);
		 user.addElement(infoC.getAddress());
		 user.addElement(infoC.getNumberPhone());
		 user.addElement(infoC.getCMND());
		 user.addElement(infoC.getiDFaculty());
		 user.addElement(infoC.getTrainingCourse());
		 user.addElement(infoC.getTypeOfTraining());
		 data.add(user);
	}
	defaultTable = new DefaultTableModel(data,cols);
    
    defaultTable = new DefaultTableModel(data,cols);
	 defaultTable = new DefaultTableModel(data,cols){
        @Override
        public boolean isCellEditable(int rows, int cols) {
            return false;
        }
    };
    model = defaultTable;
	sorter = new TableRowSorter<>(model);
	table.setModel(model);
	table.setRowSorter(sorter);	
}

protected void FindSV(String st) {
	 Vector cols = new Vector();
	 Vector data = new Vector();
	 TableRowSorter sorter;
	 TableModel model;
	
	cols.addElement("MASV");
    cols.addElement("Họ Tên");
    cols.addElement("GT");
    cols.addElement("Ngày sinh");
    cols.addElement("Địa chỉ");
    cols.addElement("Số điện thoại");
    cols.addElement("CMND");
    cols.addElement("Khoa");
    cols.addElement("Khoá đào tạo");
    cols.addElement("hệ đào tạo");
    

   InformationTeacher infoGV=new InformationTeacher();
	SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
	String s="";
	List<Information> allSV=new ArrayList<Information>();
	if(typeSV==1)
		allSV=infoSV.ViewAll(); 
	if(typeSV==2)
		allSV=infoSV.ViewClass(info);
	Iterator<Information> iterator =allSV.iterator();

	while (iterator.hasNext()) {
		Information infoC=iterator.next();
		 Vector user = new Vector();
		 s=print.format(infoC.getDate());//set format date
		 if( infoC.getID().contains(st)|| removeAccent(infoC.getName()).contains(st)||s.contains(st)||removeAccent(infoC.getAddress()).contains(st)||removeAccent(infoC.getiDFaculty()).contains(st)||removeAccent(infoC.getTrainingCourse()).contains(st)||removeAccent(infoC.getTypeOfTraining()).contains(st))
		 {
		 user.addElement(infoC.getID());
		 user.addElement(infoC.getName());
		 user.addElement(infoC.getGT());
		 user.addElement(s);
		 user.addElement(infoC.getAddress());
		 user.addElement(infoC.getNumberPhone());
		 user.addElement(infoC.getCMND());
		 user.addElement(infoC.getiDFaculty());
		 user.addElement(infoC.getTrainingCourse());
		 user.addElement(infoC.getTypeOfTraining());
		 data.add(user);
		 }
	}
	defaultTable = new DefaultTableModel(data,cols);
	 defaultTable = new DefaultTableModel(data,cols){
         @Override
         public boolean isCellEditable(int rows, int cols) {
             return false;
         }
     };
   model = defaultTable;

	sorter = new TableRowSorter<>(model);
	table.setModel(model);
	table.setRowSorter(sorter);	
}
//chuẩn hoá
public String removeAccent(String s) {
	  
	  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	  return pattern.matcher(temp.toLowerCase()).replaceAll("");
	 }
}
