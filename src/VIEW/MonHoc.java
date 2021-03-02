package VIEW;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import CONTROL.AcademicTranscript;
import CONTROL.Information;
import MODEL.InformationTeacher;

import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;

public class MonHoc extends JPanel {
	private JTextField mamh;
	private JTextField tenmh;
	private JTextField malop;
	private JTextField qt;
	private JTextField th;
	private JTextField gk;
	private JTextField ck;
	private JTable table;
	private JComboBox magv = new JComboBox();
	private DefaultTableModel defaultTable;
	/**
	 * Create the panel.
	 */
	String info;
	int typeSV;
	public MonHoc(String in,int type) {
		info=in;
		typeSV=type;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 30, 30, 30};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel MH = new JLabel("M\u00E3 m\u00F4n");
		MH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_MH = new GridBagConstraints();
		gbc_MH.fill = GridBagConstraints.VERTICAL;
		gbc_MH.insets = new Insets(0, 0, 5, 5);
		gbc_MH.anchor = GridBagConstraints.WEST;
		gbc_MH.gridx = 0;
		gbc_MH.gridy = 1;
		panel.add(MH, gbc_MH);
		
		mamh = new JTextField();
		GridBagConstraints gbc_mamh = new GridBagConstraints();
		gbc_mamh.fill = GridBagConstraints.BOTH;
		gbc_mamh.insets = new Insets(0, 0, 5, 5);
		gbc_mamh.gridx = 1;
		gbc_mamh.gridy = 1;
		panel.add(mamh, gbc_mamh);
		mamh.setColumns(10);
		
		JLabel LMH = new JLabel("Lo\u1EA1i m\u00F4n h\u1ECDc");
		LMH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_LMH = new GridBagConstraints();
		gbc_LMH.fill = GridBagConstraints.VERTICAL;
		gbc_LMH.anchor = GridBagConstraints.WEST;
		gbc_LMH.insets = new Insets(0, 0, 5, 5);
		gbc_LMH.gridx = 5;
		gbc_LMH.gridy = 1;
		panel.add(LMH, gbc_LMH);
		
		JComboBox loaimh = new JComboBox();
		loaimh.setModel(new DefaultComboBoxModel(new String[] {"", "CN", "CNTC", "C\u0110TN", "CNCS", "KLTN", "TTTN", "\u0110C"}));
		GridBagConstraints gbc_loaimh = new GridBagConstraints();
		gbc_loaimh.insets = new Insets(0, 0, 5, 0);
		gbc_loaimh.fill = GridBagConstraints.BOTH;
		gbc_loaimh.gridx = 6;
		gbc_loaimh.gridy = 1;
		panel.add(loaimh, gbc_loaimh);
		
		JLabel TMH = new JLabel("T\u00EAn m\u00F4n");
		TMH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_TMH = new GridBagConstraints();
		gbc_TMH.fill = GridBagConstraints.VERTICAL;
		gbc_TMH.anchor = GridBagConstraints.WEST;
		gbc_TMH.insets = new Insets(0, 0, 5, 5);
		gbc_TMH.gridx = 0;
		gbc_TMH.gridy = 2;
		panel.add(TMH, gbc_TMH);
		
		tenmh = new JTextField();
		GridBagConstraints gbc_tenmh = new GridBagConstraints();
		gbc_tenmh.fill = GridBagConstraints.BOTH;
		gbc_tenmh.insets = new Insets(0, 0, 5, 5);
		gbc_tenmh.gridx = 1;
		gbc_tenmh.gridy = 2;
		panel.add(tenmh, gbc_tenmh);
		tenmh.setColumns(10);
		
		JLabel QT = new JLabel("Qu\u00E1 tr\u00ECnh");
		QT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_QT = new GridBagConstraints();
		gbc_QT.fill = GridBagConstraints.VERTICAL;
		gbc_QT.anchor = GridBagConstraints.WEST;
		gbc_QT.insets = new Insets(0, 0, 5, 5);
		gbc_QT.gridx = 5;
		gbc_QT.gridy = 2;
		panel.add(QT, gbc_QT);
		
		qt = new JTextField();
		qt.setColumns(10);
		GridBagConstraints gbc_qt = new GridBagConstraints();
		gbc_qt.insets = new Insets(0, 0, 5, 0);
		gbc_qt.fill = GridBagConstraints.BOTH;
		gbc_qt.gridx = 6;
		gbc_qt.gridy = 2;
		panel.add(qt, gbc_qt);
		
		JLabel ST = new JLabel("S\u1ED1 ti\u1EBFt");
		ST.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_ST = new GridBagConstraints();
		gbc_ST.anchor = GridBagConstraints.WEST;
		gbc_ST.insets = new Insets(0, 0, 5, 5);
		gbc_ST.gridx = 0;
		gbc_ST.gridy = 3;
		panel.add(ST, gbc_ST);
		
		JSpinner sotiet = new JSpinner();
		sotiet.setModel(new SpinnerNumberModel(0, 0, 6, 1));
		sotiet.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_sotiet = new GridBagConstraints();
		gbc_sotiet.fill = GridBagConstraints.HORIZONTAL;
		gbc_sotiet.insets = new Insets(0, 0, 5, 5);
		gbc_sotiet.gridx = 1;
		gbc_sotiet.gridy = 3;
		panel.add(sotiet, gbc_sotiet);
		
		JLabel TH = new JLabel("Th\u1EF1c h\u00E0nh");
		TH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_TH = new GridBagConstraints();
		gbc_TH.anchor = GridBagConstraints.WEST;
		gbc_TH.insets = new Insets(0, 0, 5, 5);
		gbc_TH.gridx = 5;
		gbc_TH.gridy = 3;
		panel.add(TH, gbc_TH);
		
		th = new JTextField();
		th.setColumns(10);
		GridBagConstraints gbc_th = new GridBagConstraints();
		gbc_th.insets = new Insets(0, 0, 5, 0);
		gbc_th.fill = GridBagConstraints.BOTH;
		gbc_th.gridx = 6;
		gbc_th.gridy = 3;
		panel.add(th, gbc_th);
		
		JLabel MK = new JLabel("M\u00E3 khoa");
		MK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_MK = new GridBagConstraints();
		gbc_MK.fill = GridBagConstraints.VERTICAL;
		gbc_MK.insets = new Insets(0, 0, 5, 5);
		gbc_MK.anchor = GridBagConstraints.WEST;
		gbc_MK.gridx = 0;
		gbc_MK.gridy = 4;
		panel.add(MK, gbc_MK);
		
		JComboBox makhoa = new JComboBox();
		makhoa.setModel(new DefaultComboBoxModel(new String[] {"", "CNTT", "KHMT", "KTMT", "CNPM", "KTPM", "HTTT", "ATTT"}));
		GridBagConstraints gbc_makhoa = new GridBagConstraints();
		gbc_makhoa.fill = GridBagConstraints.BOTH;
		gbc_makhoa.insets = new Insets(0, 0, 5, 5);
		gbc_makhoa.gridx = 1;
		gbc_makhoa.gridy = 4;
		panel.add(makhoa, gbc_makhoa);
		
		JLabel GK = new JLabel("Gi\u1EEFa k\u1EF3");
		GK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_GK = new GridBagConstraints();
		gbc_GK.fill = GridBagConstraints.VERTICAL;
		gbc_GK.anchor = GridBagConstraints.WEST;
		gbc_GK.insets = new Insets(0, 0, 5, 5);
		gbc_GK.gridx = 5;
		gbc_GK.gridy = 4;
		panel.add(GK, gbc_GK);
		
		gk = new JTextField();
		gk.setColumns(10);
		GridBagConstraints gbc_gk = new GridBagConstraints();
		gbc_gk.insets = new Insets(0, 0, 5, 0);
		gbc_gk.fill = GridBagConstraints.BOTH;
		gbc_gk.gridx = 6;
		gbc_gk.gridy = 4;
		panel.add(gk, gbc_gk);
		
		JLabel ML = new JLabel("M\u00E3 l\u1EDBp");
		ML.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_ML = new GridBagConstraints();
		gbc_ML.fill = GridBagConstraints.VERTICAL;
		gbc_ML.insets = new Insets(0, 0, 5, 5);
		gbc_ML.anchor = GridBagConstraints.WEST;
		gbc_ML.gridx = 0;
		gbc_ML.gridy = 5;
		panel.add(ML, gbc_ML);
		
		malop = new JTextField();
		GridBagConstraints gbc_malop = new GridBagConstraints();
		gbc_malop.fill = GridBagConstraints.BOTH;
		gbc_malop.insets = new Insets(0, 0, 5, 5);
		gbc_malop.gridx = 1;
		gbc_malop.gridy = 5;
		panel.add(malop, gbc_malop);
		malop.setColumns(10);
		
		JLabel CK = new JLabel("Cu\u1ED1i k\u1EF3");
		CK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_CK = new GridBagConstraints();
		gbc_CK.fill = GridBagConstraints.VERTICAL;
		gbc_CK.anchor = GridBagConstraints.WEST;
		gbc_CK.insets = new Insets(0, 0, 5, 5);
		gbc_CK.gridx = 5;
		gbc_CK.gridy = 5;
		panel.add(CK, gbc_CK);
		
		ck = new JTextField();
		ck.setColumns(10);
		GridBagConstraints gbc_ck = new GridBagConstraints();
		gbc_ck.insets = new Insets(0, 0, 5, 0);
		gbc_ck.fill = GridBagConstraints.BOTH;
		gbc_ck.gridx = 6;
		gbc_ck.gridy = 5;
		panel.add(ck, gbc_ck);
		
		JLabel MAGV = new JLabel("M\u00E3 gi\u00E1o vi\u00EAn");
		MAGV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_MAGV = new GridBagConstraints();
		gbc_MAGV.fill = GridBagConstraints.VERTICAL;
		gbc_MAGV.insets = new Insets(0, 0, 5, 5);
		gbc_MAGV.anchor = GridBagConstraints.WEST;
		gbc_MAGV.gridx = 0;
		gbc_MAGV.gridy = 6;
		panel.add(MAGV, gbc_MAGV);
		
		
		GridBagConstraints gbc_magv = new GridBagConstraints();
		gbc_magv.insets = new Insets(0, 0, 5, 5);
		gbc_magv.fill = GridBagConstraints.BOTH;
		gbc_magv.gridx = 1;
		gbc_magv.gridy = 6;
		panel.add(magv, gbc_magv);
		
		JLabel TC = new JLabel("Tín chỉ");
		TC.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_TC = new GridBagConstraints();
		gbc_TC.fill = GridBagConstraints.VERTICAL;
		gbc_TC.anchor = GridBagConstraints.WEST;
		gbc_TC.insets = new Insets(0, 0, 5, 5);
		gbc_TC.gridx = 5;
		gbc_TC.gridy = 6;
		panel.add(TC, gbc_TC);
		
		JSpinner sotc = new JSpinner();
		sotc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_sotc = new GridBagConstraints();
		gbc_sotc.fill = GridBagConstraints.BOTH;
		gbc_sotc.insets = new Insets(0, 0, 5, 0);
		gbc_sotc.gridx = 6;
		gbc_sotc.gridy = 6;
		panel.add(sotc, gbc_sotc);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 7;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 8;
		panel.add(panel_1, gbc_panel_1);
		
		JButton them = new JButton("Th\u00EAm");
		them.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		panel_1.add(them);
		
		JButton Capnhat = new JButton("C\u1EADp nh\u1EADt");
		
		Capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_1.add(Capnhat);
		
		JButton xoa = new JButton("Xo\u00E1");
		
		xoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_1.add(xoa);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		if(type==1)
		{
			 Giaovien();
			 
		}
		else if(type==2)
		{
			panel_1.setEnabled(false);
			 panel_1.setVisible(false);
			
			 mamh.setVisible(false);
			 MH.setVisible(false);
			 tenmh.setVisible(false);
			 TMH.setVisible(false);
			 magv.setVisible(false);
			 MAGV.setVisible(false);
			 sotiet.setVisible(false);
			 ST.setVisible(false);
			 makhoa.setVisible(false);
			 MK.setVisible(false);
			 sotc.setVisible(false);
			 TC.setVisible(false);
			 malop.setVisible(false);
			 ML.setVisible(false);
			 loaimh.setVisible(false);
			 LMH.setVisible(false);
			 qt.setVisible(false);
			 QT.setVisible(false);
			 th.setVisible(false);
			 TH.setVisible(false);
			 gk.setVisible(false);
			 GK.setVisible(false);
			 ck.setVisible(false);
			 CK.setVisible(false);
		}
		infoBD();
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
	                                if(i==0) mamh.setText(str);
	                                if(i==1) magv.setSelectedItem(str);
	                                if(i==2) tenmh.setText(str);
	                                if(i==3) sotiet.setValue(Integer.parseInt(str));
	                                if(i==4) makhoa.setSelectedItem(str);
	                                if(i==5) loaimh.setSelectedItem(str);
	                                if(i==6) sotc.setValue(Integer.parseInt(str));
	                                if(i==7) malop.setText(str);
	                                if(i==8) qt.setText(str);
	                                if(i==9) th.setText(str);
	                                if(i==10) gk.setText(str);
	                                if(i==11) ck.setText(str);
	                                
	            }
			}
		});
//event button
		//them
		them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 InformationTeacher InfoBD=new InformationTeacher();
				if(mamh.getText()!=null&&malop.getText()!=null)
				{
					
					if(mamh.getText().contains(".")==true||malop.getText().contains(".")==false)
					{
						JOptionPane.showMessageDialog(panel_1,"Error Fail","ERROR" , JOptionPane.ERROR_MESSAGE);
					}
					else
						{
						AcademicTranscript SV=new AcademicTranscript();
						SV.setSubject(mamh.getText());
						SV.setSubjectName(tenmh.getText());
						SV.setMAGV(magv.getSelectedItem().toString());
						SV.setSotiet((Integer)sotiet.getValue());
						SV.setMaKhoa(makhoa.getSelectedItem().toString());
						SV.setTypeSubject(loaimh.getSelectedItem().toString());
						SV.setCredit((Integer)sotc.getValue());
						SV.setSClass(malop.getText());
						SV.setProportionCourse(Float.parseFloat(qt.getText()));
						SV.setProportionPractice(Float.parseFloat(th.getText()));
						SV.setProportionMidTerm(Float.parseFloat(gk.getText()));
						SV.setProportionFinal(Float.parseFloat(ck.getText()));
						if(InfoBD.insertLOP(SV, panel_1)==1)
							InfoBD.insertMH(SV, panel_1);
						}
				}
			}
		});
	//cập nhật
		Capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 InformationTeacher InfoBD=new InformationTeacher();
				if(mamh.getText()!=null&&malop.getText()!=null)
				{
					AcademicTranscript SV=new AcademicTranscript();
					SV.setSubject(mamh.getText());
					SV.setSubjectName(tenmh.getText());
					SV.setMAGV(magv.getSelectedItem().toString());
					SV.setSotiet((Integer)sotiet.getValue());
					SV.setMaKhoa(makhoa.getSelectedItem().toString());
					SV.setTypeSubject(loaimh.getSelectedItem().toString());
					SV.setCredit((Integer)sotc.getValue());
					SV.setSClass(malop.getText());
					SV.setProportionCourse(Float.parseFloat(qt.getText()));
					SV.setProportionPractice(Float.parseFloat(th.getText()));
					SV.setProportionMidTerm(Float.parseFloat(gk.getText()));
					SV.setProportionFinal(Float.parseFloat(ck.getText()));
					InfoBD.updateMH(SV, panel_1);
					InfoBD.updateLOP(SV, panel_1);
				}
				
			}
		});
//xoá
		xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformationTeacher InfoBD=new InformationTeacher();
				if(InfoBD.deleteMH(malop.getText(), panel_1)!=0)
					InfoBD.deleteLOP(malop.getText(), panel_1);
				
			}
		});
	}
	protected void infoBD() {
		 Vector cols = new Vector();
		 Vector data = new Vector();
		 TableRowSorter sorter;
		 TableModel model;
		 cols.addElement("Mamh");
		 cols.addElement("Magv");
	     cols.addElement("Tên môn");
	     cols.addElement("Số tiết");
	     cols.addElement("Mã khoa");
	     cols.addElement("loại");
	     cols.addElement("Số tc");
	     cols.addElement("Mã lớp");
	     cols.addElement("TLQT");
	     cols.addElement("TLTH");
	     cols.addElement("TLGK");
	     cols.addElement("TLCK");
	     
	     InformationTeacher InfoBD=new InformationTeacher();
	     List<AcademicTranscript> allSV=new ArrayList<AcademicTranscript>();

	     if(typeSV==1)
	    	allSV= InfoBD.ViewMD();
	     else
	    	 if(typeSV==2)
	    		allSV= InfoBD.ViewMDSV(info);
	     Iterator<AcademicTranscript> iterator=allSV.iterator();
	 	while (iterator.hasNext()) {
	 		AcademicTranscript infoC=iterator.next();
	 		 Vector user = new Vector();
	 		 user.addElement(infoC.getSubject());
	 		user.addElement(infoC.getMAGV());
	 		 user.addElement(infoC.getSubjectName());
	 		 user.addElement(""+infoC.getSotiet());
	 		 user.addElement(infoC.getMaKhoa());
	 		 user.addElement(infoC.getTypeSubject() );
	 		 user.addElement(""+infoC.getCredit());
	 		 user.addElement(infoC.getSClass());
	 		 user.addElement(""+infoC.getProportionCourse());
	 		 user.addElement(""+infoC.getProportionPractice());
	 		 user.addElement(""+infoC.getProportionMidTerm());
	 		 user.addElement(""+infoC.getProportionFinal());
	 		 data.add(user);
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
	protected void Giaovien()
	{   InformationTeacher InfoBD=new InformationTeacher();
		List<Information> allGV=new ArrayList<Information>();
		allGV=InfoBD.ViewAll();
		Iterator<Information> iteratorGV =allGV.iterator();
		while (iteratorGV.hasNext()) {
			Information infoC=iteratorGV.next();
			magv.addItem(infoC.getID());
		}
	}
}