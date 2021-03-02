package VIEW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import CONTROL.AcademicTranscript;
import CONTROL.Information;
import CONTROL.CalculationAcademicTranscript;
import CONTROL.Excel;
import MODEL.InformationStudent;
import MODEL.InformationTeacher;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

public class BangDiem extends JPanel {
	private JTextField namhoc;
	private JTextField qt;
	private JTextField th;
	private JTextField gk;
	private JTextField ck;
	private JTable table;
	private JComboBox masv = new JComboBox();
	private JComboBox magv = new JComboBox();
	private JComboBox malop = new JComboBox();
	private JComboBox mamh = new JComboBox();
	private JComboBox HK = new JComboBox();
	private DefaultTableModel defaultTable;
	JPanel panel_1 = new JPanel();
	String info;
	int types;
	
	public BangDiem(String in, int type) {
		types=type;
		info=in;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1140, 0};
		gridBagLayout.rowHeights = new int[] {188, 78, 47, 239};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("B\u1EA2NG \u0110I\u1EC2M");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 sinh vi\u00EAn:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		
		GridBagConstraints gbc_masv = new GridBagConstraints();
		gbc_masv.insets = new Insets(0, 0, 5, 5);
		gbc_masv.fill = GridBagConstraints.BOTH;
		gbc_masv.gridx = 1;
		gbc_masv.gridy = 1;
		masv.setEditable(true);
		masv.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel.add(masv, gbc_masv);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECDc k\u1EF3:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		HK.setModel(new DefaultComboBoxModel(new String[] {"", "HK1", "HK2", "HK Hè"}));
		GridBagConstraints gbc_HK = new GridBagConstraints();
		gbc_HK.insets = new Insets(0, 0, 5, 0);
		gbc_HK.fill = GridBagConstraints.BOTH;
		gbc_HK.gridx = 3;
		gbc_HK.gridy = 1;
		panel.add(HK, gbc_HK);
		
		JLabel lblM = new JLabel("Mã môn:");
		lblM.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.anchor = GridBagConstraints.WEST;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 0;
		gbc_lblM.gridy = 2;
		panel.add(lblM, gbc_lblM);
		
		
		GridBagConstraints gbc_mamh = new GridBagConstraints();
		gbc_mamh.insets = new Insets(0, 0, 5, 5);
		gbc_mamh.fill = GridBagConstraints.BOTH;
		gbc_mamh.gridx = 1;
		gbc_mamh.gridy = 2;
		
		
		mamh.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel.add(mamh, gbc_mamh);
		
		JLabel lblNewLabel_6 = new JLabel("N\u0103m h\u1ECDc:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 2;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		namhoc = new JTextField();
		namhoc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_namhoc = new GridBagConstraints();
		gbc_namhoc.insets = new Insets(0, 0, 5, 0);
		gbc_namhoc.fill = GridBagConstraints.BOTH;
		gbc_namhoc.gridx = 3;
		gbc_namhoc.gridy = 2;
		panel.add(namhoc, gbc_namhoc);
		namhoc.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("M\u00E3 l\u1EDBp:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		
		GridBagConstraints gbc_malop = new GridBagConstraints();
		gbc_malop.insets = new Insets(0, 0, 5, 5);
		gbc_malop.fill = GridBagConstraints.BOTH;
		gbc_malop.gridx = 1;
		gbc_malop.gridy = 3;
		
		malop.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel.add(malop, gbc_malop);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E3 gi\u00E1o vi\u00EAn:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
		GridBagConstraints gbc_magv = new GridBagConstraints();
		gbc_magv.insets = new Insets(0, 0, 5, 0);
		gbc_magv.fill = GridBagConstraints.BOTH;
		gbc_magv.gridx = 3;
		gbc_magv.gridy = 3;
		magv.setEditable(true);
		magv.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel.add(magv, gbc_magv);
		
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[] {0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110i\u1EC3m QT:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		qt = new JTextField();
		qt.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_qt = new GridBagConstraints();
		gbc_qt.insets = new Insets(0, 0, 5, 5);
		gbc_qt.fill = GridBagConstraints.HORIZONTAL;
		gbc_qt.gridx = 1;
		gbc_qt.gridy = 0;
		panel_1.add(qt, gbc_qt);
		qt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u0110i\u1EC3m TH:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 0;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		th = new JTextField();
		th.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_th = new GridBagConstraints();
		gbc_th.insets = new Insets(0, 0, 5, 5);
		gbc_th.fill = GridBagConstraints.HORIZONTAL;
		gbc_th.gridx = 3;
		gbc_th.gridy = 0;
		panel_1.add(th, gbc_th);
		th.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel(" \u0110i\u1EC3m GK:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 0;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		gk = new JTextField();
		gk.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_gk = new GridBagConstraints();
		gbc_gk.insets = new Insets(0, 0, 5, 5);
		gbc_gk.fill = GridBagConstraints.HORIZONTAL;
		gbc_gk.gridx = 5;
		gbc_gk.gridy = 0;
		panel_1.add(gk, gbc_gk);
		gk.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u0110i\u1EC3m CK:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 6;
		gbc_lblNewLabel_9.gridy = 0;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		ck = new JTextField();
		ck.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_ck = new GridBagConstraints();
		gbc_ck.insets = new Insets(0, 0, 5, 0);
		gbc_ck.fill = GridBagConstraints.HORIZONTAL;
		gbc_ck.gridx = 7;
		gbc_ck.gridy = 0;
		panel_1.add(ck, gbc_ck);
		ck.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton them = new JButton("TH\u00CAM");
		
		them.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_2.add(them);
		
		JButton sua = new JButton("CẬP NHẬT");
		
		sua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_2.add(sua);
		
		JButton excel = new JButton("Write Excel");
		
		excel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_2.add(excel);
		
		JButton readexcel = new JButton("Read Excel");
		
		readexcel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_2.add(readexcel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{1140, 0};
		gbl_panel_3.rowHeights = new int[]{0, 402, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_11 = new JLabel("Bảng điểm:");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 0;
		panel_3.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		//event mouse
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
			                                String str=str  = (String)defaultTable.getValueAt(row,i);
			                               
			                                
			                                if(i==0) masv.setSelectedItem(str);
			                                if(i==1) continue;
			                                if(i==2) HK.setSelectedItem(str);
			                                if(i==3) mamh.setSelectedItem(str);
			                                if(i==4) malop.setSelectedItem(str);
			                                if(i==5) magv.setSelectedItem(str);
			                                if(i==6) qt.setText(str);
			                                if(i==7) th.setText(str);
			                                if(i==8) gk.setText(str);
			                                if(i==9) ck.setText(str);
			                                if(i==10) continue;
			                                if(i==11) namhoc.setText(str);
			            }
					}
				});
				//event Key
						table.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent evt) {
								int row=0;
									if(evt.getKeyCode()==KeyEvent.VK_UP)
									row=table.getSelectedRow()-1 ;
									else
										if(evt.getKeyCode()==KeyEvent.VK_DOWN)
											row=table.getSelectedRow()+1 ;
									
									if(row<0) row=0;
									if(row>=defaultTable.getRowCount()) row=defaultTable.getRowCount()-1;
									 masv.setSelectedItem((String)defaultTable.getValueAt(row,0));
									 HK.setSelectedItem((String)defaultTable.getValueAt(row,2));
									 mamh.setSelectedItem((String)defaultTable.getValueAt(row,3));
				                     malop.setSelectedItem((String)defaultTable.getValueAt(row,4));
				                     magv.setSelectedItem((String)defaultTable.getValueAt(row,5));
				                     qt.setText((String)defaultTable.getValueAt(row,6));
				                     th.setText((String)defaultTable.getValueAt(row,7));
				                     gk.setText((String)defaultTable.getValueAt(row,8));
				                     ck.setText((String)defaultTable.getValueAt(row,9));
				                     namhoc.setText((String)defaultTable.getValueAt(row,11));
							}
				});
		
		if(type==1)
		{
			SelectComboBox();
			infoBD();
		}
		else
		if(type==2)
		{
			SelectComboBox2();
			infoBD();	
		them.setEnabled(false);
		them.setVisible(false);
		}
		else if(type==3)
		{
			panel.setEnabled(false);
			panel_1.setEnabled(false);
			panel_2.setEnabled(false);
			panel.setVisible(false);
			panel_1.setVisible(false);
			panel_2.setVisible(false);
			infoBDSV();
		}
//event combobox
		mamh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcademicTranscript SV=new AcademicTranscript();
				InformationTeacher InfoBD=new InformationTeacher();
				InfoBD.ViewMH();
				Iterator<AcademicTranscript> iterator =InfoBD.ViewMH().iterator();
			 	while (iterator.hasNext()) {
			 		AcademicTranscript infoC=iterator.next();
			 		if(infoC.getSubject().equalsIgnoreCase(mamh.getSelectedItem().toString()))
			 		{	
			 			malop.setSelectedItem(infoC.getSClass());
			 			break;
			 		}
			 		
			 	}
			}
		});
//event button
		//thêm
		them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcademicTranscript SV=new AcademicTranscript();
				InformationTeacher InfoBD=new InformationTeacher();
				if(!masv.getSelectedItem().equals("")&&!magv.getSelectedItem().equals("")&&!malop.getSelectedItem().equals("")&&!mamh.getSelectedItem().equals("")&&!HK.getSelectedItem().equals(""))
				{
					SV.setMASV(masv.getSelectedItem().toString());
					SV.setSClass(malop.getSelectedItem().toString());
					SV.setSemester(HK.getSelectedItem().toString());
					SV.setSubject(mamh.getSelectedItem().toString());
					SV.setMAGV(magv.getSelectedItem().toString());
					SV.setMarkCourse(0);
					SV.setMarkMidTerm(0);
					SV.setMarkPractice(0);
					SV.setExamResults(0);
					SV.setGPA(0);
					SV.setScholastic(namhoc.getText());
					InfoBD.insertBD(SV, panel_1);
				}
			}
		});
		//cập nhật
		sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcademicTranscript SV=new AcademicTranscript();
				InformationTeacher InfoBD=new InformationTeacher();
				if(!masv.getSelectedItem().equals("")&&!magv.getSelectedItem().equals("")&&!malop.getSelectedItem().equals("")&&!mamh.getSelectedItem().equals("")&&!HK.getSelectedItem().equals(""))
				{
					SV.setMASV(masv.getSelectedItem().toString());
					SV.setSClass(malop.getSelectedItem().toString());
					SV.setSemester(HK.getSelectedItem().toString());
					SV.setSubject(mamh.getSelectedItem().toString());
					SV.setMAGV(magv.getSelectedItem().toString());
					SV.setMarkCourse(Float.parseFloat(qt.getText()));
					SV.setMarkMidTerm(Float.parseFloat(gk.getText()));
					SV.setMarkPractice(Float.parseFloat(th.getText()));
					SV.setExamResults(Float.parseFloat(ck.getText()));
					 Iterator<AcademicTranscript> iterator =InfoBD.ViewMH().iterator();

					 	while (iterator.hasNext()) {
					 		AcademicTranscript infoC=iterator.next();
					 		if(infoC.getSClass().equalsIgnoreCase(SV.getSClass()))
					 		{
					 		SV.setProportionCourse(infoC.getProportionCourse());
					 		SV.setProportionMidTerm(infoC.getProportionMidTerm());
					 		SV.setProportionPractice(infoC.getProportionPractice());
					 		SV.setProportionFinal(infoC.getProportionFinal());
					 	}
					 		}
					CalculationAcademicTranscript CAT=new CalculationAcademicTranscript();
					
					SV.setGPA(CAT.AverageGPA(SV));
					SV.setScholastic(namhoc.getText());
					int i=InfoBD.updateBD(SV, panel_1);
					DTBHK(SV.getMASV(),SV.getSemester(),SV.getScholastic());
					if(i==1)JOptionPane.showMessageDialog(panel_1, "Successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);
		            else
			 		if(i==-1) JOptionPane.showMessageDialog(panel_1,"Error Fail","Update" , JOptionPane.ERROR_MESSAGE);
			         else JOptionPane.showMessageDialog(panel_1,"Warning","Update" , JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//write excel
		excel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				FileFilter filter = new FileNameExtensionFilter("Excel Document(*.xlsx)","xlsx");
				
				j.setFileFilter(filter);
				j.addChoosableFileFilter(filter);
		            // set the selection mode to directories only 
		            j.setFileSelectionMode(JFileChooser.APPROVE_OPTION); 
		            
		            // invoke the showsSaveDialog function to show the save dialog 
		            int r = j.showSaveDialog(null); 
		  
		            if (r == JFileChooser.APPROVE_OPTION) 
		            { 
		            	 
						Excel excel=new Excel();
						InformationTeacher InfoBD=new InformationTeacher();
						
						Iterator<AcademicTranscript> iteratorMH =InfoBD.ViewMHGV(info).iterator();
						while (iteratorMH.hasNext()) 
						{
							AcademicTranscript infoC=iteratorMH.next();
							if(infoC.getSClass().equalsIgnoreCase(malop.getSelectedItem().toString())&&infoC.getSubject().equalsIgnoreCase(mamh.getSelectedItem().toString())&&infoC.getScholastic().equalsIgnoreCase(namhoc.getText()))
								if(!j.getSelectedFile().getAbsolutePath().endsWith(".xlsx") ) 
								{
								excel.Write(InfoBD.ViewBD(),infoC,j.getSelectedFile().getAbsolutePath()+".xlsx");
								}
							else excel.Write(InfoBD.ViewBD(),infoC,j.getSelectedFile().getAbsolutePath());
						}
		            }
			}
		});
		//read excel
		readexcel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				FileFilter filter = new FileNameExtensionFilter("Excel Document(*.xlsx)","xlsx");
				Excel excel=new Excel();
				InformationTeacher InfoBD=new InformationTeacher();
				AcademicTranscript infoC=new AcademicTranscript();
				List<AcademicTranscript> BD=new ArrayList<AcademicTranscript>();
				j.setFileFilter(filter);
				j.addChoosableFileFilter(filter);
		            // set the selection mode to directories only 
		            j.setFileSelectionMode(JFileChooser.APPROVE_OPTION); 
		            
		            // invoke the showsSaveDialog function to show the save dialog 
		            int r = j.showOpenDialog(null); 
		            int i = -1;
		            if (r == JFileChooser.APPROVE_OPTION) 
		            { 
								if(!j.getSelectedFile().getAbsolutePath().endsWith(".xlsx") ) 
								{
								BD=excel.Read(infoC,j.getSelectedFile().getAbsolutePath()+".xlsx");
								}
							else 
								BD=excel.Read(infoC,j.getSelectedFile().getAbsolutePath());
								 Iterator<AcademicTranscript> iterator =BD.iterator();
								 while (iterator.hasNext()) {
								 		AcademicTranscript SV=iterator.next();
								 		i=InfoBD.updateBD(SV, panel_1);
								 		DTBHK(SV.getMASV(),SV.getSemester(),SV.getScholastic());
								 }
								 
		            }
		            if(i==1)JOptionPane.showMessageDialog(panel_1, "Successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);
		            else
			 		if(i==-1) JOptionPane.showMessageDialog(panel_1,"Error Fail","Update" , JOptionPane.ERROR_MESSAGE);
			         else JOptionPane.showMessageDialog(panel_1,"Warning","Update" , JOptionPane.WARNING_MESSAGE);
			}
		});
	}
	protected void infoBD() {
		 Vector cols = new Vector();
		 Vector data = new Vector();
		 TableRowSorter sorter;
		 TableModel model;
		 cols.addElement("MASV");
	     cols.addElement("Họ Tên");
	     cols.addElement("Học kì");
	     cols.addElement("Mã môn");
	     cols.addElement("Mã lớp");
	     cols.addElement("Mã giáo viên");
	     cols.addElement("QT");
	     cols.addElement("TH");
	     cols.addElement("GK");
	     cols.addElement("CK");
	     cols.addElement("ĐTB");
	     cols.addElement("Năm học");
	     InformationTeacher InfoBD=new InformationTeacher();
	     Iterator<AcademicTranscript> iterator =InfoBD.ViewBD().iterator();

	 	while (iterator.hasNext()) {
	 		AcademicTranscript infoC=iterator.next();
	 		 Vector user = new Vector();
	 		 if(infoC.getMAGV().equalsIgnoreCase(info)||types==1)
	 		 {
	 		 user.addElement(infoC.getMASV());
	 		 user.addElement(infoC.getName());
	 		 user.addElement(infoC.getSemester());
	 		 user.addElement(infoC.getSubject());
	 		 user.addElement(infoC.getSClass() );
	 		 user.addElement(infoC.getMAGV());
	 		 user.addElement(""+infoC.getMarkCourse());
	 		 user.addElement(""+infoC.getMarkPractice());
	 		 user.addElement(""+infoC.getMarkMidTerm());
	 		 user.addElement(""+infoC.getExamResults());
	 		 user.addElement(""+infoC.getGPA());
	 		 user.addElement(infoC.getScholastic());
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
	protected void infoBDSV() {
		 Vector cols = new Vector();
		 Vector data = new Vector();
		 TableRowSorter sorter;
		 TableModel model;
	     cols.addElement("Học kì");
	     cols.addElement("Mã môn");
	     cols.addElement("Mã lớp");
	     cols.addElement("Mã giáo viên");
	     cols.addElement("QT");
	     cols.addElement("TH");
	     cols.addElement("GK");
	     cols.addElement("CK");
	     cols.addElement("ĐTB");
	     cols.addElement("Năm học");
	     
	     InformationTeacher InfoBD=new InformationTeacher();
	     Iterator<AcademicTranscript> iterator =InfoBD.ViewBD().iterator();

	 	while (iterator.hasNext()) {
	 		AcademicTranscript infoC=iterator.next();
	 		 Vector user = new Vector();
	 		 if(infoC.getMASV().equalsIgnoreCase(info))
	 		 {
	 		 user.addElement(infoC.getSemester());
	 		 user.addElement(infoC.getSubject());
	 		 user.addElement(infoC.getSClass() );
	 		 user.addElement(infoC.getMAGV());
	 		 user.addElement(""+infoC.getMarkCourse());
	 		 user.addElement(""+infoC.getMarkPractice());
	 		 user.addElement(""+infoC.getMarkMidTerm());
	 		 user.addElement(""+infoC.getExamResults());
	 		 user.addElement(""+infoC.getGPA());
	 		 user.addElement(infoC.getScholastic());
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
	protected void SelectSV()
	{
		InformationStudent infoSV=new InformationStudent();
		AcademicTranscript at=infoSV.ViewBD(masv.getSelectedItem().toString());
		HK.setSelectedItem(at.getSemester());
		mamh.setSelectedItem(at.getSubject());
		malop.setSelectedItem(at.getSClass());
		magv.setSelectedItem(at.getMAGV());
		namhoc.setText(at.getScholastic());
		qt.setText(""+at.getMarkCourse());
		gk.setText(""+at.getMarkMidTerm());
		th.setText(""+at.getMarkPractice());
		ck.setText(""+at.getExamResults());
	}
	protected void SelectComboBox()
	{
		InformationStudent infoSV=new InformationStudent();
		InformationTeacher infoGV=new InformationTeacher();
			List<String> allSV=new ArrayList<String>();
			List<Information> allGV=new ArrayList<Information>();
			List<AcademicTranscript> allLOP=new ArrayList<AcademicTranscript>();
			List<AcademicTranscript> allMH=new ArrayList<AcademicTranscript>();
			allSV=infoSV.ViewAllBD();
			allGV=infoGV.ViewAll();
			allLOP=infoGV.ViewLOP();
			allMH=infoGV.ViewMH();
			Iterator<String> iterator =allSV.iterator();
			Iterator<Information> iteratorGV =allGV.iterator();
			Iterator<AcademicTranscript> iteratorLOP =allLOP.iterator();
			Iterator<AcademicTranscript> iteratorMH =allMH.iterator();
			while (iterator.hasNext()) {
				String infoC=iterator.next();
				masv.addItem(infoC);
			}
			while (iteratorGV.hasNext()) {
				Information infoC=iteratorGV.next();
				magv.addItem(infoC.getID());
			}
			while (iteratorLOP.hasNext()) {
				AcademicTranscript infoC=iteratorLOP.next();
				if(infoC.getSClass().length()>=9)
					malop.addItem(infoC.getSClass());
			}
			while (iteratorMH.hasNext()) {
				AcademicTranscript infoC=iteratorMH.next();
					mamh.addItem(infoC.getSubject());
			}
	}
	protected void SelectComboBox2()
	{
		InformationStudent infoSV=new InformationStudent();
		InformationTeacher infoGV=new InformationTeacher();
		List<String> allSV=new ArrayList<String>();
		List<AcademicTranscript> allMH=new ArrayList<AcademicTranscript>();
		allSV=infoSV.BD(info);
		allMH=infoGV.ViewMHGV(info);
		Iterator<String> iterator =allSV.iterator();
		Iterator<AcademicTranscript> iteratorMH =allMH.iterator();
		while (iterator.hasNext()) {
			String infoC=iterator.next();
			masv.addItem(infoC);
		}
		while (iteratorMH.hasNext()) {
			AcademicTranscript infoC=iteratorMH.next();
			if(infoC.getSClass().equalsIgnoreCase(infoC.getSClass()))
				mamh.addItem(infoC.getSubject());
				malop.addItem(infoC.getSClass());
		}
		magv.addItem(info);
	}
	protected void DTBHK(String sv,String HK,String NH)
	{
		InformationTeacher infoGV=new InformationTeacher();
		List<AcademicTranscript> allBD=new ArrayList<AcademicTranscript>();
		float s=0;
		int i=0;
			allBD=infoGV.ViewTB(sv);
			Iterator<AcademicTranscript> iteratorBD =allBD.iterator();
			while (iteratorBD.hasNext()) {
				AcademicTranscript infoS=iteratorBD.next();
				if(infoS.getSemester().equalsIgnoreCase(HK)&&infoS.getScholastic().equalsIgnoreCase(NH))
				{
				s=s+infoS.getGPA()*infoS.getCredit();
				i=i+infoS.getCredit();
				}
			}
			s=s/i;
			infoGV.updateTBHK(sv,s, panel_1);
	}
}
