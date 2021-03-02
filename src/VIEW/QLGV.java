package VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import CONTROL.Information;
import MODEL.InformationStudent;
import MODEL.InformationTeacher;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class QLGV extends JPanel {
	private JTextField maGV;
	private JTextField hoTen;
	private JTextField address;
	private JTextField soDT;
	private JTextField soCMND;
	private JTextField HOCHAM;
	private JTextField HOCVI;
	private DefaultTableModel defaultTable;
	private ButtonGroup bg=new ButtonGroup();
	private JTable table;
	
	InformationTeacher infoGV=new InformationTeacher();
	private JTextField Find;
	
	public QLGV() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {27, 30, 0, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
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
		
		JLabel QuanLy = new JLabel("QUẢN LÝ GIÁO VIÊN");
		QuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		QuanLy.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GridBagConstraints gbc_QuanLy = new GridBagConstraints();
		gbc_QuanLy.fill = GridBagConstraints.BOTH;
		gbc_QuanLy.insets = new Insets(0, 0, 5, 5);
		gbc_QuanLy.gridwidth = 5;
		gbc_QuanLy.gridx = 0;
		gbc_QuanLy.gridy = 0;
		panel_1.add(QuanLy, gbc_QuanLy);
		
		JLabel ID = new JLabel("Mã giáo viên:");
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_ID = new GridBagConstraints();
		gbc_ID.anchor = GridBagConstraints.WEST;
		gbc_ID.fill = GridBagConstraints.VERTICAL;
		gbc_ID.insets = new Insets(0, 0, 5, 5);
		gbc_ID.gridx = 0;
		gbc_ID.gridy = 1;
		panel_1.add(ID, gbc_ID);
		
		maGV = new JTextField();
		GridBagConstraints gbc_maGV = new GridBagConstraints();
		gbc_maGV.fill = GridBagConstraints.BOTH;
		gbc_maGV.insets = new Insets(0, 0, 5, 5);
		gbc_maGV.gridx = 1;
		gbc_maGV.gridy = 1;
		panel_1.add(maGV, gbc_maGV);
		maGV.setColumns(10);
		
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
		
		JLabel hocHam = new JLabel("Học hàm");
		hocHam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_hocHam = new GridBagConstraints();
		gbc_hocHam.anchor = GridBagConstraints.NORTH;
		gbc_hocHam.fill = GridBagConstraints.HORIZONTAL;
		gbc_hocHam.insets = new Insets(0, 0, 5, 5);
		gbc_hocHam.gridx = 3;
		gbc_hocHam.gridy = 3;
		panel_1.add(hocHam, gbc_hocHam);
		
		HOCHAM = new JTextField();
		HOCHAM.setColumns(10);
		GridBagConstraints gbc_HOCHAM = new GridBagConstraints();
		gbc_HOCHAM.fill = GridBagConstraints.BOTH;
		gbc_HOCHAM.insets = new Insets(0, 0, 5, 5);
		gbc_HOCHAM.gridx = 4;
		gbc_HOCHAM.gridy = 3;
		panel_1.add(HOCHAM, gbc_HOCHAM);
		
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
		
		JLabel hocVi = new JLabel("Học vị");
		hocVi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_hocVi = new GridBagConstraints();
		gbc_hocVi.anchor = GridBagConstraints.NORTH;
		gbc_hocVi.fill = GridBagConstraints.HORIZONTAL;
		gbc_hocVi.insets = new Insets(0, 0, 5, 5);
		gbc_hocVi.gridx = 3;
		gbc_hocVi.gridy = 4;
		panel_1.add(hocVi, gbc_hocVi);
		
		HOCVI = new JTextField();
		HOCVI.setColumns(10);
		GridBagConstraints gbc_HOCVI = new GridBagConstraints();
		gbc_HOCVI.fill = GridBagConstraints.BOTH;
		gbc_HOCVI.insets = new Insets(0, 0, 5, 5);
		gbc_HOCVI.gridx = 4;
		gbc_HOCVI.gridy = 4;
		panel_1.add(HOCVI, gbc_HOCVI);
		
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
		
		JLabel Khoa = new JLabel("Mã khoa");
		Khoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_Khoa = new GridBagConstraints();
		gbc_Khoa.anchor = GridBagConstraints.NORTHWEST;
		gbc_Khoa.insets = new Insets(0, 0, 5, 5);
		gbc_Khoa.gridx = 3;
		gbc_Khoa.gridy = 5;
		panel_1.add(Khoa, gbc_Khoa);
		JComboBox idKhoa = new JComboBox();
		idKhoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		idKhoa.setModel(new DefaultComboBoxModel(new String[] {"", "CNTT", "KTMT", "HTTT", "CNPM", "KTPM", "ATTT", "KHMT"}));
		GridBagConstraints gbc_idKhoa = new GridBagConstraints();
		gbc_idKhoa.anchor = GridBagConstraints.WEST;
		gbc_idKhoa.insets = new Insets(0, 0, 5, 5);
		gbc_idKhoa.fill = GridBagConstraints.VERTICAL;
		gbc_idKhoa.gridx = 4;
		gbc_idKhoa.gridy = 5;
		panel_1.add(idKhoa, gbc_idKhoa);
		
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
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 53, 0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel DanhSach = new JLabel("Danh sách giáo viên");
		GridBagConstraints gbc_DanhSach = new GridBagConstraints();
		gbc_DanhSach.fill = GridBagConstraints.VERTICAL;
		gbc_DanhSach.anchor = GridBagConstraints.WEST;
		gbc_DanhSach.gridwidth = 5;
		gbc_DanhSach.insets = new Insets(0, 0, 0, 5);
		gbc_DanhSach.gridx = 0;
		gbc_DanhSach.gridy = 0;
		panel_4.add(DanhSach, gbc_DanhSach);
		DanhSach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Find = new JTextField();
		Find.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		Find.setText("Search");
		Find.setForeground(Color.GRAY);
		GridBagConstraints gbc_Find = new GridBagConstraints();
		gbc_Find.gridwidth = 7;
		gbc_Find.insets = new Insets(0, 0, 0, 5);
		gbc_Find.fill = GridBagConstraints.BOTH;
		gbc_Find.gridx = 5;
		gbc_Find.gridy = 0;
		panel_4.add(Find, gbc_Find);
		Find.setColumns(10);
		
		JButton PDF = new JButton("PDF");
		GridBagConstraints gbc_PDF = new GridBagConstraints();
		gbc_PDF.anchor = GridBagConstraints.EAST;
		gbc_PDF.gridx = 34;
		gbc_PDF.gridy = 0;
		panel_4.add(PDF, gbc_PDF);
		
		PDF.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		//PDF
		PDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseFilePDF pdf=new ChooseFilePDF(null,1);
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
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		
		
		InfoGV();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		bg.add(Nam);
		bg.add(Nu);
		//mouse click
		Find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Find.getForeground().equals(Color.GRAY))
				{
					Find.setText(null);
				}
			}
		});

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
		                            if(i==0) maGV.setText(str);
		                            if(i==1) hoTen.setText(str);
		                            if(i==2) 
		                            	if(str.equalsIgnoreCase("Nam"))
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
		                         	if(i==8) HOCVI.setText(str);
		                            if(i==9) HOCHAM.setText(str);
		                            
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
					maGV.setText((String)defaultTable.getValueAt(row,0));
		           hoTen.setText((String)defaultTable.getValueAt(row,1));
		           String str=(String)defaultTable.getValueAt(row,2);
		            	if(str.equalsIgnoreCase("Nam"))
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
		            HOCHAM.setText((String)defaultTable.getValueAt(row,8));
		         	HOCVI.setText((String)defaultTable.getValueAt(row,9));
		           
		           
				}
			}
		});
//find key
		Find.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println(Find.getText());
				FindGV(removeAccent(Find.getText()));
			}
		});
//Event button:
//thêm
		Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Information GV=new Information();
				SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
				String c=print.format(DATE.getDate());
				Date date = Date.valueOf(c);
				if(!maGV.getText().equals(null)||!hoTen.getText().equals(null)||!HOCVI.getText().equals(null))
				{
					GV.setID(maGV.getText());
					GV.setName(hoTen.getText());
					if(bg.getSelection().equals(Nam.getModel()))
					{
					GV.setGT("Nam");
					}
					else {
						GV.setGT("Nữ");
					}
					GV.setDate(date);
					GV.setAddress(address.getText());
					GV.setNumberPhone(soDT.getText());
					GV.setiDFaculty(idKhoa.getSelectedItem().toString());
					GV.setAcademicRank(HOCHAM.getText());
					GV.setCMND(soCMND.getText());
					GV.setDegree(HOCVI.getText());
					infoGV.insertTeacher(GV,panel_1);
				}
				InfoGV();
			}
		});
// sửa
		Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Information GV=new Information();
				
				SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd");
				String c=print.format(DATE.getDate());
				Date date = Date.valueOf(c);
				if(!maGV.getText().equals(null)||!hoTen.getText().equals(null)||!HOCVI.getText().equals(null))
				{
					GV.setID(maGV.getText());
					GV.setName(hoTen.getText());
					if(bg.getSelection().equals(Nam.getModel()))
					{
					GV.setGT("Nam");
					}
					else {
						GV.setGT("Nữ");
					}
					GV.setDate(date);
					GV.setAddress(address.getText());
					GV.setNumberPhone(soDT.getText());
					GV.setiDFaculty(idKhoa.getSelectedItem().toString());
					GV.setAcademicRank(HOCHAM.getText());
					GV.setCMND(soCMND.getText());
					GV.setDegree(HOCVI.getText());
					infoGV.updateTeacher(GV,panel_1);
				}
				InfoGV();
			}
		});
//Xoá
		Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!maGV.getText().equals(null))
				{
					infoGV.deleteTeacher(maGV.getText(),panel_1);
				}
				InfoGV();
			}
		});
		}
		protected void InfoGV() {
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
				cols.addElement("Học hàm");
				cols.addElement("Học vị");
				
				
				InformationTeacher infoGV=new InformationTeacher();
				SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
				String s="";
				List<Information> allGV=new ArrayList<Information>();
				allGV=infoGV.ViewAll(); 
				Iterator<Information> iterator =allGV.iterator();
				
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
				 user.addElement(infoC.getAcademicRank());
				 user.addElement(infoC.getDegree());
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
//Find GV
		protected void FindGV(String st) {
					Vector cols = new Vector();
					Vector data = new Vector();
					TableRowSorter sorter;
					InformationTeacher infoGV=new InformationTeacher();
					SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
					String s="";
					TableModel model;
					
				cols.addElement("MASV");
				cols.addElement("Họ Tên");
				cols.addElement("GT");
				cols.addElement("Ngày sinh");
				cols.addElement("Địa chỉ");
				cols.addElement("Số điện thoại");
				cols.addElement("CMND");
				cols.addElement("Khoa");
				cols.addElement("Học hàm");
				cols.addElement("Học vị");
				
				
				
				List<Information> allGV=new ArrayList<Information>();
				allGV=infoGV.ViewAll(); 
				Iterator<Information> iterator =allGV.iterator();
				
				while (iterator.hasNext()) {
				Information infoC=iterator.next();
				s=print.format(infoC.getDate());//set format date
				 if(infoC.getID().contains(st)||removeAccent(infoC.getName()).contains(st)||s.contains(st)||removeAccent(infoC.getAddress()).contains(st)||removeAccent(infoC.getiDFaculty()).contains(st)||removeAccent(infoC.getAcademicRank()).contains(st)||removeAccent(infoC.getDegree()).contains(st))
				 {
					 Vector user = new Vector();
				 user.addElement(infoC.getID());
				 user.addElement(infoC.getName());
				 user.addElement(infoC.getGT());
				 user.addElement(s);
				 user.addElement(infoC.getAddress());
				 user.addElement(infoC.getNumberPhone());
				 user.addElement(infoC.getCMND());
				 user.addElement(infoC.getiDFaculty());
				 user.addElement(infoC.getAcademicRank());
				 user.addElement(infoC.getDegree());
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
		public String removeAccent(String s) {
			  
			  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
			  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			  return pattern.matcher(temp.toLowerCase()).replaceAll("");
			 }
}
